class Node {
    constructor(initKey, initData, initParent, initLeft, initRight) {
        this.key = initKey;
        this.data = initData;
        this.parent = initParent;
        this.left = initLeft;
        this.right = initRight;
    }
};

export default class BinarySearchTree {
    constructor(initKeyLength) {
        this.root = null;
        this.size = 0;
        this.keyLength = initKeyLength;
    }

    // @todo - YOU MUST UPDATE THIS METHOD SO A KEY ONLY HAS LOWERCASE LETTERS, NO NUMBERS
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

putValue(key, data){
    let current = this.root;

    if (this.root === null){
       this.root = new Node(key, data, null,null,null);
        return;
    }

    while (true){
        if (current.key === key){
            current.data = data;
            return;
        }
    

    if (key < current.key){
        if (current.left === null){
            current.left = new Node(key, data, current, null,null);
            return;
        }
        current = current.left;
    }

    else{
        if (current.right === null){
            current.right = new Node(key,data,current,null,null);
            return;
        }
        current = current.right;
    }

 }

}


getValue(key){
    let current = this.root;
    
    while(current != null){
        if (current.key === key){
            return current.data;
        }
        if (key < current.key){
            current = current.left;
        }
        else{
            current = current.right;
        }
    }
    return null;
}



removeValue(key) {
    let traveller = this.root;
    let found = false;

    while(!found){
        if (key === (traveller.key)){
            
            if (traveller.left != null){
                let largest = traveller.left;

                while(largest.right != null){
                    largest = largest.right;
                }

                traveller.key = largest.key;
                traveller.data = largest.data;

                if (largest == largest.parent.left){
                    largest.parent.left = null;
                }    
                else{
                    largest.parent.right = null;
                }

            }

            else if (traveller.right != null){

                let smallest = traveller.right;

                while (smallest.left != null){
                    smallest = smallest.left;
                }

                traveller.key = smallest.key;
                traveller.data = smallest.data;

                if (smallest = smallest.parent.right){
                    smallest.parent.right = null;
                }
                else{
                    smallest.parent.left = null;
                }
            }

            else{
                if (traveller == this.root){
                    this.root = null;
                }
                else if(traveller == traveller.parent.left){
                    traveller.parent.left = null;
                }
                else{
                    traveller.parent.right = null;
                }
            }

            this.size--;
            found = true;
        }

        else if (key < traveller.key){
            if (traveller.left == null){
                return;
            }
            else{
                traveller = traveller.left;
            }
        }
        
        else{
            if (traveller.right == null){
                return;
            }
            else{
                traveller = traveller.right;
            }
        }
    }
}












    toStringRecursively(traveller, level) {
        let text = "";

        if (traveller == null){
            return text;
        }

        if (traveller.left != null)
            text += this.toStringRecursively(traveller.left, level+1);
        for (let i = 0; i < level; i++) {
            text += "   ";
        }
        text += "   " + traveller.data.toString() + "\n";
        if (traveller.right != null)
            text += this.toStringRecursively(traveller.right, level+1);
        return text;        
    }

    toString() {
        return this.toStringRecursively(this.root, 0);
    }
}