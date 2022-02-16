# Java基础高级和网络编程

## 1.Java基础

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

## 2.Java高级

### 2.1 集合类

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

### 2.2 集合与算法迭代器比较器

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

### 2.3 Java泛型

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

### 2.4 Java序列化存储和读取

```java
//java序列化
	该类必须实现 java.io.Serializable 接口。
	该类的所有属性必须是可序列化的(是否实现了序列化接口)。如果有一个属性不是可序列化的，则该属性必须注明是短暂的。public transient int SSN;
	
类 ObjectInputStream 和 ObjectOutputStream 是高层次的数据流，它们包含反序列化和序列化对象的方法。
writeObject(Object x) 和 readObject()
```

## 3.Java网络编程

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

## 4.Java多线程

### 4.1 线程的生命周期

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

### 4.2 多线程的实现方式

```
//创建线程
Java 提供了两类四种创建线程的方法：

通过实现 Runnable 接口,重写run()方法
通过继承 Thread 类本身,重写run()方法
通过 Callable 和 FutureTask 创建线程
通过线程池
```

1. 都是想办法实现一个Thread类的run方法，
2. 第一种是通过接口对象的插入的方式，插入Thread对象
3. 第二种是继承Thread类重写的方式
4. 第三种也是接口对象插入的方式，先插入FutureTask对象，再将FutureTask对象插入Thread对象
5. 第四种是将Runnable或者Callable的实现插入到线程池中

---

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

### 4.3 线程的同步实现线程安全

**线程安全：**多个线程对同一个共享数据进行操作时，线程没来得及更新共享数据，从而导致另外线程没得到最新的数据，从而产生线程安全问题。一个线程对共享数据进行操作的时候，别的线程应该等待

**同步机制：**同步是实现线程安全的一种方式，就算是定义线程之间操作的一种偏序

**同步的实现：**

- 方式一：同步代码块

  ```
  使用同步监视器（锁）
  Synchronized（同步监视器）{undefined
  //需要被同步的代码
  }
  
  多个线程必须要共用同一把锁
  Runable天生共享锁，而Thread中需要用static对象或者this关键字或者当前类（window。class）来充当唯一锁
  ```

  

- 方式二：同步方法，就是将同步代码块抽出来包装成一个方法

  ```
  对方法进行synchronized关键字修饰
  对于runnable接口实现多线程，只需要将同步方法用synchronized修饰
  而对于继承自Thread方式，需要将同步方法用static和synchronized修饰，因为对象不唯一（锁不唯一）
  ```

  

- 方式三：lock锁

  ```
  //1.实例化锁
  private ReentrantLock lock = new ReentrantLock();
  synchronized机制在执行完相应的代码逻辑以后，自动的释放同步监视器
  lock需要手动的启动同步（lock（）），同时结束同步也需要手动的实现（unlock（））（同时以为着lock的方式更为灵活）
  
  优先使用顺序：
  LOCK-》同步代码块-》同步方法
  ```

  synchronized修饰的方式

### 4.4 Java中的锁

[不可不说的Java“锁”事](https://tech.meituan.com/2018/11/15/java-lock.html)

**4.4.1 线程要不要锁住同步资源？**乐观悲观

+ ==悲观锁==：悲观锁认为自己在使用数据的时候一定有别的线程来修改数据，因此在获取数据的时候会先加锁，确保数据不会被别的线程修改。Java中，synchronized关键字和Lock的实现类都是悲观锁。

+ ==乐观锁==：乐观锁认为自己在使用数据时不会有别的线程修改数据，所以不会添加锁，只是在更新数据的时候去判断之前有没有别的线程更新了这个数据。如果这个数据没有被更新，当前线程将自己修改的数据成功写入。如果数据已经被其他线程更新，则根据不同的实现方式执行不同的操作（例如报错或者自动重试）。

  乐观锁在Java中是通过使用无锁编程来实现，最常采用的是CAS算法，Java原子类中的递增操作就通过CAS自旋实现的。自旋就是让当前线程执行一个忙循环(自旋操作)，不断请求

```
悲观锁适合写操作多的场景，先加锁可以保证写操作时数据正确。
乐观锁适合读操作多的场景，不加锁的特点能够使其读操作的性能大幅提升。
```

+ CAS全称 Compare And Swap（比较与交换），是一种无锁算法。在不使用锁（没有线程被阻塞）的情况下实现多线程之间的变量同步。java.util.concurrent包中的原子类就是通过CAS来实现了乐观锁。

  所谓自旋就是一个不断尝试的过程，乐观锁不是锁，但是自旋不能解决ABA问题，需要添加给共享数据添加版本号

<img src="https://img-blog.csdnimg.cn/20181122105801128.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L21hc2hhb2thbmcxMzE0,size_16,color_FFFFFF,t_70" style="zoom:80%;" />

+ 实现过程
  `假如现在有两个线程t1,t2,，他们各自的运行环境中都有共享变量的副本V1、V2，预期值E1、E2，预期主存中的值还没有被改变，假设现在在并发环境，并且t1先拿到了执行权限，失败的线程并不会被挂起，而是被告知这次竞争中失败，并可以再次发起尝试，然后t1比较预期值E1和主存中的V，发现E1=V，说明预期值是正确的，执行N1=V1+1，并将N1的值传入主存。这时候贮存中的V=21，然后t2又紧接着拿到了执行权，比较E2和主存V的值，由于V已经被t1改为21，所以E2！=V，t2线程将主存中已经改变的值更新到自己的副本中，再发起重试；直到预期值等于主存中的值，说明没有别的线程对旧值进行修改，继续执行代码，退出；`

**4.4.2 访问锁住同步资源失败，线程要不要阻塞？**

+ 阻塞
+ 不阻塞（自旋和适应性自旋）因为有的时候对同步资源的访问时间很短，切换线程状态得不偿失

==自旋==会占用处理器时间。自旋等待的时间必须要有一定的限度，如果自旋超过了限定次数（默认是10次，可以使用-XX:PreBlockSpin来更改）没有成功获得锁，就应当挂起线程。

*自旋锁的实现原理同样也是CAS，意思说对锁的占用算法是CAS，乐观锁是对数据的访问是CAS（比较和交换）*

```
class Lock {
	// 如果在这个位置(address) 的值等于 这个值(expectedValue),那么交换(newValue)。
	boolean CAS(address,expectedValue,newValue) {
		if(address 的 value == expectedValue) {
			address 的 value = newValue;
			return true;
		}
	}
	
	// 记录当前锁是哪个线程持有的, 如果为 null, 那么就表示当前锁没有被持有
	Thread owner = null;
	void Lock() {
		// 循环判断, 如果锁(owner)没有被持有
		// 也就是 owner == null
		// 那么将 Thread.currentThread() 替换上去 
		// 结束循环, 如果 owner != null, 继续循环
		while (!CAS(owner,null,Thread.currentThread()) {
			// 没有内容
		}
	}
}
```

==适应性自旋==，自适应意味着自旋的时间（次数）不再固定，而是由前一次在同一个锁上的自旋时间及锁的拥有者的状态来决定。如果在同一个锁对象上，自旋等待刚刚成功获得过锁，并且持有锁的线程正在运行中，那么虚拟机就会认为这次自旋也是很有可能再次成功，进而它将允许自旋等待持续相对更长的时间。如果对于某个锁，自旋很少成功获得过，那在以后尝试获取这个锁时将可能省略掉自旋过程，直接阻塞线程，避免浪费处理器资源。

<img src="https://awps-assets.meituan.net/mit-x/blog-images-bundle-2018b/452a3363.png" style="zoom:50%;" />

**4.4.3 锁的程度synchronized相关**

两个基本概念：“Java对象头”、“Monitor”

*对象在内存中的布局分为三块区域：对象头、实例数据和对齐填充*

*synchronized使用的锁对象是存储在Java对象头里*

![](https://img2018.cnblogs.com/blog/1383365/201901/1383365-20190110162628940-924509688.png)

到目前位置，对于锁存在哪个位置，我们已经清楚了，锁存在于每个对象的 markOop 对象头中.对于为什么每个对象都可以成为锁呢？ 因为每个 Java Object 在 JVM 内部都有一个 native 的 ==C++ 对象== oop/oopDesc 与之对应，而对应的 oop/oopDesc 都会存在一个markOop 对象头，而这个对象头是存储锁的位置，里面还有对象监视器，即ObjectMonitor，所以这也是为什么每个对象都能成为锁的原因之一。

![](https://img2018.cnblogs.com/blog/1383365/201901/1383365-20190110161112052-626978457.png)

==Java对象头==：`synchronized是悲观锁，在操作同步资源之前需要给同步资源先加锁，这把锁就是存在Java对象头里的`

> 以Hotspot虚拟机为例，Hotspot的对象头主要包括两部分数据：Mark Word（标记字段）、Klass Pointer（类型指针）
>
> **Mark Word**：默认存储对象的HashCode，分代年龄和锁标志位信息。这些信息都是与对象自身定义无关的数据
>
> **Klass Point**：对象指向它的类元数据的指针，虚拟机通过这个指针来确定这个对象是哪个类的实例。

==Monitor==：每一个Java对象就有一把看不见的锁，称为内部锁或者Monitor锁。	

> Monitor是线程私有的数据结构，每一个线程都有一个可用monitor record列表，同时还有一个全局的可用列表。每一个被锁住的对象都会和一个monitor关联，同时monitor中有一个Owner字段存放拥有该锁的线程的唯一标识，表示该锁被这个线程占用。
>
> synchronized通过Monitor来实现线程同步，Monitor是依赖于底层的操作系统的Mutex Lock（互斥锁）来实现的线程同步。
>
> JDK 6之前synchronized效率低，依赖于操作系统Mutex Lock所实现的“重量级锁”
>
> JDK 6中为了减少获得锁和释放锁带来的性能消耗，引入了“偏向锁”和“轻量级锁”。
>
> 所以目前锁一共有4种状态，级别从低到高依次是：无锁、偏向锁、轻量级锁和重量级锁。锁状态只能升级不能降级。
>
> 四种锁状态对应的的Mark Word内容

 objectMonitor.cpp 这个源码

```
void ATTR ObjectMonitor::enter(TRAPS) {//获取重量级锁的过程
  // The following code is ordered to check the most common cases first
  // and to reduce RTS->RTO cache line upgrades on SPARC and IA32 processors.
  Thread * const Self = THREAD ;
  void * cur ;

  cur = Atomic::cmpxchg_ptr (Self, &_owner, NULL) ;//进行CAS
  if (cur == NULL) {
     // Either ASSERT _recursions == 0 or explicitly set _recursions = 0.
     assert (_recursions == 0   , "invariant") ;
     assert (_owner      == Self, "invariant") ;
     // CONSIDER: set or assert OwnerIsThread == 1
     return ;
  }
  //CAS结果相等，则重入（重入的原理）
  if (cur == Self) {
     // TODO-FIXME: check for integer overflow!  BUGID 6557169.
     _recursions ++ ;
     return ;
  }//接下去就是有并发的情况下竞争的过程了
....
```



| 锁状态   | 存储内容                                                | 存储内容 |
| :------- | :------------------------------------------------------ | :------- |
| 无锁     | 对象的hashCode、对象分代年龄、是否是偏向锁（0）         | 01       |
| 偏向锁   | 偏向线程ID、偏向时间戳、对象分代年龄、是否是偏向锁（1） | 01       |
| 轻量级锁 | 指向栈中锁记录的指针                                    | 00       |
| 重量级锁 | 指向互斥量（重量级锁）的指针                            | 10       |

==无锁==（乐观锁）竞争修改资源

==偏向锁==：当一个线程访问同步代码块并获取锁时，会在Mark Word里存储锁偏向的线程ID。在线程进入和退出同步块时不再通过CAS操作来加锁和解锁，而是检测Mark Word里是否存储着指向当前线程的偏向锁，偏向锁只有遇到其他线程尝试竞争偏向锁时，持有偏向锁的线程才会释放锁，线程不会主动释放偏向锁

`偏向锁在JDK 6及以后的JVM里是默认启用的。可以通过JVM参数关闭偏向锁：-XX:-UseBiasedLocking=false，关闭之后程序默认会进入轻量级锁状态。`

==轻量级锁==：是指当锁是偏向锁的时候，被另外的线程所访问，偏向锁就会升级为轻量级锁，其他线程会通过自旋的形式尝试获取锁，不会阻塞，从而提高性能。

`若当前只有一个等待线程，则该线程通过自旋进行等待。但是当自旋超过一定的次数，或者一个线程在持有锁，一个在自旋，又有第三个来访时，轻量级锁升级为重量级锁。`

==重量级锁==：升级为重量级锁时，锁标志的状态值变为“10”，此时Mark Word中存储的是指向重量级锁的指针，此时等待锁的线程都会进入阻塞状态。

*偏向锁通过对比Mark Word解决加锁问题，避免执行CAS操作。而轻量级锁是通过用CAS操作和自旋来解决加锁问题，避免线程阻塞和唤醒而影响性能。重量级锁是将除了拥有锁的线程以外的线程都阻塞。*

**4.4.4 获取锁时候要不要排队？**

排队：==公平锁== 线程直接排队

`线程按照申请锁的顺序来获取锁，线程直接进入队列中排队，队列中的第一个线程才能获得锁。公平锁的优点是等待锁的线程不会饿死。缺点是整体吞吐效率相对非公平锁要低，等待队列中除第一个线程以外的所有线程都会阻塞，CPU唤醒阻塞线程的开销比非公平锁大。`

不排队：==非公平锁== 线程先尝试获取锁，然后再排队

`直接尝试获取锁，获取不到才会到等待队列的队尾等待。如果此时锁刚好可用，那么这个线程可以无需阻塞直接获取到锁，所以非公平锁有可能出现后申请锁的线程先获取锁的场景。线程有几率不阻塞直接获得锁`

**4.4.5 同一个线程的各个流程之间能不能获取同一把锁？**

==可重入锁==又名递归锁，是指在同一个线程在外层方法获取锁的时候，再进入该线程的内层方法会自动获取锁（前提锁对象得是同一个对象或者class），不会因为之前已经获取过还没释放而阻塞。Java中ReentrantLock和synchronized都是可重入锁

==非可重入锁==NonReentrantLock，也就是一个线程可能会多次访问到这个共享数据，是应该访问一次获取一次呢，还是获取一次就可以了

ReentrantLock和NonReentrantLock都继承父类AQS，其父类AQS中维护了一个同步状态status来计数重入次数，status初始值为0。

当线程尝试获取锁时，可重入锁先尝试获取并更新status值，如果status == 0表示没有其他线程在执行同步代码，则把status置为1，当前线程开始执行。如果status != 0，则判断当前线程是否是获取到这个锁的线程，如果是的话执行status+1，且当前线程可以再次获取锁。而非可重入锁是直接去获取并尝试更新当前status的值，如果status != 0的话会导致其获取锁失败，当前线程阻塞。

释放锁时，可重入锁同样先获取当前status的值，在当前线程是持有锁的线程的前提下。如果status-1 == 0，则表示当前线程所有重复获取锁的操作都已经执行完毕，然后该线程才会真正释放锁。而==非可重入锁则是在确定当前线程是持有锁的线程之后，直接将status置为0，将锁释放。==

**4.4.6 线程之间是否能同时拥有同一把锁？**

==独享锁==也叫排他锁，是指该锁一次只能被一个线程所持有。如果线程T对数据A加上排它锁后，则其他线程不能再对A加任何类型的锁。获得排它锁的线程即能读数据又能修改数据。JDK中的synchronized和JUC中Lock的实现类就是互斥锁。

==共享锁==是指该锁可被多个线程所持有。如果线程T对数据A加上共享锁后，则其他线程只能对A再加共享锁，不能加排它锁。获得共享锁的线程只能读数据，不能修改数据。也就是我在读的时候别的线程你只能过来读，而不能修改；而我在修改的时候，别的线程不能过来读也不能写

独享锁与共享锁也是通过AQS来实现的	

ReentrantReadWriteLock有两把锁：ReadLock和WriteLock，由词知意，一个读锁一个写锁，合称“读写锁”。ReadLock和WriteLock是靠内部类Sync实现的锁。Sync是AQS的一个子类。提及AQS的时候我们也提到了state字段（int类型，32位），该字段用来描述有多少线程获持有锁。

在独享锁中这个值通常是0或者1（如果是重入锁的话state值就是重入的次数），在共享锁中state就是持有锁的数量。

### 4.5 synchronized原理

**synchronized有三种方式来加锁**

+ 方法锁
+ 对象锁synchronized(this)
+ 类锁synchronized(Demo.Class)

```
1. 修饰实例方法，作用于当前实例加锁，进入同步代码前要获得当前实例的锁

2. 静态方法，作用于当前类对象加锁，进入同步代码前要获得当前类对象的锁

3. 修饰代码块，指定加锁对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁
可以对类对象加锁也可以对实例对象加锁，拿到对应对象的锁线程才能进入同步代码块
```

### 4.6 线程安全的判定和解决

解决方案：隐式锁和显示锁

隐式锁：同步方法，同步代码块

显示锁：实例化一个锁对象，手动开启和关闭

1.先判断是否多线程
2.再判断是否有共享数据
3.是否并发的对共享数据进行操作
4.选择上述三种方法解决线程安全问题

synchronized机制在执行完相应的代码逻辑以后，自动的释放同步监视器
lock需要手动的启动同步（lock（）），同时结束同步也需要手动的实现（unlock（））（同时以为着lock的方式更为灵活）

优先使用顺序：
==LOCK-》同步代码块-》同步方法==

```
	package com.example.paoduantui.Thread;
	
	/***
	 * 描述：甲乙同时往银行存钱，存够3000
	 *
	 *
	 * */
	
	//账户
	class Account{
	    private double balance;//余额
	    //构造器
	    public Account(double balance) {
	        this.balance = balance;
	    }
	    //存钱方法
	    public synchronized void deposit(double amt){
	        if(amt>0){
	            balance +=amt;
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+balance);
	        }
	    }
	}
	
	//两个顾客线程
	class Customer extends Thread{
	     private Account acct;
	
	     public Customer(Account acct){
	         this.acct = acct;
	     }
	
	
	
	    @Override
	    public void run() {
	        for (int i = 0;i<3;i++){
	            acct.deposit(1000);
	        }
	    }
	}
	
	//主方法，之中new同一个账户，甲乙两个存钱线程。
	public class AccountTest {
	
	    public static void main(String[] args){
	        Account acct = new Account(0);
	        Customer c1 = new Customer(acct);
	        Customer c2 = new Customer(acct);
	
	        c1.setName("甲");
	        c2.setName("乙");
	
	        c1.start();
	        c2.start();
	    }
	
	}

```

### 4.7 单例模式的线程安全

单例模式：整个类只能有一个实例，并且访问点只能有一个

优点：不会频繁地创建和销毁对象，浪费系统资源。 使用场景：IO 、数据库连接、Redis 连接等。

```
//把构造器设置为私有，通过静态方法得到实例
private Bank(){}//可以在构造器中初始化东西
private static Bank instance = null;//初始化静态实例

public static Bank getInstance(){
    undefined
    if(instance!=null){undefined
        instance = new Bank();
    }
	return instance;
}
```

如果是多线程访问，当同时访问这个单例模式的静态构造方法时候，可能都会读到一个空，此时就会产生多个实例对象了

解决方式同步方法 同步代码块

懒汉式写法：高并发

```
package com.example.paoduantui.Thread;

public class Bank {
    //私有化构造器
    private Bank(){}
    //初始化静态实例化对象
    private static  Bank instance = null;

    //获取单例实例,此种懒汉式单例模式存在线程不安全问题（从并发考虑）

    public static  Bank getInstance(){
        if(instance==null){
            instance = new Bank();
        }
        return  instance;
    }

    //同步方法模式的线程安全
    public static synchronized Bank getInstance1(){
        if(instance==null){
            instance = new Bank();
        }
        return  instance;
    }
    //同步代码块模式的线程安全（上锁）
    public  static Bank getInstance2(){
        synchronized (Bank.class){
            if(instance==null){
                instance = new Bank();
            }
            return  instance;
        }
    }
    
    //效率更高的线程安全的懒汉式单例模式
    /**
     * 由于当高并发调用单例模式的时候，类似于万人夺宝，只有第一个进入房间的人才能拿到宝物，
     * 当多个人进入这个房间时，第一个人拿走了宝物，也就另外几个人需要在同步代码块外等候，
     * 剩下的人只需要看到门口售罄的牌子即已知宝物已经被夺，可以不用进入同步代码块内，提高了效率。
     * 
     * 
     * */
    public static Bank getInstance3(){
    	//一部分人在这，很可能这里不是空了，线程可以直接不用再等，只要有一个线程把这个值改了，我就可以看到，而不是等着里面的线程执行完同步代码块，高并发的情况下就可以让很多的线程(读到进入同步代码块修改后的值的后来的线程)不用阻塞或者等待，直接返回
        if (instance==null){
        	//一部分人在这等着
            synchronized (Bank.class){
            	//只有一个人在这
                if(instance==null){
                    instance = new Bank();
                }
            }
        }
        return  instance;
    }
}
```

### 4.8 线程的死锁问题

多个进程在运行过程中因争夺资源而造成的一种僵局，大家都在等但是没有人解决

死锁的四个必要条件，也就是死锁一定会

- 互斥独占
- 请求和保持，只要任务没有完成，不主动放手
- 不可抢占
- 循环等待

==**预防死锁的方式**==

资源一次性分配：一次性分配线程所需要的所有资源，只要有一个资源得不到分配，也不给这个进程分配其他的资源（请求和保持） 但是有时候会发生只有一个线程满足，其他都会阻塞，开销大
可剥夺资源：即当某进程获得了部分资源，但得不到其它资源，则释放已占有的资源（破坏不可剥夺条件）频繁申请和释放
资源有序分配法：系统给每类资源赋予一个编号，每一个进程按编号递增的顺序请求资源，释放则相反（破坏环路等待条件） 

这种方法存在的问题是，编号必须相对稳定，这就限制了新类型设备的增加；尽管在为资源编号时已考虑到大多数作业实际使用这些资源的顺序，但也经常会发生作业使用资源的顺序与系统规定顺序不同的情况，造成资源的浪费；此外，这种按规定次序申请资源的方法，也必然会给用户的编程带来麻烦。

上边的方法开销太大，所以基本了解就好

**==避免死锁的方式==**

预防死锁的几种策略，会严重地损害系统性能。因此在避免死锁时，要施加较弱的限制，从而获得 较满意的系统性能。由于在避免死锁的策略中，允许进程动态地申请资源。因而，系统在进行资源分配之前预先计算资源分配的安全性。若此次分配不会导致系统进入不安全的状态，则将资源分配给进程；否则，进程等待。其中最具有代表性的避免死锁算法是银行家算法。

银行家算法：首先需要定义状态和安全状态的概念。系统的状态是当前给进程分配的资源情况。因此，状态包含两个向量Resource（系统中每种资源的总量）和Available（未分配给进程的每种资源的总量）及两个矩阵Claim（表示进程对资源的需求）和Allocation（表示当前分配给进程的资源）。安全状态是指至少有一个资源分配序列不会导致死锁。当进程请求一组资源时，假设同意该请求，从而改变了系统的状态，然后确定其结果是否还处于安全状态。如果是，同意这个请求；如果不是，阻塞该进程知道同意该请求后系统状态仍然是安全的。

==检测死锁==
首先为每个进程和每个资源指定一个唯一的号码；
然后建立资源分配表和进程等待表。

==解除死锁==
当发现有进程死锁后，便应立即把它从死锁状态中解脱出来，常采用的方法有：

剥夺资源：从其它进程剥夺足够数量的资源给死锁进程，以解除死锁状态；
撤消进程：可以直接撤消死锁进程或撤消代价最小的进程，直至有足够的资源可用，死锁状态.消除为止；所谓代价是指优先级、运行代价、进程的重要性和价值等。

### 4.9 经典线程同步问题

消费者生产者问题

