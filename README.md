# Java-notes
Sugaoji's code journey on Java.
宿高吉的Java笔记。

第一天：
   不同元素对应的hashcode值可能相同，在集合中hashcode值相同的会放在一个集中区域，在查找一个元素时，首先通过hashcode确定大概区域，然后再用equals去找。
   hashcode() 和 equals()重写时，要保证这么一个事实：hashcode()值相等才能equals()值相等；如果equal()值相等必须hashcode()值也相等。 也就是说hashcode集合包含equals集合
   
