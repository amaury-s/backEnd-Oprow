package com.oprow.bo;

public class User{

    protected int mId;
    protected String mEmail;
    protected String mFirstName;
    protected String mLastName;
    protected String mPassword;

    public int getmId() {
        return mId;
    }

    public void setmId(int Id) {
        this.mId = Id;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public User(User pUser) {
            this.mId = pUser.getmId();
            this.mEmail = pUser.getmEmail();
            this.mLastName = pUser.getmLastName();
            this.mFirstName = pUser.getmFirstName();
            this.mPassword = pUser.getmPassword();
    }

    public User() {
    }

    @Override
    public String toString(){
        return "Last name: " + this.mLastName + ", First name: " + this.mFirstName;
    }

}
