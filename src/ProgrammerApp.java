public class ProgrammerApp
{
    public static void main(String[] args)
    {
        Programmer pro=new Programmer();
        Thread th=new Thread(pro);
        th.start();
        for(int i=0;i<100;i++)
            System.out.println("一边聊qq");
    }
}
