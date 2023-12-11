package ru.netology.persons;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;

    private int age = -1;

    private String livingTown = "";

    Person(String name, String surname) { // Убрал public, хочу чтоб доступ был только из этого же пакета
//        if (name.isEmpty() || surname.isEmpty()) {
//            throw new IllegalStateException("Имя и Фамилия не должны быть пустыми");
//        }
        this.name = name;
        this.surname = surname;
    }

    Person(String name, String surname, int age) { // Убрал public, хочу чтоб доступ был только из этого же пакета
//        if (name.isEmpty() || surname.isEmpty()) {
//            throw new IllegalStateException("Имя и Фамилия не должны быть пустыми");
//        }
        this.name = name;
        this.surname = surname;
        if (age >= 0) {
            this.age = age;
        }
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return !livingTown.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        } else {
            return OptionalInt.empty();
        }
    }

    public String getAddress() {
        return livingTown;
    }

    public void setAddress(String city) {
        this.livingTown = city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        return child.setSurname(this.surname).setAge(0);
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"surname\": \"" + surname + "\",\n" +
                "  \"age\": " + (age >= 0 ? age : "\"Not available\"") + ",\n" +
                "  \"livingTown\": \"" + livingTown + "\"\n" +
                "}";
    }


    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        result = 31 * result + livingTown.hashCode();
        return result;
    }
}
