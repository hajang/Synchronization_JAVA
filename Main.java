/**
 * Created by Ha on 16. 1. 7..
 */
public class Main {

    // main for testing consumer/producer
    public static void main(String[] args) {
        // 한개의 버퍼를 생성후 이를 공유하는 두개의 스레드 : 소비자, 생성자를 동작
        IntBuffer ib = new IntBuffer();

        Consumer c = new Consumer(ib);
        Producer p = new Producer(ib);

        c.start();
        p.start();
    }

    // main for testing AccountThread
    public static void account_main(String[] args) {
        // 잔액 100인 계좌 생성
        Account myaccount = new Account("Ha", 100);

        // 생성한 계좌로 Runnable 객체 생성
        AccountThread at = new AccountThread(myaccount);

        // 두개의 스레드가 한개의 계좌를 공유
        Thread t1 = new Thread(at);
        Thread t2 = new Thread(at);

        t1.start();
        t2.start();
    }
}
