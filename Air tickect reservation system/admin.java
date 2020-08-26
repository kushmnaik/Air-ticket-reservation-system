package com.company;
import java.util.*;
import java.io.*;
public class admin extends Login {
    static Scanner in = new Scanner(System.in);
    int flightID;
    String source,destination;
    int fSeat,fFare,sSeat,sFare;
    class date
    {
        int dd,mm,yy;
        void getDate()
        {
            try {
                System.out.println("\nEnter day : ");
                dd = in.nextInt();
                System.out.println("\nEnter month : ");
                mm = in.nextInt();
                System.out.println("\nEnter year : ");
                yy = in.nextInt();
                if (isValidDate(dd, mm, yy) == false) {
                    this.getDate();
                    System.out.println("\n\tInvalid date!\n\t Enter valid date");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input !! Enter digits!");
                in.nextLine();
                getDate();
            }
        }
        boolean isLeap(int year)
        {
            return (((year % 4 == 0) &&
                    (year % 100 != 0)) ||
                    (year % 400 == 0));
        }
        boolean isValidDate(int d, int m, int y)
        {
            if (m < 1 || m > 12)
                return false;
            if (d < 1 || d > 31)
                return false;
            if (m == 2)
            {
                if (isLeap(y))
                    return (d <= 29);
                else
                    return (d <= 28);
            }
            if (m == 4 || m == 6 ||
                    m == 9 || m == 11)
                return (d <= 30);
            return true;
        }
    }
    class time
    {
        int hour,min;
        void getTime()
        {
            try {
                System.out.println("\nEnter the hour : ");
                hour = in.nextInt();
                System.out.println("Enter the min : ");
                min = in.nextInt();
                if (min < 0 || min > 60 || hour < 0 || hour > 24) {
                    System.out.println("Invalid time! Enter again :)");
                    getTime();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input !! please enter digits!");
                in.nextLine();
                getTime();
            }
        }
    }
    void addFlight()throws IOException
    {
        date d = new date();
        time arrival = new time();
        time departure = new time();
        try {
            System.out.println("\nEnter following details to add flight : ");
            System.out.println("Enter the flightID : ");
            flightID = in.nextInt();
            System.out.println("Enter the source of flight : ");
            source = in.next();
            System.out.println("Enter the destination of flight");
            destination = in.next();
            System.out.println("Enter the date of flight : ");
            d.getDate();
            System.out.println("Enter the departure time : ");
            departure.getTime();
            System.out.println("Enter the arrival time : ");
            arrival.getTime();
            System.out.println("Enter the number of seats for the first class : ");
            fSeat = in.nextInt();
            System.out.println("Enter the fair for the first class : ");
            fFare = in.nextInt();
            System.out.println("Enter the number of seats for the second class : ");
            sSeat = in.nextInt();
            System.out.println("Enter the fair for the second class : ");
            sFare = in.nextInt();

            FileWriter f = new FileWriter("/Users/apple/Desktop/flights.txt", true);
            BufferedWriter writer = new BufferedWriter(f);
            String flightDetail = "";
            flightDetail += flightID + " " + source + " " + destination + " " + d.dd + "/" + d.mm + "/" + d.yy + " " + departure.hour + ":"
                    + departure.min + " " + arrival.hour + ":" + arrival.min + " " + fSeat + " " + fFare + " " + sSeat + " " + sFare + System.lineSeparator();
            writer.write(flightDetail);
            writer.close();
            f.close();
            System.out.println("Flight added to file successfully 🙂");
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input !! please enter digits!");
            in.nextLine();
            addFlight();
        }
    }
    void CancelFlight() {
        try {
            boolean fl=true;
            System.out.println("Enter the FlightID of flight to be deleted : ");
            String id;
            id = in.next();
            FileReader read = new FileReader("/Users/apple/Desktop/flights.txt");
            BufferedReader reader = new BufferedReader(read);
            String s;
            int flag = 0;
            String output = "";
            while ((s = reader.readLine()) != null) {
                fl=true;
                String a[] = s.split(" ");
                if (a[0].equals(id) ){
                    flag = 1;
                    fl=false;
                    continue;
                }
                if(fl){
                    s+="\n";
                }
                output = output + s;
            }
            reader.close();
            read.close();
            FileWriter f = new FileWriter("/Users/apple/Desktop/flights.txt");
            BufferedWriter write = new BufferedWriter(f);
            write.write(output);
            write.close();
            f.close();
            if (flag == 1)
                System.out.println("\nFlight canceled successfully 🙂");
            else
                System.out.println("\nFlight not found try again !");
        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (EOFException e) {
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input !! please enter digits!");
            in.nextLine();
            CancelFlight();
        }
    }
    void checkStatus()throws IOException
    {
        try{
            boolean fl=true;
            FileReader r = new FileReader("/Users/apple/Desktop/flights.txt");
            BufferedReader read =new BufferedReader(r);
            String s;
            System.out.println("\nEnter FlightID to check the flight booking status : ");
            String id;
            id = in.next();
            while((s=read.readLine())!=null)
            {
                String a[]=s.split(" ");
                if(id.equals(a[0]))
                {
                    System.out.println("\nFlight ID : "+a[0]);
                    System.out.println("\nSource : "+a[1]+" to destination : "+a[2]);
                    System.out.println("\nDate : "+a[3]+"\tTime : "+a[4]+" to "+a[5] );
                    System.out.println("\nNumber of seats remaining of first class : "+a[6]);
                    System.out.println("\nNumber of seats remaining of Second class : "+a[7]);
                    fl=false;
                    break;
                }
            }
            if(fl)
            System.out.println("\nNo such Flight found !");
        }
        catch (EOFException e)
        {
            System.out.println("");
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Input !! please enter digits!");
            in.nextLine();
            checkStatus();
        }
    }

}
