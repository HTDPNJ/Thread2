package ProducerConsumer;

import java.util.TreeSet;

public class App
{
    public static void main(String[] args)
    {
        Movie m=new Movie();//共同资源
        //多线程
        Player p=new Player(m);
        Watcher w=new Watcher(m);
        new Thread(p).start();
        new Thread(w).start();
    }
}
