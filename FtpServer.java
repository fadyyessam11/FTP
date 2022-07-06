import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;


/*
 *
 * @author FaDyy
 */

public class FtpServer {

    static ServerSocket ftpserver;
    static ServerSocket Server;

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket ftpserver = new ServerSocket(5000);
            ServerSocket Server = new ServerSocket(15000);
            while (true) {
                Socket ftpclient = ftpserver.accept();
                Socket Client = Server.accept();
                Cconnection connection = new Cconnection(ftpclient, Client);
                connection.start();
                //break;
            }

        } catch (Exception error) {
            System.out.println("Failed Connection ! ");
        }
    }

    static class Cconnection extends Thread {

        Socket ftpclient;
        Socket Client;

        Cconnection(Socket ftpclient, Socket Client) {
            this.ftpclient = ftpclient;
            this.Client = Client;
        }

        public void run() {
            try {
                DataInputStream ServerRead = new DataInputStream(ftpclient.getInputStream());
                DataOutputStream Serverwrite = new DataOutputStream(ftpclient.getOutputStream());
                Serverwrite.writeUTF("Connection Successful");
                File file = new File("ftpjava.txt");
                try {
                    Scanner inputfromclient = new Scanner(file);
                    inputfromclient.hasNext();
                    //String intro;
                    Serverwrite.writeUTF("Please Enter your Name");
                    String name = ServerRead.readUTF();
                    String s1 = " ";
                    String s2 = " ";
                    while (inputfromclient.hasNextLine()) {
                        String str = inputfromclient.nextLine();
                        String[] array = str.split(",");
                        if (name.toLowerCase().equals(array[0])) {
                            s1 = "exist";
                            Serverwrite.writeUTF(s1);
                            Serverwrite.writeUTF("Please Enter your Password");
                            String password = ServerRead.readUTF();
                            if (password.toLowerCase().equals(array[1])) {
                                Serverwrite.writeUTF("Login Succesful");




                                // SECOND TCP CONNECTION

                                File docs = new File("D:\\SHOCKING\\Directories\\Docs");
                                File movies = new File("D:\\SHOCKING\\Directories\\Movies");
                                File musics = new File("D:\\SHOCKING\\Directories\\Music");

                                File cdocs = new File("D:\\SHOCKING\\Downloads\\Docs");
                                File cmovies = new File("D:\\SHOCKING\\Downloads\\Movies");
                                File cmusics = new File("D:\\SHOCKING\\Downloads\\Music");
                                boolean status1 = docs.mkdirs();
                                boolean status2 = movies.mkdirs();
                                boolean status3 = musics.mkdirs();
                                boolean status4 = cdocs.mkdirs();
                                boolean status5 = cmovies.mkdirs();
                                boolean status6 = cmusics.mkdirs();





                                File d1 = new File("D:\\SHOCKING\\Directories\\Docs\\Doc1.txt");
                                File d2 = new File("D:\\SHOCKING\\Directories\\Docs\\Doc2.txt");
                                File d3 = new File("D:\\SHOCKING\\Directories\\Docs\\Doc3.txt");

                                File dc1 = new File("D:\\SHOCKING\\Downloads\\Docs\\Doc1.txt");
                                File dc2 = new File("D:\\SHOCKING\\Downloads\\Docs\\Doc2.txt");
                                File dc3 = new File("D:\\SHOCKING\\Downloads\\Docs\\Doc3.txt");
                               /* d1.createNewFile();
                                d2.createNewFile();
                                d3.createNewFile();*/

                                /*dc1.createNewFile();
                                dc2.createNewFile();
                                dc3.createNewFile();*/


                                File m1 = new File("D:\\SHOCKING\\Directories\\Movies\\[EgyBest].Joker.2019.BluRay.1080p.x264.mp4");
                                File m2 = new File("D:\\SHOCKING\\Directories\\Movies\\[EgyBest].The.Dark.Knight.Rises.2012.BluRay.1080p.x264.mp4");
                                File m3 = new File("D:\\SHOCKING\\Directories\\Movies\\[EgyBest].The.Prestige.2006.BluRay.1080p.x264.mp4");

                                File mc1 = new File("D:\\SHOCKING\\Downloads\\Movies\\[EgyBest].Joker.2019.BluRay.1080p.x264.mp4");
                                File mc2 = new File("D:\\SHOCKING\\Downloads\\Movies\\[EgyBest].The.Dark.Knight.Rises.2012.BluRay.1080p.x264.mp4");
                                File mc3 = new File("D:\\SHOCKING\\Downloads\\Movies\\[EgyBest].The.Prestige.2006.BluRay.1080p.x264.mp4");

                               /* m1.createNewFile();
                                m2.createNewFile();
                                m3.createNewFile();*/
                                /*mc1.createNewFile();
                                mc2.createNewFile();
                                mc3.createNewFile();*/




                                File mu1 = new File("D:\\SHOCKING\\Directories\\Music\\7 Between Past and Present.mp3");
                                File mu2 = new File("D:\\SHOCKING\\Directories\\Music\\Death Sentence.mp3");
                                File mu3 = new File("D:\\SHOCKING\\Directories\\Music\\Paranormal Main Soundtrack.mp3");
                                File muc1 = new File("D:\\SHOCKING\\Downloads\\Music\\7 Between Past and Present.mp3");
                                File muc2 = new File("D:\\SHOCKING\\Downloads\\Music\\Death Sentence.mp3");
                                File muc3 = new File("D:\\SHOCKING\\Downloads\\Music\\Paranormal Main Soundtrack.mp3");
                               /* mu1.createNewFile();
                                mu2.createNewFile();
                                mu3.createNewFile();*/
                                /*muc1.createNewFile();
                                muc2.createNewFile();
                                muc3.createNewFile();*/


                                File dir = new File("D:\\SHOCKING\\Directories");
                                File dow = new File("D:\\SHOCKING\\Downloads");
                                //dir.createNewFile();
                                dow.createNewFile();

                                File[] files = dir.listFiles();

                                DataInputStream input = new DataInputStream(Client.getInputStream());
                                DataOutputStream output = new DataOutputStream(Client.getOutputStream());
                                //Desktop d = Desktop.getDesktop();

                                output.writeUTF("What do you want to show?");

                                while (true) {

                                    String s = input.readUTF();       //show my directories
                                    System.out.println("Client : " + s);   //client : show my directories

                                    if (s.equalsIgnoreCase("show my directories")) {


                                        // Creates an array in which we will store the names of files and directories
                                        String[] DirNames;
                                        DirNames = dir.list();

                                        // For each pathname in the pathnames array
                                        for (String pathname : DirNames) {
                                            // Print the names of files and directories
                                            output.writeUTF(pathname);
                                        }


                                        while (true) {
                                            String outer = input.readUTF();
                                            System.out.println("Client : " + outer);
                                            if (outer.equalsIgnoreCase("show docs")) {
                                               // File[] doc = docs.listFiles();

                                                ////////////////////////////
                                                output.writeUTF("Doc1");
                                                output.writeUTF("Doc2");
                                                output.writeUTF("Doc3");
                                                ////////////////////////////

                                                while (true) {
                                                    String inner = input.readUTF();
                                                    System.out.println("Client : " + inner);

                                                    if (inner.equalsIgnoreCase("doc1")) {

                                                        /*output.writeUTF("Opening doc1...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(d1);
                                                        break;*/

                                                        output.writeUTF("Doc1 now in the client's folder ! ");
                                                        Files.copy(d1.toPath(), dc1.toPath());
                                                        break;


                                                    } else if (inner.equalsIgnoreCase("doc2")) {

                                                        /*output.writeUTF("Opening doc2...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(d2);
                                                        break;*/

                                                        output.writeUTF("Doc2 now in the client's folder ! ");
                                                        Files.copy(d2.toPath(), dc2.toPath());
                                                        break;

                                                    } else if (inner.equalsIgnoreCase("doc3")) {

                                                        /*output.writeUTF("Opening doc3...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(d3);
                                                        break;*/

                                                        output.writeUTF("Doc3 now in the client's folder ! ");
                                                        Files.copy(d3.toPath(), dc3.toPath());
                                                        break;

                                                    } else {
                                                        output.writeUTF("Sorry, Enter the right Doc.");
                                                    }
                                                }
                                                //break;
                                            } else if (outer.equalsIgnoreCase("show movies")) {
                                                //File[] movie = movies.listFiles();

                                                ////////////////////////////
                                                output.writeUTF("Joker");
                                                output.writeUTF("The Darkknight");
                                                output.writeUTF("The Prestige");
                                                ////////////////////////////

                                                while (true) {

                                                    String inner = input.readUTF();

                                                    if (inner.equalsIgnoreCase("joker")) {

                                                        /*output.writeUTF("Opening Joker...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(m1);
                                                        break;*/

                                                        output.writeUTF("The Joker now in the client's folder ! ");
                                                        Files.copy(m1.toPath(), mc1.toPath());


                                                    } else if (inner.equalsIgnoreCase("darkknight")) {

                                                       /* output.writeUTF("Opening Darkknight...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(m2);
                                                        break;*/

                                                        output.writeUTF("The DarkKnight now in the client's folder ! ");
                                                        Files.copy(m2.toPath(), mc2.toPath());
                                                        break;


                                                    } else if (inner.equalsIgnoreCase("the prestige")) {

                                                       /* output.writeUTF("Opening The Prestige...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(m3);
                                                        break;*/

                                                        output.writeUTF("The Prestige now in the client's folder ! ");
                                                        Files.copy(m3.toPath(), mc3.toPath());
                                                        break;


                                                    } else {
                                                        output.writeUTF("Sorry, Enter the right Movie.");
                                                    }
                                                }
                                                //break;
                                            } else if (outer.equalsIgnoreCase("show music")) {
                                                //File[] music = musics.listFiles();

                                                ////////////////////////////
                                                output.writeUTF("Music1");
                                                output.writeUTF("Music2");
                                                output.writeUTF("Music3");
                                                ////////////////////////////
                                                while (true) {
                                                    String inner = input.readUTF();

                                                    if (inner.equalsIgnoreCase("music1")) {

                                                       /* output.writeUTF("Opening Music1...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(mu1);
                                                        break;*/

                                                        output.writeUTF("Music1 now in the client's folder ! ");
                                                        Files.copy(mu1.toPath(), muc1.toPath());
                                                        break;


                                                    } else if (inner.equalsIgnoreCase("music2")) {

                                                       /* output.writeUTF("Opening Music2...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(mu2);
                                                        break;*/

                                                        output.writeUTF("Music2 now in the client's folder ! ");
                                                        Files.copy(mu2.toPath(), muc2.toPath());
                                                        break;


                                                    } else if (inner.equalsIgnoreCase("music3")) {

                                                       /* output.writeUTF("Opening Music3...");
                                                        System.out.println("Client : " + inner);
                                                        d.open(mu3);
                                                        break;*/

                                                        output.writeUTF("Music3 now in the client's folder ! ");
                                                        Files.copy(mu3.toPath(), muc3.toPath());
                                                        break;


                                                    } else {
                                                        output.writeUTF("Sorry, Enter the right Music.");
                                                    }
                                                }
                                                break;
                                            } else {
                                                output.writeUTF("Sorry, Enter the right directory.");
                                            }
                                        }
                                        break;
                                    } else {
                                        output.writeUTF("Sorry this words is not correct, try again");
                                    }
                                }

                            } else {
                                s1 = "Worng password";
                                Serverwrite.writeUTF(s1);
                                System.out.println("Login Failed and the Connection will Terminate");

                            }
                        } else {
                            s1 = "wrong username";
                        }
                    }
                    Serverwrite.writeUTF(s1);
                    Serverwrite.writeUTF(s2);


                    try {
                        String close = ServerRead.readUTF();
                        System.out.println("Client : " + close);

                        if (close.equalsIgnoreCase("close")) {
                            System.out.println("Closing..");

                        }

                    } catch (Exception e) {
                        System.out.println("test ");
                    }



                } catch (Exception e) {
                    // System.out.println("error");
                }









            } catch (Exception e) {
                System.out.println("problem in connection with it's client");
            }
        }
    }
}