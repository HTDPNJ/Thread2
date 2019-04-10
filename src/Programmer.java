public class Programmer implements Runnable
{
    /*使用Runnable创建线程
    * 类实现Runnable接口+重写run()
    * 启动多线程 使用静态代理
    * 1）.创建真实角色
    * 2）.创建代理角色+真实角色引用
    * 3）.调用.start()方法 启动线程*/
    @Override
    public void run()
    {
        for(int i=0;i<100;i++)
            System.out.println("一边敲代码...");
    }
}
