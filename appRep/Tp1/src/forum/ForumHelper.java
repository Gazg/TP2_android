package forum;


/**
* forum/ForumHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from E:/Documents/Florian/fac/M2/appRep/Tp1/forum.idl
* jeudi 13 novembre 2014 12 h 49 CET
*/

abstract public class ForumHelper
{
  private static String  _id = "IDL:forum/Forum:1.0";

  public static void insert (org.omg.CORBA.Any a, forum.Forum that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static forum.Forum extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (forum.ForumHelper.id (), "Forum");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static forum.Forum read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ForumStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, forum.Forum value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static forum.Forum narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof forum.Forum)
      return (forum.Forum)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      forum._ForumStub stub = new forum._ForumStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static forum.Forum unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof forum.Forum)
      return (forum.Forum)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      forum._ForumStub stub = new forum._ForumStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
