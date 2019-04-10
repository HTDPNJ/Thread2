public class RabbitApp
{
    public static void main(String[] args)
    {
        Rabbit rabbit=new Rabbit();
        Tortoise tortoise=new Tortoise();
        rabbit.start();
        tortoise.start();
        for(int i=0;i<1000;i++)
            System.out.println("main"+i+"步");

    }
}
