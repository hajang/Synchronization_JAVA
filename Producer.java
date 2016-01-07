import java.util.Random;

/**
 * Created by Ha on 16. 1. 7..
 */
public class Producer extends Thread {
    private IntBuffer b;

    public Producer(IntBuffer b){
        this.b = b;
    }

    @Override
    public void run() {
        Random r = new Random();
        // 0 ~0.1초에 한번씩 random 데이터 생성후 버퍼에 추가
        while(true){
            try {
                int random_time = r.nextInt(100);
                Thread.sleep(random_time);
            } catch (InterruptedException e) {}

            int data = r.nextInt(100);
            b.add(data);
            System.out.println("Produced " + data);
        }
    }
}
