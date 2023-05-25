class KeyValuePair {
    constructor(initKey, initValue) {
        this.key = initKey;
        this.value = initValue;
    }
    
    toString() {
        return "(" + this.key + ", " + this.value.toString() + ")";
    }
}

export default class OpenAddressHashTable {
    constructor(initLength, initKeyLength) {
        this.length = initLength;
        this.size = 0;
        this.keyLength = initKeyLength;
        this.hashTable = [];
    }

    hashCode(key) {
        let charsSum = 0;
        for (let i = 0; i < key.length; i++) {
            let keyChar = key.charAt(i);
            let charAsNum = keyChar.charCodeAt(0);
            charsSum += charAsNum;
        }
        return charsSum % this.length;
    }

    generateKey() {
        let key = "";
        for (let i = 0; i < this.keyLength; i++) {
            let randomNum = Math.floor(Math.random() * 36);
            let randomChar;
            if (randomNum < 10) {
                randomNum += 48;
                randomChar = String.fromCharCode(randomNum);
            }
            else {
                randomNum += 55;
                randomChar = String.fromCharCode(randomNum);
            }
            key += randomChar;
        }
        return key;
    }
    
    
    getValue(key) { 
        let index = this.hashCode(key);
        let count = 0;

        while (count < this.length){
            let testKeyValuePair = this.hashTable[index];

            if (testKeyValuePair == null){
                return null;
            }

            else if (testKeyValuePair.key == key){
                return testKeyValuePair.value;
            }
            index++;
            
            if (index == this.length){
                index = 0;
            }
            count++;
        }
        return null;
    }

    
        
    putValue(key, item) {
        let index = this.hashCode(key);
        let count = 0;

        while (count < this.length){
            let testKeyValuePair = this.hashTable[index];

            if (testKeyValuePair == null){
                this.hashTable[index] = new KeyValuePair (key, item);
                this.size++;
                return;
            }    

            else if (testKeyValuePair.key == key){
                this.hashTable[index].value = item;
                this.size++;
                return;
            }
            index++;

            if (index == this.length){
                index = 0;
            }
            count++;
    }

let temp = this.hashTable;
this.length = this.length*2;
this.hashTable = [];


let sizeCopy = this.size;
this.size = 0;

let i;
for (i = 0; i < sizeCopy; i++){
    let kvp = temp[i];
    let ktm = kvp.key;
    let vtm = kvp.value;
    this.putValue(ktm,vtm);
}


this.putValue(key,item);
}  


    removeValue(key) {
        let index = this.hashCode(key);
        let count = 0;

        while (count < this.length){
            let testKeyValuePair = this.hashTable[index];

            if (testKeyValuePair == null){
                console.log(key + "key not found!");
                console.log("count: " + count);
                console.log("Index: " + index);
                return;
            }

            else if (testKeyValuePair.key == key){
               this.hashTable[index] = null;
                
               let temp = this.hashTable;
               this.hashTable = [];
               
               this.size = 0;
               
               let i;   
               for (i = 0; i < temp.length; i++){
                   if (temp[i] != null){
                       this.putValue(temp[i].key, temp[i].value);
                    }
                }
                return;
            }

        index++;

        if (index == this.length){
            index = 0;
            }
            count++;
        }
    }





    toString() {
        let text = "[\n";
        for (let i = 0; i < this.length; i++) {
            let kvp = this.hashTable[i];
            let kvpDescription = "null";
            if (kvp != null) {
                kvpDescription = kvp.toString();
            }
            text += "   " + i + ": " + kvpDescription + "\n";
        }
        text += "]\n";
        return text;
    }
};