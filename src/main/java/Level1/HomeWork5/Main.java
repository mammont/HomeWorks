package Level1.HomeWork5;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Ivanov Ivan", "Engeneer", "ivanov@gmail.com", "+79261234567", 80000, 30);
        persons[1] = new Person("Petrov Petr", "Economist", "petrov@gmail.com", "+79263215476", 90000, 40);
        persons[2] = new Person("Sidorov Sidor", "Truck Driver", "sidorov@gmail.com", "+79267452367", 75000, 50);
        persons[3] = new Person("Gogishvilli Gogi", "Manager", "gogi@gmail.com", "+995546699", 95000, 47);
        persons[4] = new Person("Robert B. Weide", "Director", "ttt@gmail.com", "+111111111111", 180000, 61);


        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAge()>=40) persons[i].info();
        }
    }


}
