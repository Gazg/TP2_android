package forum;

/**
* forum/ForumHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from E:/Documents/Florian/fac/M2/appRep/Tp1/forum.idl
* jeudi 13 novembre 2014 12 h 04 CET
*/

public final class ForumHolder implements org.omg.CORBA.portable.Streamable
{
  public forum.Forum value = null;

  public ForumHolder ()
  {
  }

  public ForumHolder (forum.Forum initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = forum.ForumHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    forum.ForumHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return forum.ForumHelper.type ();
  }

}
