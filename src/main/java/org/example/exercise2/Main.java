package org.example.exercise2;

import org.example.exercise2.model.CentroDistribucion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<CentroDistribucion> arrCentroDistribucion;

    public static void main(String[] args) {
        loadData();
        findCenter("lurin");
        findCenter("ica");
        findCenter("trujillo");
        findCenter("huanuco");
        findCenter("lima");
    }

    public static void findCenter(String center) {
        List<String> descriptions = arrCentroDistribucion.stream()
                .filter(x -> x.getCenter().equalsIgnoreCase(center))
                .map(CentroDistribucion::getDescription)
                .toList();

        if (!descriptions.isEmpty()) {
            descriptions.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron centros de distribución para el centro: " + center);
        }
    }

    public static void loadData() {
        arrCentroDistribucion = new ArrayList<>();
        arrCentroDistribucion.add(
                CentroDistribucion.builder()
                        .center("LURIN")
                        .description("Centro de esparcimiento Lurin").build());
        arrCentroDistribucion.add(
                CentroDistribucion.builder()
                        .center("ICA")
                        .description("Centro de esparcimiento Ica").build());
        arrCentroDistribucion.add(
                CentroDistribucion.builder()
                        .center("TRUJILLO")
                        .description("Centro de esparcimiento Trujillo").build());
        arrCentroDistribucion.add(
                CentroDistribucion.builder()
                        .center("HUANUCO")
                        .description("Centro de esparcimiento Huanuco").build());
    }
}
