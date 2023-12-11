package ru.netology.persons;

public class PersonBuilder {

    private String name = "";
    private String surname = "";
    private int age = -1;
    private String livingTown = "";
    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (this.name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя людишки уже заполнено, его нельзя изменить!");
        }
        return this;
    }
    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (this.surname.isEmpty()) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Фамилия людишки уже заполнено, его нельзя изменить!");
        }
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (this.age >= 0) {
            throw new IllegalArgumentException("Возраст людишки уже задан, его нельзя изменить, он может только постареть через happyBirthday!");
        } else {
            if (age < 0) {
                throw new IllegalArgumentException("Возраст не может быть отрицательным");
            } else {
                this.age = age;
            }
        }
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.livingTown = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (this.name.isEmpty() || this.surname.isEmpty()) throw new IllegalStateException("Не заполнены все необходимые данные");
        Person outputPerson = this.age >= 0 ? new Person(this.name, this.surname, this.age) : new Person(this.name, this.surname);
        if (this.livingTown.isEmpty()) {
            outputPerson.setAddress(this.livingTown);
        }
        return outputPerson;
    }
}
