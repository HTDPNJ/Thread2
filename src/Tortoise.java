public class Tortoise extends Thread
{
    @Override
    public void run()
    {
        for(int i=0;i<1000;i++)
            System.out.println("乌龟跑了多少"+i+"步");
    }
}
