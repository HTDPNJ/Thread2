public class Rabbit extends Thread
{
    @Override
    public void run()
    {
        for(int i=0;i<1000;i++)
            System.out.println("兔子跑了"+i+"步");
    }
}
