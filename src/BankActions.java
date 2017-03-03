/**
 * Created by Chumlung on 3/2/2017.
 */
public class BankActions {


    public void deposit(PersonalAccount UserAccount, double Depositamt) {
        UserAccount.balance = UserAccount.balance + Depositamt;

    }

    public void withdraw(PersonalAccount UserAccount, double Withdrawamt) {
        UserAccount.balance = UserAccount.balance - Withdrawamt;

    }

    public void transfer(PersonalAccount Trnsferto, PersonalAccount Trnsferfrm, double amt) {
        Trnsferto.balance = Trnsferto.balance + amt;
        Trnsferfrm.balance = Trnsferfrm.balance - amt;

    }

}
