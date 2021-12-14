# Java-Notes
Sugaoji's code journey on Java.  
宿高吉的Java笔记。  

## 第一天:sunny: 
### hashcode:cloud:
* 不同元素对应的hashcode值可能相同，在集合中hashcode值相同的会放在一个集中区域，在查找一个元素时，首先通过hashcode确定大概区域，然后再用equals去找。  
* hashcode() 和 equals()重写时，要保证这么一个事实：hashcode()值相等才能equals()值相等；如果equal()值相等必须hashcode()值也相等。 
* 也就是说hashcode集合包含equals集合
   
### 泛型:cloud:
* 代码
```Java
      public static < E > void printArray( E[] inputArray ){ ... } 泛型方法  
      public static <T extends Comparable<T>> T maximum(T x, T y, T z){ ... } 泛型方法  
      public class Box<T> { ... } 或者 public class Box<T, V> { ... } 泛型类  
      public static void getData(List<?> data) { ... } 通配符
```
* 👆上面用到的 T、V、E，都是类型变量，这种变量是装类型名称的，也就是实例化时会赋予真正的类名，然后T、V、E等就表示这个类名。比如语句 Box <String> box = new Box("Hello world")这时候T就会代表String。 而 <T extends Comparable<T>> 的意思是 只有继承了 Comparable的变量类型才能被T代表。  

  
## 第二天:sunny:  
### 序列化:cloud:
* 序列化就是将一个对象变成输出流（然后存在一个文件里面-一般是这样），反序列化就是将一个输入流（前提是该输入流来自前面那种文件）变为一个类，默认是Object类，你可以自己转换。  
* 一个对象能实现序列化前提是他所在类实现了Serializable接口 👇
```Java
public class Employee implements java.io.Serializable { ... }
```
* 对象中成员变量必须都是可序列化的，才能进行序列化，如果有个不能序列化，可以用transient 标记 👇
```Java
public transient int SSN;
```
* 序列化代码 👇
```Java
try
      {
         FileOutputStream fileOut =
         new FileOutputStream("/tmp/employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in /tmp/employee.ser");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
```
* 反序列化代码 👇
```Java
	  try
      {
         FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Employee) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
```
* 序列化主要用处是将对象状态保存在文件中，多用于多线程。
   
   
   
   
