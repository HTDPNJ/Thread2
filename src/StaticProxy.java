public class StaticProxy
{
    //静态代理模式
    public static void main(String[] args)
    {
        //创建真实角色
        You you=new You();
        //创建代理角色+真实角色的引用
        WeddingCompany company=new WeddingCompany(you);
        company.marry();
    }
    //接口
    interface Marry{
        public abstract void marry();
    }
    //真实角色
    static class You implements Marry{
        @Override
        public void marry()
        {
            System.out.println("you and someone...");
        }
    }
    //代理角色
    static class WeddingCompany implements Marry{
        private Marry you;

        public WeddingCompany(Marry you)
        {
            this.you=you;
        }
        private void before(){
            System.out.println("布置猪窝...");
        }
        private void after(){
            System.out.println("闹...");
        }
        @Override
        public void marry()
        {
            before();
            you.marry();
            after();
        }
    }
}
