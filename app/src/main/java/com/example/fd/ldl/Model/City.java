package com.example.fd.ldl.Model;

import com.google.gson.annotations.SerializedName;

public class City {

        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("state")
        private String state;

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
}
