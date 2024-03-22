/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practical18;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author darkp
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Ангер Артем Вариант 1");

        Scanner input = new Scanner(System.in);

        HashMap<String, Car> cars = new HashMap<>();
        cars.put("x001xx", (new Car("Volvo s90", 2015)));
        cars.put("x002xx", (new Car("Lada Vesta", 2020)));
        cars.put("x003xx", (new Car("Kia Rio", 2012)));

        for (Entry<String, Car> entr : cars.entrySet()) {
            String carNumber = entr.getKey();
            String carModel = entr.getValue().getModel();
            int carYear = entr.getValue().getYear();
            System.out.println("Модель: " + carModel +
                    ", Год выпуска: " + carYear + ", Номер: " + carNumber);
        }

        System.out.println("1 - Добавить новый автомобиль, " +
                "2 - удалить автомобиль по его номеру, 3 - удалить все автомобили");
        int flag = input.nextInt();

        while (flag != 0) {
            if (flag == 1) {
                System.out.println("Введите модель ");
                String inputModel = input.next();
                System.out.println("Введите год ");
                int inputYear = input.nextInt();
                if (inputYear > 2024 || inputYear < 0) {
                    System.out.println("Неверный год, введите верный");
                    inputYear = input.nextInt();
                }
                System.out.println("Введите номер ");
                String inputNumber = input.next();
                cars.put(inputNumber, (new Car(inputModel, inputYear)));

                for (Entry<String, Car> entr : cars.entrySet()) {
                    String carNumber = entr.getKey();
                    String carModel = entr.getValue().getModel();
                    int carYear = entr.getValue().getYear();
                    System.out.println("Модель: " + carModel +
                            ", Год выпуска: " + carYear + ", Номер: " + carNumber);
                }
            }

            if (flag == 2) {
                System.out.println("Введите номер");
                String inputNumber = input.next();
                if (cars.containsKey(inputNumber)) {
                    cars.remove(inputNumber);

                    for (Entry<String, Car> entr : cars.entrySet()) {
                        String carNumber = entr.getKey();
                        String carModel = entr.getValue().getModel();
                        int carYear = entr.getValue().getYear();
                        System.out.println("Модель: " + carModel +
                                ", Год выпуска: " + carYear + ", Номер: " + carNumber);
                    }
                }
                else {
                    System.out.println("Такого номера не существует");
                }
            }

            if (flag == 3) {
                cars.clear();
                System.out.println("Все автомобили удалены");

                for (Entry<String, Car> entr : cars.entrySet()) {
                    String carNumber = entr.getKey();
                    String carModel = entr.getValue().getModel();
                    int carYear = entr.getValue().getYear();
                    System.out.println("Модель: " + carModel +
                            ", Год выпуска: " + carYear + ", Номер: " + carNumber);
                }
            }

            if (flag == 3) {
                System.out.println("1 - Добавить новый автомобиль, 0 - стоп");
                flag = input.nextInt();
            }
            else {
                System.out.println("1 - Добавить новый автомобиль, " +
                        "2 - удалить автомобиль по его номеру, 3 - удалить все автомобили, 0 - стоп");
                flag = input.nextInt();
            }
        }
    }
}