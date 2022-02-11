# 一、Java基础

```java
//数据类型 内置数据类型和引用数据类型
8种基本类型
    byte 1个字节
    short 2个字节
    int 4个字节
    long 8个字节
    float 4个字节
    double 8个字节
    boolean
    char 2个字节 Unicode
引用数据类型 类似指针

//常量 final关键字 一般用大写
    final double PI = 3.1415927;
//自动类型转换 数值和char之间 以及一些其他相关类型之间才能转换
	float->int;是舍弃小数
//变量
	int d = 3, e = 4, f = 5;
	类变量：独立于方法之外的变量，用 static 修饰。
    局部变量 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。
    实例变量 实例变量具有默认值。数值型变量的默认值是0，布尔型变量的默认值是false，引用类型变量的默认值是null。变量的值可以在声明时指定，也可以在构造方法中指定；
    实例变量对于类中的方法、构造方法或者语句块是可见的。一般情况下应该把实例变量设为私有。通过使用访问修饰符可以使实例变量对子类可见
//访问控制修饰符
    protected -> 同一包内或者子类中可见
    private   -> 自己可见
    public    -> 公开
  	父类中声明为 public 的方法在子类中也必须为 public。
    父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
    父类中声明为 private 的方法，不能够被子类继承。
//非访问控制修饰符
    static 修饰符，用来修饰类方法和类变量（表公共）
    final 修饰符，用来修饰类(不能被继承)、方法(不能被重写)和变量(不能被修改)
    abstract 修饰符，用来创建抽象类和抽象方法
    synchronized 和 volatile 修饰符，主要用于线程的编程
        synchronized 关键字声明的方法同一时间只能被一个线程访问。
        transient 修饰符
        volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
//运算符 instanceof
        
//循环
    Java5 引入了一种主要用于数组的增强型 for 循环。
    Java 增强 for 循环语法格式如下:
	for(声明语句 : 表达式)
//条件语句
	if if-else (if-else if-else)
//switch case
    byte、short、int、char、String
	switch(expression){
        case value :
           //语句
           break; //可选
        case value :
           //语句
           break; //可选
        //你可以有任意数量的case语句
        default : //可选
           //语句
	}
//封装打包类
	在实际开发过程中，我们经常会遇到需要使用对象，而不是内置数据类型的情形
	所有的包装类（Integer、Long、Byte、Double、Float、Short）都是抽象类 Number 的子类
  	编译器可以识别装箱和开箱
    Character类
//Java 的 Math 
    包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数
    Math 的方法都被定义为 static 形式

//String 类
	String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上：
    char[] s = {}
	是一个常量，不支持原地修改
//StringBuffer StringBuilder
    StringBuilder 不是线程安全的，不能被同步访问，速度快
    StringBuffer 线程安全，能同步访问
    当字符串需要被频繁修改，建议用StringBuilder
//数组 Array工具类(排序)
//方法 可变参数 finalize() 方法 它在对象被垃圾收集器析构(回收)之前调用
```

```java
//IO 流和文件
    字符流和字节流 处理流和节点流 我感觉所有的字符流都像是处理流或者装饰者(从更底层一点来看,都是对字节流的封装)
    但是一般将其理解为不管是字符流或者字节流都有节点流，虽然字符流的节点流都是对字节流的封装
    
    java.util.Scanner 是 Java5 的新特征，我们可以通过 Scanner 类来获取用户的输入。
```

```java
//面向对象
//单继承 接口可以被多继承 继承可以提高代码的复用性 但是类之间的耦合度会提高
    public class C implements A,B {
    }
//重写是相对于继承而言,参数不能变 重载是在同一个类中,参数必须变
//多态 多态就是同一个接口，使用不同的实例而执行不同操作，向上转型
	多态存在的必要条件：继承 重写 向上转型
    三种形式，子类重写父类，子类重写接口，子类重写抽象类中的抽象方法
//抽象类
    如果一个类包含抽象方法，那么该类必须是抽象类。
    任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
	抽象类不一定有抽象方法，因为子类之间的共性，可能只是用到了属性，而用不到方法
//封装
    就是将实现隐藏，只是留给外部接口，像类和方法就是一种封装
    可以利用访问修饰符 以及get set方法
//接口 是抽象方法的集合
   	接口并不是类
    接口之间可以多继承
    接口中的方法都是公有的 public
    接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象
        
    除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。
    如果实现接口的类是抽象类，那么就没必要实现该接口的方法。
    类在实现接口的方法时，不能抛出强制性异常，只能在接口中，或者继承接口的抽象类中抛出该强制性异常(非运行时异常)。
    也就是只能捕捉异常，而不能直接抛出异常
    
    接口不能包含成员变量，除了 static 和 final 变量。
    JDK 1.8 以后，接口里可以有静态方法和方法体了。
    JDK 1.8 以后，接口允许包含具体实现的方法，该方法称为"默认方法"，默认方法使用 default 关键字修饰。
    没有任何方法的接口被称为标记接口。标记接口主要用于以下两种目的
    被接口继承，变成某类接口
    被某个类实现，变成某类接口的实现类

//枚举类
所有的枚举值都是 public static final 的
```

关于继承的一点理解：

- 父类是抽象类还是非抽象类

  有的时候父类中的东西可能就是子类中的一些重合部分，就是一个中间产物，不需要产生对象，就定义为抽象类

  有的时候父类可能需要产生一个对象

- 接口和抽象类

  接口是一套规范，可以说某个类实现了哪些接口制定的规范

  抽象类更强调一种继承关系，就是对子类中的共性的一种层次化封装

![](https://www.runoob.com/wp-content/uploads/2014/01/2243690-9cd9c896e0d512ed.gif)

虚线空心箭头，代表继承(实现)接口

实线空心箭头，代表继承类

虚线实心箭头，代表接口之间的依赖或者关联关系

```java
//java高级
//java数据结构 传统遗留框架
Java工具包提供了强大的数据结构。在Java中的数据结构主要包括以下几种接口和类：
枚举（Enumeration）：接口，现在一般用迭代器，实现了这个接口的类是可迭代对象，hasNaxt和next
位集合（BitSet）：标记类，某个位置进行设数 set get
向量（Vector）：动态数组，和 ArrayList 很相似，Vector 是同步访问的 add
栈（Stack）：后进先出（LIFO） push pop
字典（Dictionary）：字典（Dictionary） 类是一个抽象类，它定义了键映射到值的数据结构。已经很少用
哈希表（Hashtable）：Hashtable是原始的java.util的一部分， 是一个Dictionary具体的实现 
    重构的Hashtable实现了Map接口，因此，Hashtable现在集成到了集合框架中。它和HashMap类很相似，但是它支持同步
    put get
属性（Properties）：Properties 继承于 Hashtable。是一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
    Properties 类被许多 Java 类使用。例如，在获取环境变量时它就作为 System.getProperties() 方法的返回值。

//java集合框架 具有高度的互操作性
Set:Set检索效率低下因为可能不是直接索引，删除和插入效率高，插入和删除不会引起元素位置改变 <实现类有HashSet,TreeSet>
    
List和数组类似，根据实际存储的数据的长度自动增长List的长度。查找元素效率高，插入删除效率低，因为会引起其他元素位置改变 <实现类有ArrayList,LinkedList,Vector>
    
Set 和 Map在实现上的相似性 （tree hash sorted）

//接口的实现
List
    LinkedList
    该类实现了List接口，允许有null（空）元素。主要用于创建链表数据结构，该类没有同步方法，如果多个线程同时访问一个List，则必须自己实现访问同步，解决方法就是在创建List时候构造一个同步的List。例如：
    List list=Collections.synchronizedList(newLinkedList(...));
	查找效率低
    
    ArrayList
    该类也是实现了List的接口，实现了可变大小的数组，随机访问和遍历元素时，提供更好的性能。该类也是非同步的,在多线程的情况下不要使用。ArrayList 增长当前长度的50%，插入删除效率低。
 
Set
    HashSet
该类实现了Set接口，不允许出现重复元素，不保证集合中元素的顺序，允许包含值为null的元素，但最多只能一个。
    TreeSet
该类实现了Set接口，可以实现排序等功能。
   
Map
    HashMap
    HashMap 是一个散列表，它存储的内容是键值对(key-value)映射。
    该类实现了Map接口，根据键的HashCode值存储数据，具有很快的访问速度，最多允许一条记录的键为null，不支持线程同步。
    TreeMap
	继承了AbstractMap，并且使用一颗树。
```



```java
//遍历ArrayList
import java.util.*;
 
public class Test{
 public static void main(String[] args) {
     List<String> list=new ArrayList<String>();
     list.add("Hello");
     list.add("World");
     list.add("HAHAHAHA");
     //第一种遍历方法使用 For-Each 遍历 List
     for (String str : list) {            //也可以改写 for(int i=0;i<list.size();i++) 这种形式
        System.out.println(str);
     }
 
     //第二种遍历，把链表变为数组相关的内容进行遍历
     String[] strArray=new String[list.size()];
     list.toArray(strArray);
     for(int i=0;i<strArray.length;i++) //这里也可以改写为  for(String str:strArray) 这种形式
     {
        System.out.println(strArray[i]);
     }
     
    //第三种遍历 使用迭代器进行相关遍历
     
     Iterator<String> ite=list.iterator();
     while(ite.hasNext())//判断下一个元素之后有值
     {
         System.out.println(ite.next());
     }
 }
}


//遍历Map
import java.util.*;
 
public class Test{
     public static void main(String[] args) {
      Map<String, String> map = new HashMap<String, String>();
      map.put("1", "value1");
      map.put("2", "value2");
      map.put("3", "value3");
      
      //第一种：普遍使用，二次取值
      System.out.println("通过Map.keySet遍历key和value：");
      for (String key : map.keySet()) {
       System.out.println("key= "+ key + " and value= " + map.get(key));
      }
      
      //第二种
      System.out.println("通过Map.entrySet使用iterator遍历key和value：");
      Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
      while (it.hasNext()) {
       Map.Entry<String, String> entry = it.next();
       System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
      }
      
      //第三种：推荐，尤其是容量大时
      System.out.println("通过Map.entrySet遍历key和value");
      for (Map.Entry<String, String> entry : map.entrySet()) {
       System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
      }
    
      //第四种
      System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
      for (String v : map.values()) {
       System.out.println("value= " + v);
      }
     }
}
```



```java
//集合与算法
接口Collection中提供了很多的静态方法
//集合与迭代器
集合与迭代器关系：集合依赖于迭代器，集合接口依赖于迭代器接口，集合中提供了产生迭代器对象的方法
//集合与比较器
1、Comparable接口，需要排序的自定义类需要继承(实现这个接口)，重写一个compareTo(A)方法
2、Comparator接口，需要单独另外写一个类来实现这个接口，重写一个compare(A,B)方法
3、匿名内部类的方式，new Comparator<E>(){}
Set<Person> set=new TreeSet<>(new Comparator<Person>(){
            public int compare(Person p1,Person p2){
                if(p1.age==p2.age){
                    return p1.name.compareTo(p2.name);
                }else{
                    return p1.age-p2.age;
                }
            }
        });
```

==Object类是所有类的父类==

| 序号 | 方法 & 描述                                                  |
| :--- | :----------------------------------------------------------- |
| 1    | [protected Object clone()](https://www.runoob.com/java/java-object-clone.html)创建并返回一个对象的拷贝 |
| 2    | [boolean equals(Object obj)](https://www.runoob.com/java/java-object-equals.html)比较两个对象是否相等 |
| 3    | [protected void finalize()](https://www.runoob.com/java/java-object-finalize.html)当 GC (垃圾回收器)确定不存在对该对象的有更多引用时，由对象的垃圾回收器调用此方法。 |
| 4    | [Class getClass()](https://www.runoob.com/java/java-object-getclass.html)获取对象的运行时对象的类 |
| 5    | [int hashCode()](https://www.runoob.com/java/java-object-hashcode.html)获取对象的 hash 值 |
| 6    | [void notify()](https://www.runoob.com/java/java-object-notify.html)唤醒在该对象上等待的某个线程 |
| 7    | [void notifyAll()](https://www.runoob.com/java/java-object-notifyall.html)唤醒在该对象上等待的所有线程 |
| 8    | [String toString()](https://www.runoob.com/java/java-object-tostring.html)返回对象的字符串表示形式 |
| 9    | [void wait()](https://www.runoob.com/java/java-object-wait.html)让当前线程进入等待状态。直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。 |
| 10   | [void wait(long timeout)](https://www.runoob.com/java/java-object-wait-timeout.html)让当前线程处于等待(阻塞)状态，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过参数设置的timeout超时时间。 |
| 11   | [void wait(long timeout, int nanos)](https://www.runoob.com/java/java-object-wait-nanos.html)与 wait(long timeout) 方法类似，多了一个 nanos 参数，这个参数表示额外时间（以纳秒为单位，范围是 0-999999）。 所以超时的时间还需要加上 nanos 纳秒。。 |



```java
//java泛型 类型参数化 泛型只能是引用类型，不能是基本类型
java 中泛型标记符：

E - Element (在集合中使用，因为集合中存放的是元素)
T - Type（Java 类）：T和E用的比较多
K - Key（键）
V - Value（值）
N - Number（数值类型）
？ - 表示不确定的 java 类型

//泛型方法
    声明放在返回值之前：参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前
    声明部分可以有多个参数：数声明部分包含一个或多个类型参数，参数间用逗号隔开。
    返回值也能使用泛型指定的类型：类型参数能被用来声明返回值类型
// 泛型方法 printArray                         
   public static < E > void printArray( E[] inputArray )
   {
      // 输出数组元素            
         for ( E element : inputArray ){        
            System.out.printf( "%s ", element );
         }
         System.out.println();
    }
Integer[] intArray = { 1, 2, 3, 4, 5 };
printArray( intArray  ); // 传递一个整型数组

有界的类型参数:
单边界：<T extends Comparable<T>>
多边界：<T extends A & B & C> A只能是类，其他的都是接口
通配符下限通过形如 List<? super Number> 来定义，而且没有多边界，只能用于形参，或者

//泛型类
在类名后面添加了类型参数声明部分
参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。
//类型通配符
类型通配符一般是使用 ? 代替具体的类型参数。
public static void getUperNumber(List<? extends Number> data) {
          System.out.println("data :" + data.get(0));
       }
T 是一个确定的类型，只能用于泛型类和泛型方法的定义 如public class MyClass<T>{}
？是一个 不确定 的类型，只能用于泛型类的声明一个对象处 如List<?> lis;
```



```java
//java序列化
	该类必须实现 java.io.Serializable 接口。
	该类的所有属性必须是可序列化的(是否实现了序列化接口)。如果有一个属性不是可序列化的，则该属性必须注明是短暂的。public transient int SSN;
	
类 ObjectInputStream 和 ObjectOutputStream 是高层次的数据流，它们包含反序列化和序列化对象的方法。
writeObject(Object x) 和 readObject()
```



```java
//网络编程
java.net 包中提供了两种常见的网络协议的支持：
	TCP：TCP（英语：Transmission Control Protocol，传输控制协议） 是一种面向连接的、可靠的、基于字节流的传输层通信协议，TCP 层是位于 IP 层之上，应用层之下的中间层。
	UDP：UDP （英语：User Datagram Protocol，用户数据报协议），位于 OSI 模型的传输层。一个无连接的协议。提供了应用程序之间要发送数据的数据报。由于UDP缺乏可靠性且属于无连接协议，所以应用程序通常必须容许一些丢失、错误或重复的数据包。
	
//Socket 编程: 套接字使用TCP提供了两台计算机之间的通信机制
	当连接建立时，服务器会创建一个 Socket 对象。客户端和服务器现在可以通过对 Socket 对象的写入和读取来进行通信。
	连接建立后，通过使用 I/O 流在进行通信，每一个socket都有一个输出流和一个输入流，客户端的输出流连接到服务器端的输入流，而客户端的输入流连接到服务器端的输出流。
	TCP 是一个双向的通信协议，因此数据可以通过两个数据流在同一时间发送.以下是一些类提供的一套完整的有用的方法来实现 socket。
	java.net.Socket 类代表客户端和服务器都用来互相沟通的套接字。客户端要获取一个 Socket 对象通过实例化 ，而 服务器获得一个 Socket 对象则通过 accept() 方法的返回值。
	InetAddress 类: 可以理解为表示一台IP终端或者服务器
//发送邮件 用到扩展包 略
```

IP：运行在两台计算机之间

TCP：运行在两个端口之间

HTTP：运行在两个应用之间，是两个应用之间的编码解码通信

```
由于HTTP是无状态的，服务器不知道这个HTTP来自哪个用户，需要Session来标记跟踪这个用户
每次HTTP请求的时候，客户端都会发送相应的Cookie信息到服务端。
实际上大多数的应用都是用 Cookie 来实现Session跟踪的

也就是说服务器为每个用户提供一个Session
用户给服务器提供一个Cookie，服务器通过这个Cookie来创建一个Session
第一次创建Session的时候，服务端会在HTTP协议中告诉客户端，需要在 Cookie 里面记录一个Session ID，以后每次请求把这个会话ID发送到服务器，我就知道你是谁了
```



```
//多线程
操作系统给进程分配内存
一个进程一直运行，直到所有的非守护线程结束后才能停止运行
```

![](https://www.runoob.com/wp-content/uploads/2014/01/java-thread.jpg)



new出来：处于新建状态

执行start()：就绪状态 就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度

执行run()：运行状态处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态(时间片轮转)和死亡状态

执行wait()：阻塞状态 执行了sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态

- 等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。（执行notify()转为就绪状态）
- 同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。
- 其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。

线程的优先级

Java 线程的优先级是一个整数，其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）。

但是，线程优先级不能保证线程执行的顺序，而且非常依赖于平台。



```
//创建线程
Java 提供了三种创建线程的方法：

通过实现 Runnable 接口； 重写run()方法
通过继承 Thread 类本身； 重写run()方法
通过 Callable 和 Future 创建线程
```

- extends Tread类 

- 重写run方法

- 创建子类对象

- 调用start方法

  

- implements Runnable接口 

- 重写实现run方法 

- 创建对象 

- 通过这个对象构造Tread对象 这种方式更容易使得线程之间共享数据

//callable实现新建线程的步骤：方法可以抛出异常 支持泛型的返回值

 * 1.创建一个实现callable的实现类
 * 2.实现call方法，将此线程需要执行的操作声明在call（）中
 * 3.创建callable实现类的对象
 * 4.将callable接口实现类的对象作为传递到FutureTask的构造器中，创建FutureTask的对象
 * 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start方法启动（通过FutureTask的对象调用方法get获取线程中的call的返回值）



线程池：避免线程频繁创建和销毁

```java
package com.example.paoduantui.Thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：使用线程池（批量使用线程）
 *1.需要创建实现runnable或者callable接口方式的对象
 * 2.创建executorservice线程池
 * 3.将创建好的实现了runnable接口类的对象放入executorService对象的execute方法中执行。
 * 4.关闭线程池
 *
 * */

class NumberThread implements Runnable{


    @Override
    public void run() {
        for(int i = 0;i<=100;i++){
            if (i % 2 ==0 )
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i<100; i++){
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadPool {

    public static void main(String[] args){

        //创建固定线程个数为十个的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //new一个Runnable接口的对象
        NumberThread number = new NumberThread();
        NumberThread1 number1 = new NumberThread1();

        //执行线程,最多十个
        executorService.execute(number1);
        executorService.execute(number);//适合适用于Runnable

        //executorService.submit();//适合使用于Callable
        //关闭线程池
        executorService.shutdown();
    }

}
```



生产者消费者问题

