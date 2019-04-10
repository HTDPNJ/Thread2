package SynchronizedD;
/*
* 单例模式创建的方式
* 1、懒汉式
* 1）构造器私有化
* 2）声明私有的静态属性
* 3）对外提供访问属性的静态方法，确保该对象存在*/
public class MyJvm
{
    private static MyJvm instace;
    private MyJvm(){
    }
    public static MyJvm getInstance(){
        if(null==instace){
            synchronized(MyJvm.class){
                if(null==instace){
                    instace=new MyJvm();
                }
            }
        }
        return instace;
    }
}

/*
* 饿汉式
* 构造器私有化
* 声明静态属性，同时创建该对象
* 对外提供访问属性的方法*/
class MyJvm2
{
    private static MyJvm2 instance=new MyJvm2(); //属性在类加载时创建，只加载一次，所以线程安全
    private MyJvm2(){
    }
    public static MyJvm2 getInstance(){
        return instance;
    }
}
/*内部类在使用时才加载，延缓加载时间，提高效率*/
class MyJvm3
{
    private static class JVMholde {
          private static MyJvm3 instance=new MyJvm3();
    }
    private MyJvm3(){
    }
    public static MyJvm3 getInstance(){
        return JVMholde.instance;
    }
}
