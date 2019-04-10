package SynchronizedD;

/*
* 单例设计模式，确保一个类只有一个对象*/
public class SynDemo03
{
    public static void main(String[] args)
    {
        MyThread t1=new MyThread(100);
        t1.start();
        MyThread t2=new MyThread(200);
        t2.start();
    }
}
class MyThread extends Thread{
    private long time;
    public MyThread(){
    }
    public MyThread(long time){
        this.time=time;
    }
    @Override
    public void run()
    {
        try {
            System.out.println(Jvm2.getInstance(time));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*确保一个类只有一个对象，懒汉式
* 单例设计模式*/
class Jvm2{
    //2、声明一个私有的静态变量
    private static Jvm2 instance=null;
    //1、构造器私有化，避免外部直接创建对象
    private Jvm2(){
    }
    //3、创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
    public static Jvm2 getInstance(long millis) throws InterruptedException  //synchronized 加在static前面用于同步
    {
        synchronized (Jvm2.class){ //用于同步，由于该方法是静态方法所以不能用this
        if(null==instance){
            Thread.sleep(millis);
            instance=new Jvm2();
        }
        return instance;
        }
    }

    public static Jvm2 getInstance2(long millis) throws InterruptedException  //synchronized 加在static前面用于同步
    {
        if(null==instance){ //效率快一些
        synchronized (Jvm2.class){ //用于同步，由于该方法是静态方法所以不能用this
            if(null==instance){
                Thread.sleep(millis);
                instance=new Jvm2();
            }
            }
        }
        return instance;
    }
}
