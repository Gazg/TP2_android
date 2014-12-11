package forum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.IntHolder;
import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;

public class ForumClient {
	public static void main(String[] args) throws IOException {
		 
		
		ORB orb = ORB.init(args,null);
		BufferedReader fileReader = new BufferedReader(new FileReader("ObjectRef"));
		String stringIOR = fileReader.readLine();
		System.out.println(stringIOR);
		fileReader.close();
		
		org.omg.CORBA.Object reference = orb.string_to_object(stringIOR);
		Forum forumProxy = ForumHelper.narrow(reference);
		Message m = new Message("NOEL","moi","24/12/14","papa noel");
		try {
			forumProxy.postMessage(m);
		} catch (Reject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Message tmp = forumProxy.getMessage("NOEL");
		System.out.println("Titre : " + tmp.title);
		System.out.println("Auteur : " + tmp.author);
		System.out.println("Message : " + tmp.body);
		
		
		Message[] ms = forumProxy.messageList();
		for (Message message : ms) {
			System.out.println("Titre : " + message.title);
			System.out.println("Auteur : " + message.author);
			System.out.println("Message : " + message.body);
		}
		
		
		try {
			forumProxy.removeMessage("test");
		} catch (Reject e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		StringHolder theme = new StringHolder ();
		StringHolder moderator = new StringHolder ();
		IntHolder size = new IntHolder ();
		forumProxy. getInfo ( theme , moderator , size );
		System . out . println ( " Theme : " + theme.value );
		System . out . println ( " Mod : " + moderator.value );
		System . out . println ( " Size: " + size.value );

		
		System.out.println(forumProxy.moderator());
		forumProxy.moderator("Super Florian");
	}

	

}
