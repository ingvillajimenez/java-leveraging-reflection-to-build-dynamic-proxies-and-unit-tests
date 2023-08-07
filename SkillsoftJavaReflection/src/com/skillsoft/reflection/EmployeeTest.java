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

        assertCheck(employee.getName().equals("dd"));

        assertCheck(employee.getTitle().equals("VP"));

        assertCheck(employee.getSalary() == 100000);
    }

    @Teardown
    public void teardown() {
        employee = null;

        System.out.println("***Teardown complete");
    }
}
