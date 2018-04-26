package step002.web.testConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	public static void main(String[] args) throws IOException {
	 
		// server socket 생
		int port = 1988;
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("port number : " + port);

		while (true) {
			Socket clientSocket = serverSocket.accept();
			System.out.println("요청 들어옴");

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

			String line;
			int seq = 0;
			while ((line = in.readLine()) != null) {
				System.out.print(seq++ + " : ");
				System.out.println(line);
				if (line.isEmpty()) {
					break;
				}
			}

			// header
			out.write("HTTP/1.0 200 OK\r\n");
			out.write("Date: Saturday night \r\n");
			out.write("Server:  my server \r\n");
			out.write("Content-Type: text/html\r\n");
			out.write("TEST header: kohyusik\r\n");
			out.write("Content-Length: zz\r\n");
			out.write("Expires: Sat, 14 March 1988 00:59:59 GMT\r\n");
			out.write("Last-modified: Fri, 09 Aug 1996 03:14:44 GMT\r\n");

			// body
			out.write("\r\n");
			out.write("<title>제목 Title</title>");
			out.write("<p>body? 본문 </p>");
			out.write("\r\n");

			System.out.println("통신 끝");
			out.close();
			in.close();
			clientSocket.close();
		}
	}

}
