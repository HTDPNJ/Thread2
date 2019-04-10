package status;

public class YieldDemo01 extends Thread
{
    public static void main(String[] args)
    {
        YieldDemo01 demo=new YieldDemo01();
        Thread t=new Thread(demo);
            t.start(); //就绪
        //cpu调度运行

        for(int i=0;i<1000;i++){
            if(i%20==0){
                Thread.yield();//yield是静态方法，写在哪个线程里就暂停谁
            }
            System.out.println("main..."+i);
        }
    }
    @Override
    public void run()
    {
        for(int i=0;i<1000;i++)
            System.out.println("yield..."+i);
    }
}
