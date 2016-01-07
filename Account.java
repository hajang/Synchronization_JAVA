/**
 * Created by Ha on 16. 1. 7..
 */
public class Account {
    String username;
    double userBalance;

    public Account(String username, double balance) {
        this.username = username;
        userBalance = balance;
    }

    // 입금
    public boolean deposit(double amount){

        if(amount < 0.0)
            return false; // 음수를 더할 수 없음
        else{
            synchronized (this){ // userBalance 에 대하여 동기화 처리
                userBalance += amount;
            }
        }

        return true;
    }

    // 출금
    /*
        public synchronized boolean withdraw(double amount) 와
        public boolean withdraw(double amount){
            synchronized(this){
                ...
            }
        } 는 동일하다.
    */
    public boolean withdraw(double amount){

        synchronized (this) {
            if (amount > userBalance)
                return false; // 잔액 부족
            else
                userBalance -= amount;
        }

        return true;
    }

}
