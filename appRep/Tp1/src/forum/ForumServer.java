package forum;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ObjectNotActive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class ForumServer {
	public static void main(String[] args) throws InvalidName, ServantAlreadyActive, WrongPolicy, FileNotFoundException, ObjectNotActive, AdapterInactive {
		ORB orb = ORB.init(args,null);
		POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		
		ForumImpl forum = new ForumImpl("ILoveCorba", "Florian");
		ForumPOATie servantDelegate = new ForumPOATie(forum);
		byte []  servantID= rootPOA.activate_object(servantDelegate);
		
		String reference = orb.object_to_string(rootPOA.id_to_reference(servantID));
		PrintWriter file = new PrintWriter("ObjectRef");
		file.println(reference);
		file.close();
		rootPOA.the_POAManager().activate();
		orb.run();
	}
}
