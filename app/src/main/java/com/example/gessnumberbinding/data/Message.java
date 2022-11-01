package com.example.gessnumberbinding.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Message implements Serializable, Parcelable {
    private String player;
    private String attempts;
    private Integer number;
    private String winLose;


    public Message(){

    }

    public Message(String player, String attepmts) {
        this.player = player;
        this.attempts = attepmts;
    }

    protected Message(Parcel in) {
        player = in.readString();
        attempts = in.readString();
        if (in.readByte() == 0) {
            number = null;
        } else {
            number = in.readInt();
        }
        winLose = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public String getWinLose() {
        return winLose;
    }

    public void setWinLose(String winLose) {
        this.winLose = winLose;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getAttempts() {
        return attempts;
    }

    public void setAttempts(String attempts) {
        this.attempts = attempts;
    }


    @Override
    public String toString() {
        return "Message{" +
                "player='" + player + '\'' +
                ", attempts='" + attempts + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(player);
        parcel.writeString(attempts);
        if (number == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(number);
        }
        parcel.writeString(winLose);
    }
}
