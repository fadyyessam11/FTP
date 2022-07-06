import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/*
 *
 * @author FaDyy
 */


public class FtpClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        try{
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
            Socket ftpserver = new Socket(address, 5000);
            InetAddress ip = InetAddress.getLocalHost();
            Socket server = new Socket(ip, 15000);
            while (true) {
                Cconnection connection = new Cconnection(ftpserver, server);
                connection.run();
                break;


            }
        }
        catch(IOException error){
            System.out.println("Failed Connection");
        }
    }

    static class Cconnection extends Thread {

        Socket ftpserver;
        Socket server;

        Cconnection(Socket ftpserver, Socket server) {
            this.ftpserver = ftpserver;
            this.server = server;
        }

        public void run() {
            try {
                DataInputStream ClientRead = new DataInputStream(ftpserver.getInputStream());
                DataOutputStream Clientwrite = new DataOutputStream(ftpserver.getOutputStream());
                Scanner Input = new Scanner(System.in);
                String pass = " ";
                String name = " ";

                String s1 = ClientRead.readUTF();
                System.out.println(s1);

                s1 = ClientRead.readUTF();
                System.out.println(s1);

                name = Input.next();
                Clientwrite.writeUTF(name);
                s1 = ClientRead.readUTF();

                if (s1.toLowerCase().equals("exist")) {
                    s1 = ClientRead.readUTF();
                    System.out.println(s1);
                    pass = Input.next();
                    Clientwrite.writeUTF(pass);
                    s1 = ClientRead.readUTF();
                    System.out.println(s1);



                    // SECOND TCP CONNECTION
                    try {
                        DataInputStream input = new DataInputStream(server.getInputStream());
                        DataOutputStream output = new DataOutputStream(server.getOutputStream());
                        Scanner scan = new Scanner(System.in);

                        String i = input.readUTF();
                        System.out.println(i);    // what do you want to show?
                        String j;

                        while (true) {

                            j = scan.nextLine();
                            output.writeUTF(j);     //show my directories

                            if (j.equalsIgnoreCase("show my directories")) {

                                ////////////////////////////
                                i = input.readUTF();
                                System.out.println(i);//Docs
                                i = input.readUTF();
                                System.out.println(i);//Movies
                                i = input.readUTF();
                                System.out.println(i);//Music
                                ////////////////////////////

                                while (true) {

                                    j = scan.nextLine();
                                    output.writeUTF(j);

                                    if (j.equalsIgnoreCase("show docs") || j.equalsIgnoreCase("show movies") || j.equalsIgnoreCase("show music")) {
                                        ////////////////////////////
                                        i = input.readUTF();
                                        System.out.println(i);    //music1 or joker or doc1
                                        i = input.readUTF();
                                        System.out.println(i);  //music2 or darkknight or doc2
                                        i = input.readUTF();
                                        System.out.println(i);   //music3 or the prestige or do3
                                        ////////////////////////////
                                        while (true) {

                                            String ff = scan.nextLine();
                                            output.writeUTF(ff);

                                            if (ff.equalsIgnoreCase("doc1") || ff.equalsIgnoreCase("doc2") || ff.equalsIgnoreCase("doc3")
                                                    || ff.equalsIgnoreCase("joker") || ff.equalsIgnoreCase("darkknight") || ff.equalsIgnoreCase("the prestige")
                                                    || ff.equalsIgnoreCase("music1") || ff.equalsIgnoreCase("music2") || ff.equalsIgnoreCase("music3")) {

                                                i = input.readUTF();
                                                System.out.println(i);//opening the file
                                                break;

                                            } else {
                                                i = input.readUTF();
                                                System.out.println(i);
                                            }
                                        }
                                        break;
                                    } else {
                                        i = input.readUTF();
                                        System.out.println(i);
                                    }
                                }
                                break;
                            } else {
                                i = input.readUTF();
                                System.out.println(i);
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    String s2 = ClientRead.readUTF();
                    System.out.println(s1);
                    System.out.println("Login Failed and the Connection will Terminate");
                    ClientRead.close();
                    Clientwrite.close();
                }

                try {
                    Scanner sca = new Scanner(System.in);
                    //System.out.println("enter close");
                    String ii = sca.nextLine();
                    Clientwrite.writeUTF(ii);

                    if (ii.equalsIgnoreCase("close")) {
                        ClientRead.close();
                        Clientwrite.close();
                        System.out.println("Closing..");

                    }
                } catch (IOException v) {
                    v.printStackTrace();
                }



            } catch (Exception e) {
                System.out.println("Problem in connection with it's client ! ");
            }
        }
    }
}