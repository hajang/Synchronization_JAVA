/**
 * Created by Ha on 16. 1. 7..
 */
/**
 * Created by Ha on 16. 1. 7..
 */
// Account 객체를 지니는 Runnable 객체
public class AccountThread implements Runnable {
    Account c;

    public AccountThread(Account c) {
        this.c = c;
    }

    @Override
    public void run() {
        // 바로 아래에서 c.userBalance를 참조 하기 때문에 여기도 동기화를 해주어야 함
        synchronized (c) {

            // 잔고가 남아있는 동안 계속해서 출금 시도
            while (c.userBalance > 0.0) {

                // 10, 20, 30 중 랜덤으로 generate
                int money = (int) (Math.random() * 3 + 1) * 10;

                // 계좌에서 출금
                double original_balance = c.userBalance;
                c.withdraw(money);
                System.out.println("Withdrawing " + money + ", Balance : (" + original_balance + " - " + money + ") = " + c.userBalance);
            }
        }
    }
}
