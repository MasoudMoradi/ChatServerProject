package chatServer;

/*
 * The chat client thread. This client thread opens the input and the output
 * streams for a particular client, ask the client's name, informs all the
 * clients connected to the server about the fact that a new client has joined
 * the chat room, and as long as it receive data, echos that data back to all
 * other clients. The thread broadcast the incoming messages to all clients and
 * routes the private message to the particular client. When a client leaves the
 * chat room this thread informs also all the clients about that and terminates.
 */

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientThread extends Thread {

	public String clientName = null;
	private DataInputStream is = null;
	private PrintStream os = null;
	private Socket clientSocket = null;
	private final ClientThread[] threads;
	private int maxClientsCount;
	private boolean isChatting = true;
	private String chattingWithMe = null;

	Map<String, String> map = new HashMap<String, String>();

	public Map getClient(String ip, String username) {
		map.put(ip, username);
		return map;
	}

	// you must initial it in a method or statically . initialization is like
	// this : map("Hello", 7432);
	// you can access the value by writing the key as put() method argument.
	// like this: map.get("Hello") which returns 7432 for you .
	// if you enter two repetitive keys, the first one will be replaced by the
	// second one and actually you'll lose the first one.

	public ClientThread(Socket clientSocket, ClientThread[] threads) {
		this.clientSocket = clientSocket;
		this.threads = threads;
		maxClientsCount = threads.length;
	}

	@SuppressWarnings("deprecation")
	public void run() {
		int maxClientsCount = this.maxClientsCount;
		ClientThread[] threads = this.threads;

		try {
			/*
			 * Create input and output streams for this client.
			 */
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			String[] logInMessageSplited = new String[3];
			String logInMessage;
			String clienNameChatting;
			while (true) {

				logInMessage = is.readLine();
				if (!is.equals(null)) {
					logInMessageSplited = logInMessage.split(" ");
					if (logInMessageSplited[0].equals("LOGIN")) {
						os.println("OK");
						System.out.println(logInMessageSplited[1]
								+ " connected!!");
					}

					/* Welcome the new the client. */
					// os.println("Welcome " + logInMessage
					// +
					// " to our chat room.\nTo leave enter /quit in a new line.");
					// System.out.println("Welcome " + logInMessage
					// +
					// " to our chat room.\nTo leave enter /quit in a new line.");
					synchronized (this) {
						for (int i = 0; i < maxClientsCount; i++) {
							if (threads[i] != null && threads[i] == this) {

								clientName = logInMessageSplited[1];
								break;
							}
						}
					}

					// for (int i = 0; i < maxClientsCount; i++) {
					// if (threads[i] != null && threads[i] != this) {
					// threads[i].os.println("*** A new user " + logInMessage
					// + " entered the chat room !!! ***");
					// System.out.println("*** A new user " + logInMessage
					// + " entered the chat room !!! ***");
					// }
					// }
				}
				/* Start the conversation. */
				while (true) {

					String line = is.readLine();
					if (line.equals("CLOSE")) {
						os.println("OK");
						break;

					}
					if (line.equals("LIST")) {
						int listNumber = 0;
						String listItems = "";
						for (int i = 0; i < maxClientsCount; i++) {
							if (threads[i] != null
									&& threads[i].clientName != null) {
								listNumber++;
								listItems = listItems + " "
										+ threads[i].clientName;
							}
						}
						os.println(listNumber + listItems);
						System.out.println("list got by: " + clientName + " :"
								+ listNumber + listItems);

					}
					/* If the message is private sent it to the given client. */
					if (line.startsWith("CONNECT") && isChatting) {
						String[] words = line.split(" ");
						if (words.length > 1 && words[1] != null) {
							words[1] = words[1].trim();
							if (!words[1].isEmpty()) {
								synchronized (this) {
									for (int i = 0; i < maxClientsCount; i++) {
										if (threads[i] != null
												&& threads[i] != this
												&& threads[i].clientName != null
												&& threads[i].clientName
														.equals(words[1])) {
											this.isChatting = false;
											threads[i].isChatting = false;
											this.chattingWithMe = threads[i].clientName;
											threads[i].chattingWithMe = this.clientName;
											System.out.println(this.clientName
													+ " vs "
													+ threads[i].clientName
													+ " join!!!!");
											/*
											 * Echo this message to let the
											 * client know the private message
											 * was sent.
											 */
											this.os.println("OK");
											break;
										}
									}

								}
							}
						}
					} else {
						if (!isChatting) {
							/*
							 * The message is public, broadcast it to all other
							 * clients.
							 */
							if (!line.equals(null)) {
								synchronized (this) {
									for (int i = 0; i < maxClientsCount; i++) {
										if (threads[i] != null
												&& threads[i].clientName != null
												&& (threads[i].chattingWithMe
														.equals(this.clientName))) {
											threads[i].os.println(line);
											System.out.println(this.clientName
													+ " said to "
													+ threads[i].clientName
													+ ": " + line);

										}
									}
								}
								// ////////////////////////////////////////////////////////
							}
						}
					}
					// synchronized (this) {
					// for (int i = 0; i < maxClientsCount; i++) {
					// if (threads[i] != null && threads[i] != this
					// && threads[i].clientName != null) {
					// threads[i].os.println("*** The user " + logInMessage
					// + " is leaving the chat room !!! ***");
					// }
					// }
					// }

					/*
					 * Clean up. Set the current thread variable to null so that
					 * a new client could be accepted by the server.
					 */
					if (line.equals("CLOSE")) {
						synchronized (this) {
							for (int i = 0; i < maxClientsCount; i++) {
								if (threads[i] == this) {
									threads[i] = null;
								}
								break;
							}
							break;
						}
					}
				}
				/*
				 * Close the output stream, close the input stream, close the
				 * socket.
				 */
				is.close();
				os.close();
				clientSocket.close();
			}

		}

		catch (IOException e) {
		}
	}
}
