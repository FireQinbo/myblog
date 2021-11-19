package study.thread;

import lombok.SneakyThrows;

/**
 * @author qinb
 * 线程不安全的银行
 * @date 2021/9/16 14:44
 */
public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(800, "结婚基金");

        Bank bank1 = new Bank(account, 50, "我");
        Bank bank2 = new Bank(account, 100, "媳妇儿");
        bank1.start();
        bank2.start();
    }
}

//账户
class Account{
    //账户余额
    int money;
    //账户名称
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行取钱
class Bank extends Thread {
    //账户
    Account account;
    //要取的钱
    int drawingMoney;
    //手里的钱
    int nowMoney;

    public Bank(Account account, int drawingMoney, String threadName) {
        super(threadName);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }


    @SneakyThrows
    @Override
    public void run() {
        //synchronized（Obj）同步代码块，实现线程安区
        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(this.getName() + "余额不足！");
                return;
            }

            Thread.sleep(1000);

            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为：" + account.money);
            System.out.println(Thread.currentThread().getName() + "手里的钱：" + nowMoney);
        }
    }
}
