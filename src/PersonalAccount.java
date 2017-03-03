import java.util.Scanner;

/**
 * Created by Chumlung on 3/2/2017.
 */
public class PersonalAccount extends BankActions {
    private static int NoA = 0;
    public String username = new String();
    public double balance;
    public static PersonalAccount[] Acc = new PersonalAccount[20];


    public static void create(int i, String acname) {
        Acc[i] = new PersonalAccount();
        Acc[i].username = acname;
        Acc[i].balance = 0;
    }


    public static int search(String name) {
        int find = 0;
        for (int i = 0; i < NoA; i++) {
            if (name.equals(Acc[i].username)) {
                find = i + 1;
                break;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        String choice;

        do {
            System.out.println("a.Create an account");
            System.out.println("b.Show all account details");
            System.out.println("c.Deposit Amount");
            System.out.println("d.Withdraw Amount");
            System.out.println("e.Transfer Amount");
            System.out.println("f.Exit");
            System.out.println("Enter you choice");
            Scanner io = new Scanner(System.in);
            choice = io.next();
            switch (choice) {
                case "a":
                    System.out.println("Enter Account Name:");
                    String newname = io.nextLine();
                    create(NoA, newname);
                    NoA++;
                    System.out.println("Account Created.");
                    break;

                case "b":
                    for (int j = 0; j < NoA; j++) {
                        System.out.println("Name:" + Acc[j].username + "    Balance:" + Acc[j].balance);
                    }
                    break;

                case "c":
                    System.out.println("Enter Account Name:");
                    String inname = io.nextLine();
                    int dpt = search(inname);
                    if (dpt > 0) {
                        System.out.println("Enter Amount you want to deposit");
                        double damt = io.nextDouble();
                        Acc[dpt - 1].deposit(Acc[dpt - 1], damt);
                        System.out.println(Acc[dpt - 1].username + " Your new balance is Rs." + Acc[dpt - 1].balance);
                    } else
                        System.out.println("Sorry, the account does not exist.Please create an account.");
                    break;

                case "d":
                    System.out.println("Enter Account Name:");
                    String inwname = io.next();
                    int wpt = search(inwname);
                    if (wpt > 0) {
                        System.out.println("Enter Amount to withdraw");
                        double wamt = io.nextDouble();
                        if (wamt <= Acc[wpt - 1].balance) {
                            Acc[wpt - 1].withdraw(Acc[wpt - 1], wamt);
                            System.out.println(Acc[wpt - 1].username + " Your new balance is Rs." + Acc[wpt - 1].balance);
                        } else
                            System.out.println("Your Account does not have enough balance.");
                    } else
                        System.out.println("Sorry, the account does not exist. Please create an account.");
                    break;

                case "e":
                    System.out.println("Enter Account name to transfer from:");
                    String tnsfrfrm = io.next();
                    int frm = search(tnsfrfrm);
                    System.out.println("Enter Account name to transfer to:");
                    String tnsfrto = io.next();
                    int to = search(tnsfrto);
                    if (frm > 0 && to > 0) {
                        System.out.println("Enter amount to transfer");
                        double tnsframt = io.nextDouble();
                        if (Acc[frm - 1].balance < tnsframt) {
                            System.out.println("Sorry," + Acc[frm - 1].username + "does not have enough balance.");
                        } else {
                            Acc[frm - 1].transfer(Acc[to - 1], Acc[frm - 1], tnsframt);
                            System.out.println("Transfer Success");
                            System.out.println("New Account Information");
                            System.out.println(Acc[frm - 1].username + " now has " + Acc[frm - 1].balance);
                            System.out.println(Acc[to - 1].username + " now has " + Acc[to - 1].balance);
                        }
                    } else {
                        if (frm == 0)
                            System.out.println("Account to transfer from does not exist");
                        else
                            System.out.println("Account to transfer to does not exist");
                    }
                    break;
                case "f":
                    break;

                default:
                    System.out.println("Please enter choice from the list");

            }

        } while (!choice.equals("f"));


    }
}
