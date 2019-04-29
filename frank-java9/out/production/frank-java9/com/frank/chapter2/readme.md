|操 作 | 类 型 | 功能|
|------- |------ |------ |
|filter  |中间 ||
|map |中间 ||
|skip |中间 |跳过元素|
|distinct|中间 |去重|
|limit|中间 |截取|
|sorted|中间 |排序|
|forEach |终端 ||
|count |终端 |行数 |
|collect |终端 | |

### 流的扁平化
有使用map(Arrays::stream)时生成的单个流都被合并起来，即扁平化为一个流
```javascript 1.8
List<String> uniqueCharacters =
 words.stream()
 .map(w -> w.split(""))     //生成流
 .flatMap(Arrays::stream) //将生成的所有单个流组成一个流
 .distinct()
 .collect(Collectors.toList());
```

### 查找和匹配
过allMatch、anyMatch、noneMatch、findFirst和findAny方法提供了这样的工具
#### anyMatch
anyMatch方法可以回答“流中是否有一个元素能匹配给定的谓词”。
if(menu.stream().anyMatch(Dish::isVegetarian)){
 System.out.println("The menu is (somewhat) vegetarian friendly!!");
} 
#### allMatch
检查谓词是否匹配所有元素
boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000); 

#### noneMatch
和allMatch相对的

### 查找元素
```javascript 1.8
Optional<Dish> dish =
 menu.stream()
 .filter(Dish::isVegetarian)
 .findAny(); 
 //.ifPresent(d -> System.out.println(d.getName()); 
 ```
 #### Optional简介
 * isPresent()将在Optional包含值的时候返回true, 否则返回false。
 * ifPresent(Consumer<T> block)会在值存在的时候执行给定的代码块.
 * T get()会在值存在时返回值，否则抛出一个NoSuchElement异常。
 * T orElse(T other)会在值存在时返回值，否则返回一个默认值。
 
 ### 查找第一个元素
 findFirst和findAny
 
 ### 归约
 reduce操作是如何作用于一个流的：Lambda反复结合每个元素，直到流被归约成一个值。
 ```javascript 1.8
  // 元素求和
 int sum = numbers.stream().reduce(0, (a, b) -> a + b); 
 int product = numbers.stream().reduce(1, (a, b) -> a * b); 
 // 最大值和最小值
 Optional<Integer> max = numbers.stream().reduce(Integer::max); 
 Optional<Integer> min = numbers.stream().reduce(Integer::min); 
  ```
 ### 创建流
  ```javascript 1.8
  // 由值创建流
  Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
  stream.map(String::toUpperCase).forEach(System.out::println); 
  // 你可以使用empty得到一个空流
  Stream<String> emptyStream = Stream.empty();
  //由数组创建流
  int[] numbers = {2, 3, 5, 7, 11, 13};
  int sum = Arrays.stream(numbers).sum();
   ```