package forum;


/**
* forum/ForumAdminHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from E:/Documents/Florian/fac/M2/appRep/Tp1/forum.idl
* jeudi 13 novembre 2014 12 h 49 CET
*/

abstract public class ForumAdminHelper
{
  private static String  _id = "IDL:forum/ForumAdmin:1.0";

  public static void insert (org.omg.CORBA.Any a, forum.ForumAdmin that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static forum.ForumAdmin extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (forum.ForumAdminHelper.id (), "ForumAdmin");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static forum.ForumAdmin read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ForumAdminStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, forum.ForumAdmin value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static forum.ForumAdmin narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof forum.ForumAdmin)
      return (forum.ForumAdmin)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      forum._ForumAdminStub stub = new forum._ForumAdminStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static forum.ForumAdmin unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof forum.ForumAdmin)
      return (forum.ForumAdmin)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      forum._ForumAdminStub stub = new forum._ForumAdminStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
