package forum;


/**
* forum/Reject.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from E:/Documents/Florian/fac/M2/appRep/Tp1/forum.idl
* jeudi 13 novembre 2014 12 h 49 CET
*/

public final class Reject extends org.omg.CORBA.UserException
{
  public String message = null;

  public Reject ()
  {
    super(RejectHelper.id());
  } // ctor

  public Reject (String _message)
  {
    super(RejectHelper.id());
    message = _message;
  } // ctor


  public Reject (String $reason, String _message)
  {
    super(RejectHelper.id() + "  " + $reason);
    message = _message;
  } // ctor

} // class Reject
