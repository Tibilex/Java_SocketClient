import Models.User;
import Models.UserData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import org.json.JSONObject;
public class Main {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {

        Scanner _console = new Scanner(System.in);
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        while ( true ) {
            int menuChoice = 0;
            System.out.print("""
                     \u001B[32mMenu
                    |===================|
                    |\u001B[34m 1\u001B[32m = \u001B[37mSign In\u001B[32m\t\t|
                    |\u001B[34m 2\u001B[32m = \u001B[37mSign Up\u001B[32m\t\t|        
                    |\u001B[31m 0\u001B[32m = \u001B[37mExit\u001B[32m\t\t\t|
                    |===================|
                    """);
            menuChoice = _console.nextInt();
            socket = new Socket(host.getHostName(), 9876);
            switch ( menuChoice ) {
                case 1:
                    _console = new Scanner(System.in);
                    System.out.println("\u001B[32m| \u001B[31mSign In:\u001B[32m\n| \u001B[34mEnter login: ");
                    String login = _console.nextLine();
                    System.out.println("\u001B[32m| \u001B[34mEnter password");
                    String password = _console.nextLine();
                    System.out.println("\u001B[32m| \u001B[34mYou entered: login = \u001B[31m" + login + " \u001B[34mpassword = \u001B[31m" + password);

                    UserData data = new UserData(new User(login, password), false);
                    JSONObject json = new JSONObject(data);
                    String jsonString = json.toString();

                    oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(jsonString);
                    ois = new ObjectInputStream(socket.getInputStream());
                    String message = (String) ois.readObject();
                    System.out.println("\u001B[32m| \u001B[34mServer Message: \u001B[31m" + message);
                    oos.close();
                    ois.close();
                    break;
                case 2:
                    _console = new Scanner(System.in);
                    System.out.println("\u001B[32m| \u001B[31mSign In:\u001B[32m\n| \u001B[34mEnter login: ");
                    String regLogin = _console.nextLine();
                    System.out.println("\u001B[32m| \u001B[34mEnter password");
                    String regPassword = _console.nextLine();
                    System.out.println("\u001B[32m| \u001B[34mYou entered: login = \u001B[31m" + regLogin + " \u001B[34mpassword = \u001B[31m" + regPassword);
                    User user = new User(regLogin,regPassword);
                    UserData userData = new UserData(user,true);
                    JSONObject jsonObj = new JSONObject(userData);
                    String jsonObjString = jsonObj.toString();
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(jsonObjString);
                    ois = new ObjectInputStream(socket.getInputStream());
                    String message2 = (String) ois.readObject();
                    System.out.println("\u001B[32m| \u001B[34mServer Message: \u001B[31m" + message2);
                    ois.close();
                    oos.close();
                    break;
                case 0:
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject("\u001B[32m| \u001B[34mExit");
                    oos.close();
                    return;
                default:
            }
        }
    }
}