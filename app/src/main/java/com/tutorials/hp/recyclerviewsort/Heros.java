package com.tutorials.hp.recyclerviewsort;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

/**
 * Created by DELL on 1/7/2019.
 */

public class Heros implements Comparable<Heros>{

    public Heros(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }


        @SerializedName("name")
        private String name;
        @SerializedName("realname")
        private String realname;
        @SerializedName("team")
        private String team;
        @SerializedName("firstappearance")
        private String firstappearance;
        @SerializedName("createdby")
        private String createdby;
        @SerializedName("publisher")
        private String publisher;
        @SerializedName("imageurl")
        private String imageurl;
        @SerializedName("bio")
        private String bio;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getFirstappearance() {
            return firstappearance;
        }

        public void setFirstappearance(String firstappearance) {
            this.firstappearance = firstappearance;
        }

        public String getCreatedby() {
            return createdby;
        }

        public void setCreatedby(String createdby) {
            this.createdby = createdby;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }




    @Override
    public int compareTo(Heros o) {
        return this.name.compareTo(o.getName());
    }
}
