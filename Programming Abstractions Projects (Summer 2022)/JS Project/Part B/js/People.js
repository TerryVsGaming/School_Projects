class Person {
    constructor(initKey, initFirstName, initLastName) {
        this.key = initKey;
        this.firstName = initFirstName;
        this.lastName = initLastName;
    }
    
    toString() {
        return this.key + ": " + this.firstName + " " + this.lastName;
    }
}

class Employee extends Person {
    constructor(initKey, initFirstName, initLastName, initSalary) {
        super(initKey, initFirstName, initLastName);
        this.salary = initSalary;
    }

    toString() {
        return  super.toString() + " ($" + this.salary.toLocaleString() + ")";
    }
}

class Student extends Person {
    constructor(initKey, initFirstName, initLastName, initGPA) {
        super(initKey, initFirstName, initLastName);
        this.gpa = initGPA;
    }

    toString() {
        return super.toString() + " (" + this.gpa.toFixed(1) + " GPA)";
    }
}

export {Person, Employee, Student};