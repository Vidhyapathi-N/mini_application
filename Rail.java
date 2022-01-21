import java.util.*;
public class Rail {
    static int r,c,a,ch;
    static String train_name;
    static HashMap<String,Integer> ps=new HashMap<String,Integer>();
    static int [][] seat;
    static List<String>city=new ArrayList<String>();
    static Scanner sc=new Scanner(System.in);
     public static Boolean adminAuth(){
        System.out.println("-------------Welcome Admin------------");
        System.out.print("Enter your User name and PassWord:  ");
        String name=sc.next();
        System.out.print("Enter your  PassWord:  ");
        int num=sc.nextInt();
         if(name.compareTo("admin")==0 && num==1234)
            return true;
        return false;
     }
     public static void addTrain(){
        System.out.println("-------------Welcome Admin------------");
         System.out.print("Enter the train name: ");
         train_name=sc.next();
         System.out.println("Enter the number of Stations: ");
         int col=sc.nextInt();
         c=col;
         sc.nextLine();
         System.out.println("Enter the Name of Stations: ");
         for(int y=0;y<col;y++)
                city.add(sc.nextLine());
         System.out.print("Enter  the number of Seats Availabity: ");
         int row=sc.nextInt();
         r=row;
         seat=new int[row][col];
         }
     public static void seatAvail(){
        System.out.println("-------------Welcome Admin------------");
        System.out.println("The Available Seats as Per Station are :");
        System.out.print("   ");
        for (int i=1;i<=c;i++){
            System.out.print(i+"  ");
        }
        System.out.println("\n---------------------------");
        for(int i=0;i<r;i++){
            System.out.print(i+"| ");
            for(int j=0;j<c;j++){
                System.out.print(seat[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.print("Number of  Seats Already Reserved by Station:   ");
        int ava=sc.nextInt();
        for(int l=0;l<ava;l++){
            System.out.print("Enter the Seat at Specified Station:   ");
            int raaw=sc.nextInt();
            int caal=sc.nextInt();
            if(raaw>=r || caal>=c)
                {
                    System.out.println("Wrong Input");
                    l--;
                }
            else
                seat[raaw][caal]=1;
        }
     }
     public static void  display(){
        for (int i=0;i<c;i++){
            System.out.print(i+"  ");
        }
        System.out.println("\n---------------------------");
        for(int i=0;i<r;i++){
            System.out.print(i+"| ");
            for(int j=0;j<c;j++){
                System.out.print(seat[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("The seats with 1 are Occupied");
        System.out.println("Enter  1 to Continue");
        int m=sc.nextInt();
        System.out.print("\033[H\033[2J"); 
        System.out.flush();


    }
    public static void bookSeat(String a,String b1,String c1){
        
        int bi=city.indexOf(b1);
        int ci=city.indexOf(c1);
        int i=0;
        for(i=0;i<r;i++){
            int flag=1;
            for(int lp=0;lp<2;lp++){
            for(int j=bi;j<ci;j++){
                if(seat[i][j]==0){
                        flag=1;
                }  
                else{
                    flag=0;
                    break;
                }
                if(j==c-1)j=0;
            }
        }
            if(flag==1){
                for(int j=bi;j<ci;j++)
                    seat[i][j]=1;
                System.out.printf("Your Seat Number is %d \n",i);
                System.out.println("Your Ticket Has been booked...Thankyou");
                ps.put(a,i);
                System.out.println("Enter one to continue: ");
                int gt=sc.nextInt();
                break;
            }
        }
    }

    public static void main(String args[])
    {
        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    do{
        System.out.println("-----Welcome to Indian Railway----");
        System.out.println("1.Admin\n2.Passenger\n3.exit");
        System.out.print("Enter your choice: ");
        int ch=sc.nextInt();
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    if(ch==3){
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        break;
    }
    if(ch==1){
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
        if(adminAuth()){
            do{
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("-------------Welcome Admin------------");
            System.out.println("1.Add Trains\n2.Seat Availability\n3.exit");
            System.out.print("Enter your choice: ");

            a=sc.nextInt();
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            
            if(a==1){
                addTrain();
            }
            if(a==2){
                seatAvail();
            }
            if(a==3){
                System.out.println("-----Exit----");

                System.out.print("\033[H\033[2J"); 
                System.out.flush();
                
            }

            }
            while(a!=3);
            

        }
        else{
            System.out.println("Sry Wrong Authentication");
            adminAuth();
        }
        

        
        
    }
    if(ch==2){
        int g;
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        System.out.println("---------Welcome Passenger---------");
        System.out.print("Enter Your Username: ");
        String name=sc.next();
        System.out.println();
        System.out.print("Enter Your Station: ");
        String station=sc.next();
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        do{
        System.out.println("---------------- Passenger--------------");
        System.out.print("1.Display Trains\n2.check seats\n3.Book seats\n4.exit\n5.display my seat\nEnter a choice: ");
        g=sc.nextInt();
    
        
        if(g==1){
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("---------------- Passenger--------------");
            System.out.println("The train name is:  "+train_name);
            int k=1;
            for(String i:city){
                System.out.println(k+". "+i);
                k++;
            }
            
            System.out.print("Enter one to Continue: ");
            String kq=sc.next();
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            
        }
        if(g==2){
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("---------------- Passenger--------------");
            display();
        }
        if(g==3){
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("---------------- Passenger--------------");
            System.out.print("Enter your Name: ");
            sc.nextLine();
            String nameps=sc.nextLine();
            System.out.print("Enter your Arriving Station: ");
            String arr=sc.nextLine();
            System.out.println("Enter Your Departure Station: ");
            String dep=sc.nextLine();
            bookSeat(nameps,arr,dep);
            
        }
        if(g==5){
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("Enter your Name:");
            String kre=sc.next();
            System.out.printf("%s have been Allocated Seat no: %d \n",kre,ps.get(kre));
            System.out.println("Enter 1 to continue");
            int vf=sc.nextInt();
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
        }
        }while(g!=4);
        

    }
    
    }while(ch!=3);

}
}

