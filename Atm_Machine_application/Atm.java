import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Atm
{
	static int  loginac=0;
	static Scanner sc=new Scanner(System.in);
	static HashMap<Integer,Integer> cash=new HashMap<Integer,Integer>();
	static HashMap<Integer,Integer> userdeno=new HashMap<Integer,Integer>();
	static HashMap<String,Integer> user=new HashMap<String,Integer>();
	static int org=1234;
	static String s="";
	static String atm="sbi";
	static int co=0;
	static int two2,tho1,fiv5,hun1;
	static int total=0;
	static int gh;
	static int balanceu1=4001;
	static int hg=balanceu1;
	public static void addAmount(){
		
		System.out.println("How many 2000 to be added");
		two2=sc.nextInt();
		total+=(2000*two2);
		cash.put(2000,two2);
		System.out.println("How many 1000 to be added");
	    tho1=sc.nextInt();
	    total+=(1000*tho1);
		cash.put(1000,tho1);
		System.out.println("How many 500  to be added");
		fiv5=sc.nextInt();
		total+=(500*fiv5);
		cash.put(500,fiv5);
		System.out.println("How many 100  to be added");
		hun1=sc.nextInt();
		total+=(100*hun1);
		cash.put(100,hun1);
		System.out.println("Press Enter to Continue");
		gh=total;
		 
		
		
	}
	public static void display(){
		
		for(Map.Entry k:cash.entrySet())
			{
			System.out.println(k.getKey()+"  "+k.getValue());
			}
		System.out.println("ATM BALANCE-------"+total);
		
	}
	public static void withdraw() {
		int flag=0;
		System.out.println("What Atm card bank?");
		String po=sc.nextLine();
		if(po.compareTo(atm)!=0)
			co++;
		System.out.println("Enter the amount to be Withdraw");
		int wd=sc.nextInt();
		sc.nextLine();
		int temp=wd;
		int sum;
		int a=(int)cash.get(2000),b=(int)cash.get(1000),c=(int)cash.get(500),d=(int)cash.get(100);
		userdeno.put(2000,0);
		userdeno.put(1000,0);
		userdeno.put(500,0);
		userdeno.put(100,0);
		while(temp!=0) {
			
			if(temp>=2000 && cash.get(2000)!=0 && balanceu1!=0 && total!=0) {
				temp-=2000;
				userdeno.put(2000,userdeno.get(2000)+1);
				balanceu1-=2000;
				cash.replace(2000,cash.get(2000)-1);
				total-=2000;
			}
			else if(temp>=1000 && cash.get(1000)!=0 && balanceu1!=0 && total!=0) {
				temp-=1000;
				//b+=1;
				userdeno.put(1000,userdeno.get(1000)+1);
				balanceu1-=1000;
				cash.replace(1000,cash.get(1000)-1);
				total-=1000;
			}
			else if(temp>=500 && cash.get(500)!=0 && balanceu1!=0 && total!=0) {
				temp-=500;
				//c+=1;
				userdeno.put(500,userdeno.get(500)+1);
				balanceu1-=500;
				cash.replace(500,cash.get(500)-1);
				total-=500;
			}
			else if(temp>=100 && cash.get(100)!=0 && balanceu1!=0 && total!=0) {
				temp-=100;
				//d+=1;
				userdeno.put(100,userdeno.get(100)+1);
				balanceu1-=100;
				cash.replace(100,cash.get(100)-1);
				total-=100;
			}
			else {
				
				System.out.println("------------------Insufficient Balance---------------");
				System.out.println("You can only take::::");
				total=gh;
				balanceu1=hg;
				cash.replace(2000,a);
				cash.replace(1000,b);
				cash.replace(500,c);
				cash.replace(100,d);
				flag=1;
				
				
				
				break;
			}
			
		}
		if(flag!=1) {
			s+=wd;
			s+=" 		";
			s+=total;
			s+="\n";
		}
		int vp=0;
		for(Map.Entry l:userdeno.entrySet()) {
			vp+=(int)l.getValue();
			System.out.println(l.getKey()+" "+l.getValue());
			
	}
		if(co>3) {
		    System.out.println("Your are Detected Rs.50");
			balanceu1-=50;
			
		}
		
	
		}
	public static void checkbalance() {
		System.out.println("Your Balance is--"+balanceu1);
	}
	public static void main(String[] args) {
		user.put("ram", 9000);


		
		cash.put(2000,0);
		cash.put(1000,0);
		cash.put(500,0);
		cash.put(100,0);
		int ch=0;
		do {
		System.out.println("----------------------------------------ATM MACHINE-----------------------------");
		System.out.println("1.Admin Login");
		System.out.println("2.User Login");
		System.out.println("3.Exit");
		
		System.out.print("Choice  ");
		ch=sc.nextInt();
		sc.nextLine();
		switch(ch) {
		case 1:
			
			System.out.println("Enter your Id");
			String id=sc.nextLine();
			System.out.println("Enter your pass");
			int pass=sc.nextInt();
			if(id.compareTo("admin")==0  && pass==2001) {
				while(true) {
				System.out.println("-----------------------------ADMIN------------------------");
				System.out.print("1.load\n2.display\n3.clear\n");
				System.out.print("enter your choice: ");
				int lo=sc.nextInt();
				if(lo==1) {
					addAmount();
					continue;
				}
					
				else if(lo==2) {
					display();
					 
					continue;
				}
				else if(lo==3)
					break;
					
			}
			}
			
			
			break;
		
		case 2:
			while(true && loginac<4) {
				
				System.out.println("Enter your username");
				String qw=sc.nextLine();
				System.out.println("Enter your password");
				int pw=sc.nextInt();
				
				sc.nextLine();
				
			if(user.containsKey(qw) && pw==org) {
			System.out.println("------------------------WELCOME USER-------------------");
			System.out.println("1.withdraw\n2.check balance\n3.clear\n4.Pin\n5.transcation");
			System.out.println("Enter Your Choice");
			int uscho=sc.nextInt();
			sc.nextLine();
			if(uscho==1) {
				withdraw();
				 
			}
			else if(uscho==2) {
				checkbalance();
				
			}
			else if(uscho==4) {
				System.out.println("Enter the new Pin");
				int tt=sc.nextInt();
				sc.nextLine();
				org=tt;
				System.out.println("----PIN CHANGED------");
			}
			else if(uscho==5) {
				System.out.println("Withdrawn        Total");
				System.out.println(s);
			}
			else 
				{
				System.out.println("Wrong User");
				break;
				}
			}
			else 
				loginac++;
				
				
			}
			break;
		case 3:
			System.out.println("----Closed-----");
			break;
		
		default:
			System.out.println("----Invalid Input-----"); 
		
		}
		}
		while(ch!=3);
		

       }
}