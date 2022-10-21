package com.example.apptonghop;

public class Friend {


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    int img;
    String name;
    String introduce;
    int follower;
    int following;
    int id;


    public Friend(int id, int img, String name, int follower, int following, String introduce) {
        this.img = img;
        this.name = name;
        this.follower = follower;
        this.id = id;
        this.following = following;
        this.introduce = introduce;
    }


}
