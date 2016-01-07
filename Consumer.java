import java.util.Random;

/**
 * Created by Ha on 16. 1. 7..
 */
public class Consumer extends Thread {
    private IntBuffer b;

    public Consumer(IntBuffer b){
        this.b = b;
    }

    @Override
    public void run() {
        Random r = new Random();
        // 0 ~ 1초에 한번식 버퍼에서 데이터 삭제
        while(true){
            try {
                int random_time = r.nextInt(1000);
                Thread.sleep(random_time);
            } catch (InterruptedException e) {}

            int data = b.remove();
            System.out.println("                Removed " + data);
        }
    }
}
