package org.example.exercise1;

import org.example.exercise1.model.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static List<Person> arrPerson;

    public static void main(String[] args) {
        loadData();

        System.out.println("\nDesordenado");
        orderByDni(false);

        System.out.println("\nOrdenado por DNI");
        orderByDni(true);

        System.out.println("\nDesordenado");
        orderByApellidoPaterno(false);

        System.out.println("\nOrdenador por Apellido Paterno");
        orderByApellidoPaterno(true);
    }

    public static void orderByDni(boolean order) {
        arrPerson.stream()
                .sorted(order ?
                        Comparator.comparing(Person::getDni) :
                        Comparator.comparing(Person::hashCode))
                .forEach(System.out::println);
    }

    public static void orderByApellidoPaterno(boolean order) {
        arrPerson.stream()
                .sorted(order ?
                        Comparator.comparing(Person::getAppPaterno) :
                        Comparator.comparing(Person::hashCode))
                .forEach(System.out::println);
    }

    public static void loadData() {
        arrPerson = new ArrayList<>();
        arrPerson.add(Person.builder()
                .appPaterno("Alzamora")
                .appMatterno("Benavides")
                .dni("77285892").build());
        arrPerson.add(Person.builder()
                .appPaterno("Perez")
                .appMatterno("Albarado")
                .dni("77285426").build());
        arrPerson.add(Person.builder()
                .appPaterno("Ledesma")
                .appMatterno("Gutierrez")
                .dni("76299892").build());
    }
}
