package com.findagolfer.mobile.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class PrivateMessage implements Parcelable {

	private int messageId;
	private String sendingGolferScreenName;
	private int sendingGolferId;
	private String receivingGolferScreenName;
	private int receivingGolferId;
	private int rootMessageId;
	private String message;
	private long createDateTime;
	
	public static final Parcelable.Creator<PrivateMessage> CREATOR = new Parcelable.Creator<PrivateMessage>() {
		public PrivateMessage createFromParcel(Parcel in) {
		    return new PrivateMessage(in);
		}
	
		public PrivateMessage[] newArray(int size) {
		    return new PrivateMessage[size];
		}
	};

	public PrivateMessage(){
		
	}
	public PrivateMessage(Parcel in) {
		readFromParcel(in);
	}
	private void readFromParcel(Parcel in) {
		messageId = in.readInt();
		sendingGolferScreenName = in.readString();
		sendingGolferId = in.readInt();
		receivingGolferScreenName = in.readString();
		receivingGolferId = in.readInt();
		rootMessageId = in.readInt();
		message = in.readString();
		createDateTime = in.readLong();
	}
	
	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(messageId);
		out.writeString(sendingGolferScreenName);
		out.writeInt(sendingGolferId);
		out.writeString(receivingGolferScreenName);
		out.writeInt(receivingGolferId);
		out.writeInt(rootMessageId);
		out.writeString(message);
		out.writeLong(createDateTime);
	}
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getSendingGolferScreenName() {
		return sendingGolferScreenName;
	}
	public void setSendingGolferScreenName(String sendingGolferScreenName) {
		this.sendingGolferScreenName = sendingGolferScreenName;
	}
	public int getSendingGolferId() {
		return sendingGolferId;
	}
	public void setSendingGolferId(int sendingGolferId) {
		this.sendingGolferId = sendingGolferId;
	}
	public String getReceivingGolferScreenName() {
		return receivingGolferScreenName;
	}
	public void setReceivingGolferScreenName(String receivingGolferScreenName) {
		this.receivingGolferScreenName = receivingGolferScreenName;
	}
	public int getReceivingGolferId() {
		return receivingGolferId;
	}
	public void setReceivingGolferId(int receivingGolferId) {
		this.receivingGolferId = receivingGolferId;
	}
	public int getRootMessageId() {
		return rootMessageId;
	}
	public void setRootMessageId(int rootMessageId) {
		this.rootMessageId = rootMessageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(long createDateTime) {
		this.createDateTime = createDateTime;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	@Override
	public boolean equals(Object o){
		
		return (this.getMessageId() == ((PrivateMessage)o).getMessageId());
		
	}
	
}
