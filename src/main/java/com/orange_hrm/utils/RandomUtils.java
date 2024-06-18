package com.orange_hrm.utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    Faker faker = new Faker();

//    public TextBoxEntity generateRandomTextBoxEntity() {
//
//        TextBoxEntity textBoxEntity = new TextBoxEntity();
//        textBoxEntity.setFullName(faker.name().fullName());
//        textBoxEntity.setEmail(faker.internet().emailAddress());
//        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
//        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
//        return textBoxEntity;
//    }
//
//    public PracticeFormEntity generateRandomPracticeFormEntity() {
//
//        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
//        practiceFormEntity.setFirstName(faker.name().firstName());
//        practiceFormEntity.setLastName(faker.name().lastName());
//        practiceFormEntity.setEmail(faker.internet().emailAddress());
//        practiceFormEntity.setGender(faker.demographic().sex());
//        practiceFormEntity.setMobileNumber(faker.phoneNumber().subscriberNumber(10));
//        practiceFormEntity.setDateOfBirth(String.valueOf(faker.date().birthday()));
////        practiceFormEntity.setSubjects(faker.educator().course());
//        practiceFormEntity.setSubjects("Computer Science");
//        practiceFormEntity.setHobbies(faker.name().name());
//        practiceFormEntity.setUpLoadPicture("C:\\sdet2024\\DemoQAWinter24\\src\\main\\resources\\pictures\\flowers.jpg");
//        practiceFormEntity.setCurrentAddress(faker.address().fullAddress());
//        practiceFormEntity.setState(faker.address().state());
//        practiceFormEntity.setCity(faker.address().city());
////        practiceFormEntity.setState("NCR");
////        practiceFormEntity.setCity("Delhi");
//        return practiceFormEntity;
//
//    }
//
//    public Employee createMokEmployee() {
//
//        Employee employee = new Employee();
//        employee.setFirstname(faker.name().firstName());
//        employee.setLastname(faker.name().lastName());
//        employee.setAge(faker.number().numberBetween(18, 100));
//        employee.setEmail(faker.internet().emailAddress());
//        employee.setSalary(faker.number().numberBetween(1000000, 20000000L));
//        employee.setDepartment(faker.job().position());
//        return employee;
//    }
}
