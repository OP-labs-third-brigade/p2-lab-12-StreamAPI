package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class task_1_and_3 {
    public static void main(String[] args) {
        List<Enrollee> applicants = new ArrayList<>();
        applicants.add(new Enrollee("Василенко", 65));
        applicants.add(new Enrollee("Ігнатенко", 90));
        applicants.add(new Enrollee("Захарченко", 80));
        applicants.add(new Enrollee("Катеринчук", 75));
        applicants.add(new Enrollee("Коваленко", 45));
        applicants.add(new Enrollee("Ковальчук", 70));
        applicants.add(new Enrollee("Марієнко", 100));
        applicants.add(new Enrollee("Олександров", 50));
        applicants.add(new Enrollee("Петров", 60));
        applicants.add(new Enrollee("Іванов", 45));
        applicants.add(new Enrollee("Іванова", 68));
        applicants.add(new Enrollee("Сидоренко", 76));
        applicants.add(new Enrollee("Бойко", 43));

        int budgetSeats = 10;
        int passingScore = 60;


        List<Enrollee> selectedApplicants = applicants.stream()
                .filter(applicant -> applicant.getPoints() >= passingScore)
                .sorted(Comparator.comparingInt(Enrollee::getPoints).reversed())
                .limit(budgetSeats)
                .sorted(Comparator.comparing(Enrollee::getLastName))
                .collect(Collectors.toList());

        System.out.println("Абітурієнти на бюджет:");
        selectedApplicants.forEach(System.out::println);


        List<Enrollee> failedApplicants = applicants.stream()
                .filter(applicant -> applicant.getPoints() < passingScore)
                .collect(Collectors.toList());

        System.out.println("\nСписок абітурієнтів, які не можуть бути зараховані в інститут:");
        failedApplicants.forEach(System.out::println);
    }
}