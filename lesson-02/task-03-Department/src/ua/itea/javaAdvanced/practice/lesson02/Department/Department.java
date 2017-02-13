package ua.itea.javaAdvanced.practice.lesson02.Department;

import java.util.ArrayList;

public class Department <T extends Person>{
    String name;
    ArrayList<T> employees;

    Department(String name, ArrayList<T> employees){
        this.name = name;
        this.employees = employees;
    }

    Double averageAge(){
        Double sum = 0D;
        for (T x : employees) {
            sum +=x.getAge();
        }
        return sum/employees.size();
    }

    void addEmployee(T employee){
        employees.add(employee);
    }

    boolean hasSameAverageAge(Department<?> anotherDepartment){
        if (Math.abs(this.averageAge() - anotherDepartment.averageAge())<1e-5){
            return true;
        }
        return false;
    }

}
