package forum;


/**
* forum/ForumAdminPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from E:/Documents/Florian/fac/M2/appRep/Tp1/forum.idl
* jeudi 13 novembre 2014 12 h 49 CET
*/

public abstract class ForumAdminPOA extends org.omg.PortableServer.Servant
 implements forum.ForumAdminOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_theme", new java.lang.Integer (0));
    _methods.put ("_set_theme", new java.lang.Integer (1));
    _methods.put ("_get_moderator", new java.lang.Integer (2));
    _methods.put ("_set_moderator", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // forum/ForumAdmin/_get_theme
       {
         String $result = null;
         $result = this.theme ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // forum/ForumAdmin/_set_theme
       {
         String newTheme = in.read_string ();
         this.theme (newTheme);
         out = $rh.createReply();
         break;
       }

       case 2:  // forum/ForumAdmin/_get_moderator
       {
         String $result = null;
         $result = this.moderator ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // forum/ForumAdmin/_set_moderator
       {
         String newModerator = in.read_string ();
         this.moderator (newModerator);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:forum/ForumAdmin:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ForumAdmin _this() 
  {
    return ForumAdminHelper.narrow(
    super._this_object());
  }

  public ForumAdmin _this(org.omg.CORBA.ORB orb) 
  {
    return ForumAdminHelper.narrow(
    super._this_object(orb));
  }


} // class ForumAdminPOA
