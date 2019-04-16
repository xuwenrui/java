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