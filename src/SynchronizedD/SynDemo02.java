package SynchronizedD;

import status.JoinDemo01;

/*
* 单例设计模式，确保一个类只有一个对象*/
public class SynDemo02
{
    public static void main(String[] args)
    {
        Jvm jvm1=Jvm.getInstance();
        System.out.println(jvm1);
        Jvm jvm2=Jvm.getInstance();
        System.out.println(jvm2); //单线程下创建的是同一个对象，但多线程下就不一定了，所以要用线程同步
    }
}
/*确保一个类只有一个对象，懒汉式
* 单例设计模式*/
class Jvm{
    //2、声明一个私有的静态变量
    private static Jvm instance=null;
    //1、构造器私有化，避免外部直接创建对象
    private Jvm(){
    }
    //3、创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
    public static Jvm getInstance(){
        if(null==instance){
            instance=new Jvm();
        }
        return instance;
    }
}
