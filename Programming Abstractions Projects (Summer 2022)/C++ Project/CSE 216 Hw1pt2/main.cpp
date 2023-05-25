// FOR printf
#include <stdio.h>

// FOR cout
#include <iostream>
#include<string>
#include <sstream>
using namespace std;

// OUR STUFF
#include "Person.h"
#include "Student.h"
#include "Employee.h"
#include "BinarySearchTree.h"

const int KEY_LENGTH = 8;

void printBST(string header, BinarySearchTree<Person> *tree);
void addPersonToBST(Person *person, BinarySearchTree<Person> *tree);

// EXECUTION OF OUR PROGRAM STARTS HERE
int main() {
    BinarySearchTree<Person> *tree = new BinarySearchTree<Person>(KEY_LENGTH);

    // DEMONSTRATE ADDING VALUES TO THE HASH TABLE, WHICH INCLUDES THE NEED TO MAKE THE HASH TABLE BIGGER
    addPersonToBST(new Student(tree->generateKey(), "George", "Harrison", 4.0), tree);
    addPersonToBST(new Employee(tree->generateKey(), "Paul", "McCartney", 80000), tree);
    addPersonToBST(new Employee(tree->generateKey(), "Ringo", "Starr", 40000), tree);
    addPersonToBST(new Person(tree->generateKey(), "Chuck", "Berry"), tree);
    addPersonToBST(new Student(tree->generateKey(), "Mick", "Jagger", 3.5), tree);
    addPersonToBST(new Student(tree->generateKey(), "Jimi", "Hendrix", 3.6), tree);
    addPersonToBST(new Person(tree->generateKey(), "Roger", "Waters"), tree);

    // DEMONSTRATE MAKING KEYS AND ADDING VALUES TO THE HASH TABLE    
    string jlKey = tree->generateKey();
    tree->putValue(jlKey, new Student(jlKey, "John", "Lennon", 3.8));
    string cwKey = tree->generateKey();
    tree->putValue(cwKey, new Student(cwKey, "Charlie", "Watts", 3.1));
    string dgKey = tree->generateKey();
    tree->putValue(dgKey, new Employee(dgKey, "David", "Gilmour", 120000));
    printBST("\nAfter Changing 3 Items", tree);
    
    // DEMONSTRATE GETTING VALUES FROM THE HASH TABLE
    Person *p = tree->getValue(jlKey);
    cout << endl << "get " << jlKey << ": " << p->toString() << endl;
    p = tree->getValue(cwKey);
    cout << "get " << cwKey << ": " << p->toString() << endl;
    p = tree->getValue(dgKey);
    cout << "get " << dgKey << ": " << p->toString() << endl;
    
    // NOW LET'S TRY REPLACING THE DATA IN THE ABOVE THREE
    tree->putValue(jlKey, new Student(jlKey, "Otis", "Redding", 3.5));
    tree->putValue(cwKey, new Student(cwKey, "Keith", "Richards", 3.1));
    tree->putValue(dgKey, new Student(dgKey, "Bill", "Withers", 3.4));
    printBST("\nAfter Changing 3 Items", tree);
    
    // AND DEMONSTRATE REMOVING ITEMS FROM THE TREEE
    tree->removeValue(jlKey);
    tree->removeValue(cwKey);
    tree->removeValue(dgKey);
    printBST("\nAfter Removing 3 Items", tree);

    return 0;
}

void addPersonToBST(Person *person, BinarySearchTree<Person> *tree) {
    tree->putValue(person->getKey(), person);
    cout << tree->toString();
}

void printBST(string header, BinarySearchTree<Person> *tree) {
    string text = tree->toString();
    cout << header << endl;
    cout << text;
}