/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Dropbox\\Dropbox\\find a golfer\\source backup\\NeedAGolferAndroid\\FindAGolfer\\src\\com\\findagolfer\\mobile\\interfaces\\IMessageServiceCallbackListener.aidl
 */
package com.findagolfer.mobile.interfaces;
// Declare the interface.

public interface IMessageServiceCallbackListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener
{
private static final java.lang.String DESCRIPTOR = "com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener interface,
 * generating a proxy if needed.
 */
public static com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener))) {
return ((com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener)iin);
}
return new com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getNewMessageList:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.findagolfer.mobile.entities.PrivateMessage> _arg0;
_arg0 = new java.util.ArrayList<com.findagolfer.mobile.entities.PrivateMessage>();
this.getNewMessageList(_arg0);
reply.writeNoException();
reply.writeTypedList(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
// Methods can take 0 or more parameters, and
// return a value or void.

public void getNewMessageList(java.util.List<com.findagolfer.mobile.entities.PrivateMessage> data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNewMessageList, _data, _reply, 0);
_reply.readException();
_reply.readTypedList(data, com.findagolfer.mobile.entities.PrivateMessage.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getNewMessageList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
// Methods can take 0 or more parameters, and
// return a value or void.

public void getNewMessageList(java.util.List<com.findagolfer.mobile.entities.PrivateMessage> data) throws android.os.RemoteException;
}
