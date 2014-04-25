/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Dropbox\\Dropbox\\find a golfer\\source backup\\NeedAGolferAndroid\\FindAGolfer\\src\\com\\findagolfer\\mobile\\interfaces\\IMessageService.aidl
 */
package com.findagolfer.mobile.interfaces;
// Declare the interface.

public interface IMessageService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.findagolfer.mobile.interfaces.IMessageService
{
private static final java.lang.String DESCRIPTOR = "com.findagolfer.mobile.interfaces.IMessageService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.findagolfer.mobile.interfaces.IMessageService interface,
 * generating a proxy if needed.
 */
public static com.findagolfer.mobile.interfaces.IMessageService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.findagolfer.mobile.interfaces.IMessageService))) {
return ((com.findagolfer.mobile.interfaces.IMessageService)iin);
}
return new com.findagolfer.mobile.interfaces.IMessageService.Stub.Proxy(obj);
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
case TRANSACTION_setCurrentNotifications:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.findagolfer.mobile.entities.PrivateMessage> _arg0;
_arg0 = data.createTypedArrayList(com.findagolfer.mobile.entities.PrivateMessage.CREATOR);
this.setCurrentNotifications(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_setGolferId:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.setGolferId(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getNewNotifications:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.findagolfer.mobile.entities.PrivateMessage> _result = this.getNewNotifications();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener _arg0;
_arg0 = com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener.Stub.asInterface(data.readStrongBinder());
this.registerCallback(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.findagolfer.mobile.interfaces.IMessageService
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

public void setCurrentNotifications(java.util.List<com.findagolfer.mobile.entities.PrivateMessage> notifications) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeTypedList(notifications);
mRemote.transact(Stub.TRANSACTION_setCurrentNotifications, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public void setGolferId(int golferId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(golferId);
mRemote.transact(Stub.TRANSACTION_setGolferId, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
public java.util.List<com.findagolfer.mobile.entities.PrivateMessage> getNewNotifications() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.findagolfer.mobile.entities.PrivateMessage> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNewNotifications, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.findagolfer.mobile.entities.PrivateMessage.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public void registerCallback(com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_setCurrentNotifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_setGolferId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getNewNotifications = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
// Methods can take 0 or more parameters, and
// return a value or void.

public void setCurrentNotifications(java.util.List<com.findagolfer.mobile.entities.PrivateMessage> notifications) throws android.os.RemoteException;
public void setGolferId(int golferId) throws android.os.RemoteException;
public java.util.List<com.findagolfer.mobile.entities.PrivateMessage> getNewNotifications() throws android.os.RemoteException;
public void registerCallback(com.findagolfer.mobile.interfaces.IMessageServiceCallbackListener listener) throws android.os.RemoteException;
}
