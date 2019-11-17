package lando;


import java.net.*;
import java.io.*;
 
/**
 * This program demonstrates a socket client program that talks to a SMTP server.
 *
 * @author www.codejava.net
 */
public class SmtpClient {
 
    public static void main(String[] args) {
 
        String hostname = "192.168.0.112";
        int port = 25;
//        String username = "demo@entermediasoftware.com";
//        String password = "19be6813-24d3-4004-96b7-ceed888efe45XX";
 
        try (Socket socket = new Socket(hostname, port)) {
 
            InputStream input = socket.getInputStream();
 
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            String line = reader.readLine();
            System.out.println(line);
 
            writer.println("HELO " + hostname + "\r");
            //writer.println("EHLO entermediasoftware.com\r");
            line = reader.readLine();
            System.out.println(line);
 
//            do
//            {
//            	line = reader.readLine();
//            	System.out.println(line);
//            } while (!line.endsWith("STARTTLS"));

            //writer.println("AUTH PLAIN " + password);
            writer.println("MAIL FROM:<test@gmail.com>\r");
        	line = reader.readLine();            
            writer.println("RCPT TO:<slacklando@gmail.com>\r");
        	line = reader.readLine();
            writer.println("DATA\r");
        	line = reader.readLine();
            writer.println("Date: Tue, 30 Jul 2019 17:19:31 +0200 (EET)");
            writer.println("From: cburkey@openedit.org");
            writer.println("To: slacklando@gmail.com");
            writer.println("Message-ID: <20132171.0.1548256771226@DESKTOP-NLP1GG8>");
            writer.println("Subject: My HTML message");
            writer.println("MIME-Version: 1.0");
            
            writer.println("Content-Type: text/plain; charset=us-ascii");
            writer.println("\r");
            writer.println("Hello World!");
            writer.print("\r\n.\r\n");
            //writer.print("\r");
            
        	line = reader.readLine();
        	System.out.println(line);
            
            writer.println("quit");
            line = reader.readLine();
            System.out.println(line);
 
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
