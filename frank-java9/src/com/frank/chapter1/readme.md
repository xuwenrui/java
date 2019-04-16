### 使用Stream和Lambda表达式过滤数据
```javascript 1.8
List<Apple> redApples=apples.stream().filter((Apple a) -> a.getWeight()>100).collect(Collectors.toList());
```
### 用 Comparator 来排序
```javascript 1.8
 apples.sort(Comparator.comparingInt(Apple::getWeight));
//        apples.sort((Apple a1, Apple a2) -> Integer.compare(a1.getWeight(), a2.getWeight()));
```

###  用 Runnable 执行代码块
```javascript 1.8
Thread t = new Thread(() -> System.out.println("Hello world")); 
```

### Lambda示例
| 使用案例  | Lambda示例 |
| ------ | ------ | 
| 布尔表达式 | (List<String> list) -> list.isEmpty()  | 
| 创建对象 | () -> new Apple(10)  | 
| 消费一个对象  |  (String s) -> s.length()  | 
| 从一个对象中选择/抽取  | (Apple a) -> { <br> System.out.println(a.getWeight());<br> }   | 
| 组合两个值  |  (int a, int b) -> a * b  | 
| 比较两个对象  |  (Apple a1, Apple a2) -><br> a1.getWeight().compareTo(a2.getWeight())  | 

### Java API中的一些其他函数式接口
```javascript 1.8
java.util.function.Predicate
java.util.Comparator
java.lang.Runnable
java.awt.event.ActionListener 
java.security.PrivilegedAction 
```
### 函数式接口
    函数式接口就是只定义一个抽象方法的接口。 
    
### 谓词复合
谓词接口包括三个方法：negate(非)、and和or

### 函数复合
```javascript 1.8
// andThen 先给数字加1，再给结果乘2
Function<Integer, Integer> f = x -> x + 1;
Function<Integer, Integer> g = x -> x * 2;
Function<Integer, Integer> h = f.andThen(g);

// compose 先给数字乘2，再给结果加1。先把给定的函数用作compose的参数里面给的那个函
//                         数，然后再把函数本身用于结果
Function<Integer, Integer> f = x -> x + 1;
Function<Integer, Integer> g = x -> x * 2;
Function<Integer, Integer> h = f.compose(g);
int result = h.apply(1); 
```

