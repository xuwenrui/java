## 用流收集数据
### 归约和汇总
```javascript 1.8
long howManyDishes = menu.stream().collect(Collectors.counting());
// 这还可以写得更为直接：
long howManyDishes = menu.stream().count(); 
// 查找流中的最大值和最小值
Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator)); 
//汇总
int totalCalories = menu.stream().collect(summingInt(Dish::getCalories)); 
//平均值
IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories)); 
//连接字符串
String shortMenu = menu.stream().map(Dish::getName).collect(joining()); 
// 分组
Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType)); 
```