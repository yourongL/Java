package java_base;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.InvalidPathException;

public class GreetingClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            System.out.println("试图连接到服务器" + serverName + "  端口号" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("服务器IP是" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from 客户端" + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("来自服务器的响应 " + in.readUTF());
            client.close();
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }
    }
}
