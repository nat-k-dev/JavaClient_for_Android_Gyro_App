import java.net.*;
import java.io.*;

public class ClientMain {

	private static Logger logger;
	private static Socket s;
	private static String serverIpAddress = "192.168.0.101"; 
	//private static String serverIpAddress = "176.14.245.232";

	public static void main(String[] args) {
		logger = Logger.GetLogger();
		
		int serverPort[] = { 12346, 12347 };	
		try{
			if( !attemptToOpen( serverPort[0] ) ) {
				if( !attemptToOpen( serverPort[1] ) ) {
					throw new Exception("Cannot open connection");					
				}
			}
			InputStream is = s.getInputStream();
			byte buf[] = new byte[64*1024];
			int r;
			s.
			while((r = is.read(buf)) > 0){
/*				if(s.isClosed()){
					logger.WriteLine("socket is closed");
					break;
				}*/

				String data = new String(buf, 0, r);
				logger.WriteLine( data );	
				logger.WriteLine("");
				
				Thread.sleep(2000);
			}
		} catch(Exception e) {
			logger.WriteLine( e.getMessage() );
		}
	}
	
	private static boolean attemptToOpen( int port ) {
		try{
			s = new Socket(serverIpAddress, port);
		}catch(Exception e) {
			logger.WriteLine( e.getMessage() );
			return false;
		}	
		return true;
	}

}
