package dxt.wj.customer.poolTest;

import java.util.concurrent.*;

public class CountDownTest {

    public static void main(String[] args) {
        int num = 100;
        //启用线程池(最大不能超过500个)
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50,//核心池大小
                500,//最大池大小
                200,//线程最大空闲时间,超过此空闲时间可以被收回
                TimeUnit.MILLISECONDS, //最大空闲时间的单位
                new ArrayBlockingQueue<Runnable>(10)//用于保存执行任务的队列,可以选择其他不同的队列来做任务管理
        );
        CountDownLatch n = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            //启动一个任务
            Task myTask = new Task(i, n);
            executor.execute(myTask);
        }

        System.out.println("全部执行的任务数量:" + executor.getTaskCount());
        System.out.println("已完成的任务数量:" + executor.getCompletedTaskCount());
        System.out.println("线程池中最大线程数量:" + executor.getPoolSize());


        //等待所有线程完毕
        try {
            n.await();
            System.out.println("等待所有完成:" + executor.getCompletedTaskCount());
            System.out.println("全部执行的任务数量:" + executor.getTaskCount());
            System.out.println("已完成的任务数量:" + executor.getCompletedTaskCount());
            System.out.println("线程池中最大线程数量:" + executor.getPoolSize());
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        //关闭线程池
        executor.shutdown();
        System.out.println("线程池关闭，主线程任务完成:" + executor.getCompletedTaskCount());
        System.out.println("全部执行的任务数量:" + executor.getTaskCount());
        System.out.println("已完成的任务数量:" + executor.getCompletedTaskCount());
        System.out.println("线程池中最大线程数量:" + executor.getPoolSize());
    }

}

class Task implements Runnable {

    private int taskNum;
    CountDownLatch n;


    public Task(int num, CountDownLatch n) {
        this.taskNum = num;
        this.n = n;
    }

    public void run() {
        try {

            Thread.sleep(1000);
            System.out.println("擦桌子");

        } catch (Exception e) {
            System.out.println("task " + taskNum + "执行失败");
        }
        //事情干完了
        n.countDown();
    }
}
