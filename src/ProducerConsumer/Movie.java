package ProducerConsumer;
/*一个场景,共同的资源
* 生产者消费者模式
* 信号灯法*/
public class Movie
{
    private String pic;
    private boolean flag=true;
    //flag-->t 生产者生产，消费者等待，生产完成后通知消费，否则相反

    //播放
    public  synchronized void play(String pic){
        if(!flag){//等待
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始生产
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产了："+pic);
        //生产完毕
        this.pic=pic;
        //通知消费
        this.notify();
        //生产者停下
        this.flag=false;
    }
    public  synchronized void watch(){
        if(flag){
            try {
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始消费
        try {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //消费完毕
        System.out.println("消费了："+pic);
        //通知生产
        this.notifyAll();
        //停止消费
        this.flag=true;
    }

}
