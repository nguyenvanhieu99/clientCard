package Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.User;
import model.serverSendObject;
import model.userRegister;
import model.userSendObject;

public class ClientControl {
     private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Socket mySocket;
    private String serverHost = "localhost";
    private int serverPort = 8080;
    

    public ClientControl() throws IOException {
        this.mySocket = new Socket(serverHost, serverPort);
        oos= new ObjectOutputStream(mySocket.getOutputStream());
        ois= new ObjectInputStream(mySocket.getInputStream());
        //openConnection();
        
    }

    public Socket openConnection() {
        try {
             mySocket = new Socket(serverHost, serverPort);
             ois= new ObjectInputStream(mySocket.getInputStream());
             oos= new ObjectOutputStream(mySocket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return mySocket;
    }

    public boolean sendData(userSendObject uso) {
        try {
            System.out.println("sap gui"+uso.getObject());
            //userSendObject name1 = (userSendObject) uso;
            oos.writeObject(uso);
            oos.flush();
            
            //oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public serverSendObject receiveData() {
        String result = null;
        try {
            
            
            serverSendObject o;
            o = (serverSendObject) ois.readObject();
            //ois.close();
                return o;
                
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
    }

    public boolean closeConnection() {
        try {
            mySocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    
}

}

