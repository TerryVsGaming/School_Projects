#include <stdlib.h>
#include <ctime>
#include<string>
#include <sstream>
using namespace std;

template < class S > class OpenAddressHashTable
{
  class KeyValuePair
  {
  public:
    // INSTANCE VARIABLES
    string key;
    S *value;

    // CONSTRUCTOR
      KeyValuePair (string initKey, S * initValue)
    {
      key = initKey;
      value = initValue;
    }

    // DESTRUCTOR
     ~KeyValuePair ()
    {
    }

    string toString ()
    {
      stringstream ss;
      ss << "(" << this->key << "," << value->toString () << ")";
      return ss.str ();
    }
  };

private:
  KeyValuePair * *hashTable;
  int length;			//the hash table length (# of KeyValuePairs)
  int size;			//# of elements in the hashtable
  int keyLength;		//the number of characters in a key

public:
  OpenAddressHashTable (int initLength, int initKeyLength)
  {
    this->length = initLength;
    this->size = 0;
    keyLength = initKeyLength;
    hashTable = new KeyValuePair *[initLength];
    srand ((unsigned) time (0));
  }
  int getSize ()
  {
    return this->size;
  }
  int hashCode (string key)
  {
    int charsSum = 0;
    for (auto it = key.cbegin (); it != key.cend (); ++it)
      {
	int num = (int) (*it);
	charsSum += num;
      }
    return charsSum % length;
  }
  //97-122



//DONE
  //YOU MUST UPDATE THIS METHOD SO A KEY ONLY HAS LOWERCASE LETTERS, NO NUMBERS
  string generateKey ()
  {
    string key{""};
    for (int i = 0; i < this->keyLength; i++){
        int randomNum = (rand () % 26);
        char randomChar;
        
        randomChar = (char) (randomNum + 97);
        key += randomChar;
        
    }
    return key;
    }



//DONE

  S *getValue (string key){
      int offset = hashCode (key);	//takes the key and returns the hash value of the key
      KeyValuePair *current = hashTable[offset];
      
      if (current == nullptr){
          return nullptr;
      }
      if (current->key == key)
      {
          return current->value;
      }
      int initOffset = offset;
      offset = offset + 1;
      offset = offset % length;
      
      while (offset != initOffset){
          KeyValuePair *current = hashTable[offset];
          if (current == nullptr){
              return nullptr;
              }
              
              if (current->key == key){
                  return current->value;
                  }
                  offset = offset + 1;
                  offset = offset % length;
      }
      return nullptr;
      
  }

  void removeValue (string key)
  {
    int offset = hashCode (key);	//takes the key and returns the hash value of the key
    KeyValuePair *current = hashTable[offset];
    
    if (current == nullptr)
      {
	return;
      }

    if (current->key == key)
      {
	delete (current);
	hashTable[offset] = nullptr;
	return;
      }

    int initOffset = offset;

    offset = offset + 1;
    offset = offset % length;

    while (offset != initOffset)
      {
	KeyValuePair *current = hashTable[offset];

	if (current == nullptr)
	  {
	    return;
	  }
	if (current->key == key)
	  {
	    delete (current);
	    hashTable[offset] = nullptr;
	    return;
	  }

	offset = offset + 1;
	offset = offset % length;

      }

  }





  void putValue (string key, S * item)
  {
    // if the start is null we're done



    int offset = hashCode (key);	//natural hash location
    KeyValuePair *current = hashTable[offset];

    // If the hashtable is arleady full and the value is not in the array itll be an infiniute loop
    while (current != nullptr)
      {
	if (current->key == key)
	  {
	    current->value = item;
	    return;
	      
	  }
	  offset = offset + 1;
	  offset = offset % length;
	  current = hashTable[offset];

      }
      current = new KeyValuePair (key, item);
      hashTable[offset] = current;
      size++;
      resize ();



  }

  void resize ()
  {
    if (size == length)
      {
	length = length * 2;
	KeyValuePair **newHashTable = new KeyValuePair *[length];
	//length/2
	for (int i = 0; i < length; i++)
	  {
	    newHashTable[i] = nullptr;
	  }
	for (int i = 0; i < length / 2; i++)
	  {
	    KeyValuePair *current = hashTable[i];
	    if (current == nullptr)
	      {
		continue;
	      }

	    int newOffset = hashCode (current->key);
	    //insert into the new hashtable

	    KeyValuePair *newPair = newHashTable[newOffset];

	    while (newPair != nullptr)
	      {
		newOffset = newOffset + 1;
		newOffset = newOffset % length;
		newPair = newHashTable[newOffset];
		//   cout<<newOffset<<"\n";
	      }
	    //No collisions
	    newPair = new KeyValuePair (current->key, current->value);
	    newHashTable[newOffset] = newPair;
	    delete (current);

	  }
	delete hashTable;	// deleting what the field is pointing to
	hashTable = newHashTable;
      }
  }


  string toString ()
  {
    stringstream ss;
    int counter = 0;
    ss << "[" << "\n";
    for (counter = 0; counter < length; counter++)
      {
	ss << "\t" << counter << ": ";
	if (hashTable[counter] == nullptr)
	  {
	    ss << "nullptr";
	  }
	else
	  {
	    ss << hashTable[counter]->toString ();
	  }
	ss << "\n";

      }
    ss << "]" << "\n";
    return ss.str ();
  }
};
