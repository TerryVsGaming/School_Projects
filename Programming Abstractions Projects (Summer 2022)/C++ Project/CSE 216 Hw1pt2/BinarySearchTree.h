template <class T>

class BinarySearchTree {
    
    // THIS INNER CLASS IS FOR OUR TREE NODES
    class Node {
        public:
            T* data;
            //YOU WILL NEED TO ADD MORE TO THIS NODE CLASS
            Node* left;
            Node* right;
            string key;
    };

    private:
        Node *root;
        int size;
        int keyLength;

    public:
        BinarySearchTree(int initKeyLength) {
            root = nullptr;
            size = 0;
            this->keyLength = initKeyLength;
        }

        string generateKey() {
            string key {""};
            for (int i = 0; i < this->keyLength; i++) {
                int randomNum = (rand() % 36);
                char randomChar;
                if (randomNum < 10) {
                    randomChar = (char)(randomNum + 48);
                }
                else {
                    randomChar = (char)(randomNum + 55);
                }
                key += randomChar;
            }
            return key;
        }
        
        int getSize() { 
            return this->size;
        }
        
        
        
        
        
        void putValue(string key, T* data) {
             Node* current = root;
            
            if (root == nullptr){
                root = new Node();
                root->key = key;
                root->data = data;
                root->left = nullptr;
                root->right = nullptr;
                return;
            }
            while(true){
            if (current->key == key){
                current->data = data;
                return;
            }
            
            if (key < current->key){
               if (current->left == nullptr){
                   current->left = new Node();
                   current->left->key = key;
                   current->left->data = data;
                   current->left->left = nullptr;
                   current->left->right = nullptr;
                   return;
               }
                current = current->left;
            }
            else{
                if (current->right == nullptr){
                   current->right = new Node();
                   current->right->key = key;
                   current->right->data = data;
                   current->right->left = nullptr;
                   current->right->right = nullptr;
                   return;
               }
                current = current->right;
            }
        }
         
            
        }
    

        
        T* getValue(string key) {
            // @todo
            Node* current = root;
            
            while(current != nullptr){
            if (current->key == key){
                return current->data;
            }
            
            if (key < current->key){
                current = current->left;
            }
            else{
                current = current->right;
            }
        }
            return nullptr;
        }
        
        
        
        
        void removeValue(string key) {
            Node* current = root;
            
            if (root == nullptr){
                return;
            }
            
            //removing root wtih no children
            if (root->key == key){
                if (root->left == nullptr && root->right == nullptr){
                   delete(root);
                   root = nullptr;
                }
            
            
                else if(root->left == nullptr){
                    current = root->right;
                    delete(root);
                    root = current;
                }
                else if(root->right == nullptr){
                    current = root->left;
                    delete(root);
                    root = current;
                }
                
                
                //Root has both children
                else{
                    Node* leftMax = findMax(root->left);
                    string maxKey = leftMax->key;
                    T* maxItem = leftMax->data;
                    removeValue(maxKey);
                    root->key = maxKey;
                    root->data = maxItem;
                }
                return;
            }
        
            
            while(current != nullptr){
                
            if (key < current->key){
                Node* child = current->left;
               
                if (child->key == key){
                    
                    if (child->left == nullptr && child->right == nullptr){
                   delete(child);
                   current->left = nullptr;
                }
            
            
                else if(child->left == nullptr){
                    Node* grandChild = child->right;
                    delete(child);
                    current->left = grandChild;
                }
                else if(child->right == nullptr){
                    Node* grandChild = child->left;
                    delete(child);
                    current->left = grandChild;
                }
                //Child has both children
                else{
                    Node* leftMax = findMax(child->left);
                    string maxKey = leftMax->key;
                    T* maxItem = leftMax->data;
                    removeValue(maxKey);
                    current->key = maxKey;
                    current->data = maxItem;
                    
                }
                  return;  
                }
                current = child;
            }
            else{
                
                Node* child = current->right;
                
                if (child->key == key){
                    
                    if (child->left == nullptr && child->right == nullptr){
                   delete(child);
                   current->right = nullptr;
                }
            
            
                else if(child->left == nullptr){
                    Node* grandChild = child->right;
                    delete(child);
                    current->right = grandChild;
                }
                else if(child->right == nullptr){
                    Node* grandChild = child->left;
                    delete(child);
                    current->right = grandChild;
                    
                }
                //Child has both children
                else{
                    Node* leftMax = findMax(child->left);
                    string maxKey = leftMax->key;
                    T* maxItem = leftMax->data;
                    removeValue(maxKey);
                    current->key = maxKey;
                    current->data = maxItem;
                    
                }
                  return;  
                }
                current = child;
            }
            
            
                
            }
        }
        
        Node* findMax(Node* node){
            if (node == nullptr){
                return nullptr;
            }
            else if(node->right == nullptr){
                return node;
            }
            else{
                return findMax(node->right);
            }
        }
        
        
        string toStringHelper(Node* node, string indent){
            stringstream ss;
            if (node == nullptr){
                return "";
            }
            string left = toStringHelper(node->left, indent + "  ");
            string right = toStringHelper(node->right, indent + "  ");
            
            if (left != ""){
                ss << left << "\n";
            }
             ss << indent << "(" << node->key << "," << node->data->toString() << ")";
             if (right != ""){
                 ss  << "\n" << right << "\n";
             }
             return ss.str();
        }
        
        string toString() {
        return toStringHelper(root, "");
        }
    
};