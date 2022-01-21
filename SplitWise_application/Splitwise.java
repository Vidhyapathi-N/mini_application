import java.util.*;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
public class Splitwise{
    static Scanner sc=new Scanner (System.in);
    static List<Integer> pa=new ArrayList<>();
    static String st;
    static int index;
    static ArrayList<Users> us=new ArrayList<>();
    static String heShe="";
    static ArrayList<Expenses> ex=new ArrayList<>();

    public static void main(String args[])
    {
        cls();
        us.add(new Users("vidhyapathi","vidhyapathimnr@gmail.com", 2001,2000,new HashMap<>(),""));
        us.add(new Users("sakthivel","sakthivelmnr@gmail.com", 2002,2000,new HashMap<>(),""));
        us.add(new Users("pranesh","praneshmnr@gmail.com", 2003,2000,new HashMap<>(),""));
        us.add(new Users("sairanjan","sairanjanmnr@gmail.com", 2004,2000,new HashMap<>(),""));
        ex.add(new Expenses("Hotel bill",2000,"heShe","kingname","Datetime"));
        frontpage();
    }

    public static void frontpage(){
        System.out.println("WELCOME TO SPLIT WISE APPLICATION");
        System.out.print("1.group\n2.Expenses\n3.exit");
        int a=sc.nextInt();
        switch(a){
            case 1:
                group();
                break;
            case 2:
               // Expenses();
                break;
            case 3:
                System.out.println("THANK YOU");
                enter();
                cls();

        }
    }
    public static void group(){
        System.out.println("Friends");
        for(int i=0;i<us.size();i++){
            System.out.println(i+1+" "+us.get(i).name);
        }
        System.out.print("Enter your name to login: ");
        sc.nextLine();
        st=sc.nextLine();
        if(authfrnd(st)){
            Induvidual();
        }
        else{
            System.out.println("WRONG LOGIN! TRY AGAIN");
            frontpage();
        }
    }

    public static void Induvidual(){
            System.out.print("1.Pay Expenses\n2.Amount to be payed\n3.Amount to be received\n4.view Wallet\n5.Add friends\n6.view Expeses\n7.exit\n");
            System.out.println("Enter a choice");
            int t=sc.nextInt();
            switch(t){
                case 1:
                    PayExpenses(st);
                    break;
                
                case 2:
                    AmountPay();
                    break;
                case 3:
                   // AmountReceive();
                    break;
                case 4:
                   // ViewWallet();
                    break;
                case 5:
                  //  Addfriendda();
                    break;
                case 6:
                   // ViewExpenses();
                    break;
                case 7:
                    group();
                    enter();
                    cls();
}
        }            
    
    public static void ViewExpenses(){
        System.out.println("DETAILS ABOUT THE EXPENSES");
        
    }
    public static void AmountPay(){
        System.out.println("YOUR DEPT TO YOUR FRIENDS ARE: ");
        for(String key:us.get(index).pend.keySet()){
            System.out.println(key+"  "+us.get(index).pend.get(key));
           
        }

        enter();
        cls();
        Induvidual();
        

    }
    public static void PayExpenses(String st){
        System.out.println("---YOU CAN PAY EXPENSES HERE----");
        System.out.print("Enter the Expense name: ");
        sc.nextLine();
        String as=sc.nextLine();
        System.out.print("Enter the total amount: ");
        int s=sc.nextInt();
        System.out.print("/n1.Group expense or 2.Non Group Expenses");
        int ch=sc.nextInt();
        if(ch==1)GroupExpense(st,s);
        if(ch==2)NonGroup(st,s);
        Induvidual();


        
    }
    public static void NonGroup(String st,int amt){
        int share=amt/2;
        System.out.print("Enter the friend name :");
        sc.nextLine();
        String kl=sc.nextLine();
        for(int i=0;i<us.size();i++){
            if(us.get(i).name.equals(kl)){
                us.get(i).pend.put(us.get(index).name,share);
                break;
            }
        }
        enter();
        cls();
        Induvidual();


    }
    public static void GroupExpense(String st,int amt){
        int share=amt/us.size();
        for(int i=0;i<us.size();i++){
            if(!(us.get(i).name.equals(st))){
                us.get(i).pend.put(us.get(index).name,share);
                System.out.println(us.get(index).name+" "+share);
            }
        }
        System.out.println("--THE AMOUNT IS SHARED--");
        enter();
        cls();
        Induvidual();

    }
    public static boolean authfrnd(String s){
        int flag=0;
        System.out.print("Enter the Email: ");
       
        String ij=sc.nextLine();
        System.out.print("Enter the password: ");
        int a=sc.nextInt();
        for(int i=0;i<us.size();i++){
            if(s.equals(us.get(i).name) && us.get(i).password==a && us.get(i).email.equals(ij)){
                index=i;
                System.out.println("YOU ARE LOGGED IN SUCCESSFULLY");
                flag=1;
                enter();
                cls();
                return true;
                
            }
            

        }
        if(flag==0){
            System.out.println("LOGIN FAILED TRY AGAIN");
            enter();
            cls();
            return false;
        }
        return false;
    }
    public static void secondpage(){
        System.out.print("1.Add Friends\n2.Show Friends\n");
        int a=sc.nextInt();
        cls();
        switch(a){
            case 1:
                AddFriends();
                break;
            case 2:
                ShowFriends();
                break;
        }

    }
    public static void AddFriends(){
        System.out.println("YOU CAN ADD FRIENDS HERE !!!");
        System.out.print("Enter the friend name: ");
        sc.nextLine();
        String s=sc.nextLine();
        System.out.print("Enter the E-MAIL ID: ");
        String s1=sc.nextLine();
        System.out.print("Enter the PassWord: ");
        int s2=sc.nextInt();
        us.add(new Users(s,s1,s2,2000,pa,""));
        System.out.println(s+" "+s1+" "+s2);
        enter();
        cls();
        secondpage();


    }
    public static void ShowFriends()
    {
        System.out.println("HERE YOU CAN SEE YOUR FRIENDS");
        for(int i=0;i<us.size();i++){
            System.out.println(us.get(i).name);
        }
        System.out.println("\5");
        enter();
        cls();
        secondpage();

    }
    public static void enter(){
        System.out.println("---Press Enter to continue---");
        String k=sc.nextLine();
        String s=sc.nextLine();
        s+=s;
    }
    public static void cls(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
class Users{
    String name,email,TransHis;
    int wallet,password;
    List<Integer> pendingamt = new ArrayList<>();
    HashMap<String,Integer> pend=new HashMap<>();
    public Users(String name,String email,int password,int wallet,HashMap<String,Integer> pend,String TransHis)
    {
        this.name=name;
        this.email=email;
        this.password=password;
        this.wallet=wallet;
        this.pend.put("",1);
        this.TransHis=TransHis;
    }
}
class Expenses{
    String Billname;
    int totAmt;
    String heShe;
    String kingname;
    String Datetime;
    
    public Expenses(String Billname,int totAmt,String heShe,String kingname,String Datetime){
        this.Billname=Billname;
        this.totAmt=totAmt;
        this.heShe=heShe;
        this.kingname=kingname;
        this.Datetime=Datetime;

    }

}