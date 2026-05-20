import java.util.Scanner;

class Account {
    private String name;
    private String no;
    private long balance;

    // コンストラクタ
    Account(String n, String num, long z) {
        name = n;
        no = num;
        balance = z;
    }

    // 名前取得
    String getName() {
        return name;
    }

    // 口座番号取得
    String getNo() {
        return no;
    }

    // 残高取得
    long getBalance() {
        return balance;
    }

    // 入金
    void deposit(long k) {
        balance += k;
    }

    // 出金
    void withdraw(long k) {
        if (balance >= k) {
            balance -= k;
        } else {
            System.out.println("残高不足です");
        }
    }

    void transfer(Account a, long k) {
        if (balance >= k) {
            balance -= k;
            a.deposit(k);
        } else {
            System.out.println("送金できません（残高不足）");
        }
    }
}

// テスタークラス
public class AccountTester {

    public static void main(String[] args) {

        Account[] x = {
            new Account("足立幸一", "123456", 1000),
            new Account("仲田真二", "654321", 200)
        };

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== メニュー ===");
            System.out.println("1: 入金");
            System.out.println("2: 出金");
            System.out.println("3: 送金");
            System.out.println("4: 残高表示");
            System.out.println("0: 終了");
            System.out.print("選択: ");

            int choice = sc.nextInt();

            // 終了
            if (choice == 0) {
                System.out.println("終了します");
                break;
            }

            // 口座選択
            System.out.print("口座番号 (0:足立 1:仲田): ");
            int idx = sc.nextInt();

            if (idx < 0 || idx >= x.length) {
                System.out.println("口座番号が不正です");
                continue;
            }

            // 入金
            if (choice == 1) {

                System.out.print("入金額: ");
                long money = sc.nextLong();

                x[idx].deposit(money);

                System.out.println("入金完了");
            }

            // 出金
            else if (choice == 2) {

                System.out.print("出金額: ");
                long money = sc.nextLong();

                x[idx].withdraw(money);

                System.out.println("出金処理完了");
            }

            // 送金
            else if (choice == 3) {

                System.out.print("送金先口座番号 (0 or 1): ");
                int to = sc.nextInt();

                System.out.print("送金額: ");
                long money = sc.nextLong();

                if (to >= 0 && to < x.length) {

                    x[idx].transfer(x[to], money);

                    System.out.println("送金完了");

                } else {

                    System.out.println("送金先が不正です");
                }
            }

            // 残高表示
            else if (choice == 4) {

                System.out.println("口座名義：" + x[idx].getName());
                System.out.println("口座番号：" + x[idx].getNo());
                System.out.println("残高：" + x[idx].getBalance());
            }

            // 不正入力
            else {

                System.out.println("無効な選択です");
            }
        }

        sc.close();
    }
}