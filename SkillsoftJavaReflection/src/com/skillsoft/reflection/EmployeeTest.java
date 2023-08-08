package com.skillsoft.reflection;

public class EmployeeTest {

    private Employee employee;

    private void assertCheck(boolean input) {
        if (!input) {
            throw new AssertionError();
        }
    }

    @Setup
    public void setup() {
        employee = new Employee("Jason", "VP", 100000);

        System.out.println("***Setup complete");
    }

    @TestCase
    public void testGetters() {
        System.out.println("***testGetters()");

        assertCheck(employee.getName().equals("dd")); // will throw AssertionError exception

        assertCheck(employee.getTitle().equals("VP"));

        assertCheck(employee.getSalary() == 100000);
    }

    @TestCase
    public void testSetters() {
        System.out.println("***testSetters()");

        employee.setName("Janice");
        assertCheck(employee.getName().equals("Wrong"));

        employee.setTitle("Director");
        assertCheck(employee.getTitle().equals("Director"));

        employee.setSalary(80000);
        assertCheck(employee.getSalary() == 80000);
    }

    @TestCase
    public void testBonus() {
        System.out.println("***testBonus()");

        assertCheck(employee.getSalary() == 100000);

        double totalSalary = employee.computeTotalSalary(0.1f);

        System.out.println(totalSalary);
        assertCheck(totalSalary > 119999 && totalSalary < 111111);
    }

    @TestCase
    public void testIncrementSalary() {
        System.out.println("***testIncrementSalary()");

        assertCheck(employee.getSalary() == 100000);

        employee.incrementSalary(0.1f);

        assertCheck(employee.getSalary() > 119999 && employee.getSalary() < 111111);

    }

    @Teardown
    public void teardown() {
        employee = null;

        System.out.println("***Teardown complete");
    }
}
