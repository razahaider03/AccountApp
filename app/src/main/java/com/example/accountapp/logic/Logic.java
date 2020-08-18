package com.example.accountapp.logic;

import com.example.accountapp.ui.OutputInterface;

import static com.example.accountapp.logic.Account.tripleIt;

/**
 * This is where the logic of this App is centralized.
 * <p/>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public
class Logic
        implements LogicInterface
{
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG=
            Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p/>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * </p>
     * This was renamed to 'mOut' from 'out', as it is in the video
     * lessons, to better match Android/Java naming guidelines.
     */
    private final OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p/>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'
     */
    public
    Logic ( OutputInterface out ) {
        mOut=out;
    }

    /**
     * This is the method that will ultimately get called when the
     * on-screen button labelled 'Process...' is pressed.
     */
    @Override
    public
    void process () {
        Account acct1=new Account(mOut);
        Account acct2=new Account(mOut);
        /*
          creating array of objects and filling with values
         */
        Account[] customer={new Account(mOut , "Rose Dior" , 389574) ,
                new Account(mOut , "Lucy Lastic" , 847004) ,
                new Account(mOut , "Viola Fuss" , 590432 , 182.90)};
        for ( Account account : customer ) {
            mOut.println(account.toString());
        }

        Account acctX=new Account(mOut , "Bob" , 674903 , 27.50);
        // mOut.println(acctX.toString()); # uncomm. for print acctx.
        tripleIt(acctX);
        acctX.displayBalance();

        // makes copy of existing object

        Account acctY = new Account(mOut);
        acctY.makeCopyOf(acctX);
        acctY.setName("RazaHaider");
        mOut.println(acctY.toString());

        /*acct1.name = "Bill";
        acct1.number = 738924;
        acct1.balance = 231.48;

        acct2.name = "Sue";
        acct2.number = 894730;
        acct2.balance =3000;
        Above code is working before the fields are private
*/
        acct1.setName("Rick Rudd");
        acct1.setNumber(298576);
        acct1.setBalance(150.2);
        mOut.println(acct1.getName());

        // mOut.println("Account number:- "+acct1.getNumber());
        mOut.println(acct1.getNumber()); //added println method to outputInterface to print integer
        // and also in MAinActivity

        mOut.println(acct1.getBalance());  // also displayBalance() works like this.

        // int value = acct1.getNumber();
        // *mOut.println(value);
        mOut.println("before");
        acct1.setBalance(15);  // overrides the previous setBalance
        acct1.displayBalance();
        acct1.deposit(18.91);
        mOut.println("After");
        mOut.println("Deposit is ");
        acct1.displayBalance();


        // acct1.deposit(89.00);
        // acct1.displayBalance();

       /* acct2.displayBalance();
        acct2.withdrawal(300);
        acct2.displayBalance();
*/
        // USing our own constructor
        Account acctA=new Account(mOut , "Sue Vlaki" , 289476);
        Account acctB=new Account(mOut , "Joseph schmoe" , 392784 , 187.13);

        mOut.println(acct1.toString());
        mOut.println(acctB.toString());

        acctA.displayBalance();
        acctB.displayBalance();
        acctB.withdrawal(100);
        acctB.displayBalance();
    }
}
