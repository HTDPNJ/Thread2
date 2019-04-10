package SynchronizedD;
/*
* sleep模拟网络延时*/
public class SynchronizedDemo01
{
    public static void main(String[] args)
    {
        //真实角色
        Web12306 web=new Web12306();
        //代理
        Thread t1=new Thread(web,"路人甲");
        Thread t2=new Thread(web,"黄牛已");
        Thread t3=new Thread(web,"攻城狮");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Web12306  implements Runnable
{
    private int num=10;
    private boolean flag=true;
    @Override
    public void run()
    {
        while(flag){
            test2();
        }
    }
    public  void test3(){ //线程安全的
        synchronized(this){
            if(num<=0){
                flag=false;
                return;
            }
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
        }

    }
    public synchronized void test2(){ //线程安全的
        if(num<=0){
            flag=false;
            return;
        }
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
    }

    public void test1(){
        if(num<=0)
            flag=false;
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
    }
}
