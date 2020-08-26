package com.company;
import java.util.*;
import java.io.*;
class Login
{
    static Scanner in = new Scanner(System.in);
    protected String id;
    private String pwd;


    public boolean getidSignIn() throws IOException {
        System.out.println("Enter your id:\t");
        id = in.next();
        System.out.println("Enter your password:\t");
        pwd = in.next();
        return checkid();
    }
    boolean check(String s1) {
        if (s1 == null)
            return false;
    int len = s1.length();
      for (int i = 0; i < len; i++) {
    if ((Character.isLetterOrDigit(s1.charAt(i)) == false)) {
        return false;
    }
}
      return true;
}
    private boolean checkid() throws IOException {
        FileReader r = new FileReader("/Users/apple/Desktop/user.txt");
        BufferedReader read = new BufferedReader(r);
        String s;
        try {
            while((s = read.readLine()) != null) {
                String a[]=s.split(" ");
                if(id.equals(a[0]) && pwd.equals(a[1]))
                {
                    return true;
                }
            }
            read.close();
            r.close();
            return false;
        }
        catch (EOFException e)
        {
            System.out.println();
        }

        return true;
    }
    private boolean checkidNew() throws IOException {
        FileReader r = new FileReader("/Users/apple/Desktop/user.txt");
        BufferedReader read = new BufferedReader(r);
        String s;
        try {
            while((s = read.readLine()) != null) {
                String a[]=s.split(" ");
                if(id.equals(a[0]))
                {
                    return true;
                }
            }
            read.close();
            r.close();
            return false;
        }
        catch (EOFException e)
        {
            System.out.println();
        }

        return true;
    }
    public void changePassword() throws IOException {
        System.out.println("Enter your id:\t");
        id = in.next();
        System.out.println("Enter your OLD password:\t");
        pwd = in.next();
        if(checkid()){
            String newPwd;
            System.out.println("Enter new password : ");
            newPwd=in.next();
            FileReader read = new FileReader("/Users/apple/Desktop/user.txt");
            BufferedReader reader = new BufferedReader(read);
            String s;
            String output="";
            while((s=reader.readLine())!=null){
                String a[]=s.split(" ");
                if(id.equals(a[0]) &&  pwd.equals(a[1])) {
                    a[1] = newPwd;
                    s="";
                   s += a[0] + " " + a[1] + System.lineSeparator();
                }
                output+=s;
            }
            reader.close();
            read.close();
            FileWriter f = new FileWriter("/Users/apple/Desktop/user.txt");
            BufferedWriter write = new BufferedWriter(f);
            write.write(output);
            write.close();
            f.close();
        }
        System.out.println("Password changed successfully :)");
    }
    public void getidSignUp() throws IOException {
        System.out.println("Enter your new id:\t");
        id = in.next();
        if(check(id)==false){
            System.out.println("Invalid ID !! Only alphabate or number.");
            getidSignUp();
        }
        System.out.println("Enter your new password:\t");
        pwd = in.next();

        if(pwd==null)getidSignUp();
        if (checkidNew())
        {
            System.out.println("FlightID source destination date arrivalT departureT  ");
            System.out.println("Id already exists!\nPlease enter new id");
            this.getidSignUp();
        }
        else
        {
            FileWriter w= new FileWriter("/Users/apple/Desktop/user.txt",true);
            BufferedWriter write = new BufferedWriter(w);
            String newID=id+" "+pwd+System.lineSeparator();
            write.write(newID);
            write.close();
            w.close();
            System.out.println("Id created successfully!");
        }
    }
}

