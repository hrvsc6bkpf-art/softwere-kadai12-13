class Account {
private String name;
private String no;
private long balance;

Account(String n, String num, long z) {
name = n;
no = num;
balance = z;
}

//名前
String getName() {
return name;
}

//口座番号
String getNo() {
return no;
}

//預金残高
long getBalance() {
return balance;
}

//振り込み
void deposit(long k) {
balance += k;
}

//引き出し
void withdraw(long k) {
balance -= k;
}

}

// テスタークラス
class AccountTester {

public static void main(String[] args) {

Account[] x = { new Account("足立幸一","123456",1000),new Account("仲田真二","654321",200),
};

x[0].withdraw(200);
x[1].deposit(100);

System.out.println("■足立君の口座");
		System.out.println("口座名義：" + x[0].getName());
		System.out.println("口座番号：" + x[0].getNo());
		System.out.println("預金残高：" + x[0].getBalance());

		System.out.println("■仲田君の口座");
		System.out.println("口座名義：" + x[1].getName());
		System.out.println("口座番号：" + x[1].getNo());
		System.out.println("預金残高：" + x[1].getBalance());
	}
	}

