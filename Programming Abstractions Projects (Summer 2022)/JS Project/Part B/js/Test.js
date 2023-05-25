import BinarySearchTree from "./BinarySearchTree.js";
import { Person, Employee, Student } from "./People.js";

const NUM_BINS = 5;
const KEY_LENGTH = 8;

function printBST(header, tree) {
    let text = tree.toString() + "\n";
    console.log(header + "\n" + text);
    let outputDisplay = document.getElementById("output-display");
    text = text.replaceAll(/(?:\r\n|\r|\n)/g, '<br>');
    text = text.replaceAll(" ", '&nbsp;');
    outputDisplay.innerHTML += text;
}

function addPersonToBST(person, tree) {
    tree.putValue(person.key, person);
    printBST("Current Binary Search Tree:", tree);
}

let tree = new BinarySearchTree(KEY_LENGTH);

// DEMONSTRATE ADDING VALUES TO THE BST, WHICH INCLUDES THE NEED TO MAKE THE BST BIGGER
addPersonToBST(new Student(tree.generateKey(), "George", "Harrison", 4.0), tree);
addPersonToBST(new Employee(tree.generateKey(), "Paul", "McCartney", 80000), tree);
addPersonToBST(new Employee(tree.generateKey(), "Ringo", "Starr", 40000), tree);
addPersonToBST(new Person(tree.generateKey(), "Chuck", "Berry"), tree);
addPersonToBST(new Student(tree.generateKey(), "Mick", "Jagger", 3.5), tree);
addPersonToBST(new Student(tree.generateKey(), "Jimi", "Hendrix", 3.6), tree);
addPersonToBST(new Person(tree.generateKey(), "Roger", "Waters"), tree);

// DEMONSTRATE MAKING KEYS AND ADDING VALUES TO THE BST    
let jlKey = tree.generateKey();
tree.putValue(jlKey, new Student(jlKey, "John", "Lennon", 3.8));
let cwKey = tree.generateKey();
tree.putValue(cwKey, new Student(cwKey, "Charlie", "Watts", 3.1));
let dgKey = tree.generateKey();
tree.putValue(dgKey, new Employee(dgKey, "David", "Gilmour", 120000));

// let testKey = tree.generateKey();
// tree.putValue(testKey, new Student(testKey, "Bobby", "Boy", 2.2));
printBST("\nAfter Changing 3 Items", tree);

// DEMONSTRATE GETTING VALUES FROM THE BST
let p = tree.getValue(jlKey);
console.log("\nget " + jlKey + ": " + p.toString() + "\n");
p = tree.getValue(cwKey);
console.log("\nget " + cwKey + ": " + p.toString() + "\n");
p = tree.getValue(dgKey);
console.log("\nget " + dgKey + ": " + p.toString() + "\n");

// p = tree.getValue(testKey);
// console.log("\nget " + testKey + ": " + p.toString() + "\n");

// NOW LET'S TRY REPLACING THE DATA IN THE ABOVE THREE
tree.putValue(jlKey, new Student(jlKey, "Otis", "Redding", 3.5));
tree.putValue(cwKey, new Student(cwKey, "Keith", "Richards", 3.1));
tree.putValue(dgKey, new Student(dgKey, "Bill", "Withers", 3.4));
printBST("\nAfter Changing 3 Items", tree);

// AND DEMONSTRATE REMOVING ITEMS FROM THE BST
tree.removeValue(jlKey);
printBST("\nAfter Removing Otis Redding", tree);

tree.removeValue(cwKey);
printBST("\nAfter Removing Keith Richards", tree);

tree.removeValue(dgKey);
printBST("\nAfter Removing Bill Withers", tree);

// tree.removeValue(testKey);
// printBST("\nAfter Remove Bobby Boy", tree);