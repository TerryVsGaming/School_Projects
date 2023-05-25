import OpenAddressHashTable from "./OpenAddressHashTable.js";
import { Person, Employee, Student } from "./People.js";

const NUM_BINS = 5;
const KEY_LENGTH = 8;

function printHashTable(header, hashTable) {
    let text = hashTable.toString();
    text = header + "\n" + text;
    console.log(text);
    let outputDisplay = document.getElementById("output-display");
    text = text.replaceAll(/(?:\r\n|\r|\n)/g, '<br>');
    text = text.replaceAll(" ", '&nbsp;');
    outputDisplay.innerHTML += text;
}   

function addPersonToHashTable(person, hashTable) {
    hashTable.putValue(person.key, person);
    printHashTable("Current Hash Table:", hashTable);
}

let hashTable = new OpenAddressHashTable(NUM_BINS, KEY_LENGTH);

// DEMONSTRATE ADDING VALUES TO THE HASH TABLE, WHICH INCLUDES THE NEED TO MAKE THE HASH TABLE BIGGER
addPersonToHashTable(new Student(hashTable.generateKey(), "George", "Harrison", 4.0), hashTable);
addPersonToHashTable(new Employee(hashTable.generateKey(), "Paul", "McCartney", 80000), hashTable);
addPersonToHashTable(new Employee(hashTable.generateKey(), "Ringo", "Starr", 40000), hashTable);
addPersonToHashTable(new Person(hashTable.generateKey(), "Chuck", "Berry"), hashTable);
addPersonToHashTable(new Student(hashTable.generateKey(), "Mick", "Jagger", 3.5), hashTable);
addPersonToHashTable(new Student(hashTable.generateKey(), "Jimi", "Hendrix", 3.6), hashTable);
addPersonToHashTable(new Person(hashTable.generateKey(), "Roger", "Waters"), hashTable);

// DEMONSTRATE MAKING KEYS AND ADDING VALUES TO THE HASH TABLE    
let jlKey = hashTable.generateKey();
hashTable.putValue(jlKey, new Student(jlKey, "John", "Lennon", 3.8));
let cwKey = hashTable.generateKey();
hashTable.putValue(cwKey, new Student(cwKey, "Charlie", "Watts", 3.1));
let dgKey = hashTable.generateKey();
hashTable.putValue(dgKey, new Employee(dgKey, "David", "Gilmour", 120000));
let testKey = hashTable.generateKey();
// hashTable.putValue(testKey, new Student(testKey, "Bobby", "Boy", 1.2));
// printHashTable("\nAfter Changing 3 Items", hashTable);



// DEMONSTRATE GETTING VALUES FROM THE HASH TABLE
let p = hashTable.getValue(jlKey);
console.log("\nget " + jlKey + ": " + p.toString() + "\n");
p = hashTable.getValue(cwKey);
console.log("\nget " + cwKey + ": " + p.toString() + "\n");
p = hashTable.getValue(dgKey);
console.log("\nget " + dgKey + ": " + p.toString() + "\n");
// p = hashTable.getValue(testKey);
// console.log("\nget " + testKey + ": " + p.toString() + "\n");

// NOW LET'S TRY REPLACING THE DATA IN THE ABOVE THREE
hashTable.putValue(jlKey, new Student(jlKey, "Otis", "Redding", 3.5));
hashTable.putValue(cwKey, new Student(cwKey, "Keith", "Richards", 3.1));
hashTable.putValue(dgKey, new Student(dgKey, "Bill", "Withers", 3.4));
// hashTable.putValue(testKey, new Student(testKey, "Billy", "Bob", 1.2));
printHashTable("\nAfter Changing 3 Items", hashTable);

// AND DEMONSTRATE REMOVING ITEMS FROM THE BST
// hashTable.removeValue(testKey)
// printHashTable("\nAfter Removing Billy Bob", hashTable);
hashTable.removeValue(jlKey);
printHashTable("\nAfter Removing Otis Redding", hashTable);

hashTable.removeValue(cwKey);
printHashTable("\nAfter Removing Keith Richards", hashTable);

hashTable.removeValue(dgKey);
printHashTable("\nAfter Removing Bill Withers", hashTable);

