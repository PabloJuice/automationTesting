package task_5;

import task_models.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTask {
	//Input - collection of employees(simple model with few fields: name, mail, salary…).
	//Using stream functionality sort the list,
	//filter it (ex: salary should be more than 1000$).
	//Collect it to the String List with names.

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Andrew", "Andrew@gmail.com", 3000));
		employees.add(new Employee("Pavlo", "Pavlo@gmail.com", 1300));
		employees.add(new Employee("George", "George@gmail.com", 1600));
		employees.add(new Employee("Eran", "Eran@gmail.com", 2000));
		employees.add(new Employee("Mike", "Mike@gmail.com", 1500));
		employees.add(new Employee("Feasd", "Feasd@gmail.com", 2500));
		employees.add(new Employee("Mana", "Mana@gmail.com", 5555));

		System.out.println(sortEmployeesBySalary(employees));
		System.out.println(filterEmployeesBySalary(employees, 2000));
		System.out.println(employeesToNameList(employees));
	}

	public static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
		if (employees == null || employees.isEmpty()) {
			return new ArrayList<>();
		}
		return employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
	}

	public static List<Employee> filterEmployeesBySalary(List<Employee> employees, Integer fromSalary) {
		if (employees == null || employees.isEmpty()) {
			return new ArrayList<>();
		}
		return employees.stream()
				.filter(employee -> employee.getSalary() >= fromSalary)
				.collect(Collectors.toList());
	}

	public static List<String> employeesToNameList(List<Employee> employees) {
		if (employees == null || employees.isEmpty()) {
			return new ArrayList<>();
		}
		return employees.stream()
				.map(Employee::getName)
				.collect(Collectors.toList());
	}
}
