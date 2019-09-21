package com.example.recyclersearchfilter;

public class SearchModel {
    private int userImage;
    private String userName;
    private String userChat;

    public SearchModel(int userImage, String userName, String userChat) {
        this.userImage = userImage;
        this.userName = userName;
        this.userChat = userChat;
    }

    public int getUserImage() {
        return userImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserChat() {
        return userChat;
    }

}
