package Level1.HomeWork5;

class Person {
    private String name;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    int getAge() {
        return age;
    }

    Person(String name, String position, String email, String telephone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    void info(){
        System.out.println("Сотрудник: " + name + ". Должность: " + position + ". Возраст: " + age);
    }
}

