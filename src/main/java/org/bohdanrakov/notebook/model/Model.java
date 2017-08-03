package org.bohdanrakov.notebook.model;

import java.util.List;

public class Model {

    private String login;
    private String firstName;
    private String lastName;

    private String middleName;

    private String nickName;

    private String comment;
    private List<Group> groups;

    private String homePhone;

    private String mobilePhone;
    private String mobilePhone2;
    private String eMail;

    private String skype;
    private String index;

    private String city;
    private String street;
    private String home;
    private String apartment;

    private String dateAdded;
    private String dateLastChange;

    private Model(Builder builder) {
        login = builder.login;

        firstName = builder.firstName;
        lastName = builder.lastName;
        middleName = builder.middleName;

        nickName = builder.nickName;

        comment = builder.comment;
        groups = builder.groups;

        homePhone = builder.homePhone;

        mobilePhone = builder.mobilePhone;
        mobilePhone2 = builder.mobilePhone2;
        eMail = builder.eMail;

        skype = builder.skype;
        index = builder.index;

        city = builder.city;
        street = builder.street;
        home = builder.home;
        apartment = builder.apartment;

        dateAdded = builder.dateAdded;
        dateLastChange = builder.dateLastChange;
    }

    public static class Builder {

        private String login;
        private String firstName;
        private String lastName;

        private String middleName;

        private String nickName;

        private String comment;
        private List<Group> groups;

        private String homePhone;

        private String mobilePhone;
        private String mobilePhone2;
        private String eMail;

        private String skype;
        private String index;

        private String city;
        private String street;
        private String home;
        private String apartment;
        private String address;

        private String dateAdded;
        private String dateLastChange;

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder nickName(String nickName) {
            this.nickName = nickName;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder groups(List<Group> groups) {
            this.groups = groups;
            return this;
        }

        public Builder homePhone(String homePhone) {
            this.homePhone = homePhone;
            return this;
        }

        public Builder mobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public Builder mobilePhone2(String mobilePhone2) {
            this.mobilePhone2 = mobilePhone2;
            return this;
        }

        public Builder eMail(String eMail) {
            this.eMail = eMail;
            return this;
        }

        public Builder skype(String skype) {
            this.skype = skype;
            return this;
        }

        public Builder index(String index) {
            this.index = index;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder home(String home) {
            this.home = home;
            return this;
        }

        public Builder apartment(String apartment) {
            this.apartment = apartment;
            return this;
        }

        public Builder dateAdded(String dateAdded) {
            this.dateAdded = dateAdded;
            return this;
        }

        public Builder dateLastChange(String dateLastChange) {
            this.dateLastChange = dateLastChange;
            return this;
        }

        public Model build() {
            return new Model(this);
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMobilePhone2() {
        return mobilePhone2;
    }

    public void setMobilePhone2(String mobilePhone2) {
        this.mobilePhone2 = mobilePhone2;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getAddress() {
        return city + " " +  street + " " + home + " " + apartment + " " + index;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateLastChange() {
        return dateLastChange;
    }

    public void setDateLastChange(String dateLastChange) {
        this.dateLastChange = dateLastChange;
    }

    @Override
    public String toString() {
        return "Login: " + login + "\n" +
                "Full Name: " +  getFullName() + "\n" +
                "Nickname: " + nickName + "\n" +
                "Comment: " + comment + "\n" +
                "Groups: " + groups + "\n" +
                "Home phone: " + homePhone + "; Mobile phone: " + mobilePhone + "; Second Mobile Phone: " + mobilePhone2 + "\n" +
                "Email: " + eMail + "; Skype: " + skype + "\n" +
                "Full address: " + getAddress() + "\n" +
                "Date added: " + dateAdded + "; Date changed: " + dateLastChange + "\n";
    }
}
