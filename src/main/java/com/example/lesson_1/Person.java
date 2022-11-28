package com.example.lesson_1;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person(String firstName, String lastName, String middleName,
                  String country, String address, String phone,
                  int age, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public Person() {

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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        private final Person person;

        public PersonBuilder (){
        this.person = new Person();
        }


        public PersonBuilder withFirstName(String firstName) {
            this.person.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName) {
            this.person.lastName = lastName;
            return this;
        }

        public PersonBuilder withMiddleName(String middleName) {
            this.person.middleName = middleName;
            return this;
        }

        public PersonBuilder withCountry(String country) {
            this.person.country = country;
            return this;
        }

        public PersonBuilder withAddress(String address) {
            this.person.address = address;
            return this;
        }

        public PersonBuilder withPhone(String phone) {
            this.person.phone = phone;
            return this;
        }

        public PersonBuilder withAge(int age) {
            this.person.age = age;
            return this;
        }

        public PersonBuilder withGender(String gender) {
            this.person.gender = gender;
            return this;
        }
        public Person build() {
            return person;
        }

    }

}
