import math
import random
import unittest

class IpAddressConverter:
    
    
    def convertDecToBin (dec):
        string = ""
       
                        
        while(dec >= 1):
            if (dec % 2 == 1):
                string += "1"
                dec = math.floor(dec/2)
                
            else:
                string += "0"
                dec = math.floor(dec/2)

        return string[::-1]
        
    
    def convertBinToDec (bin):
        return int(bin,2)
                  # number, base
    
    def numToIPAddress (num):   
        first =  (num >> 24)  & 0xFF 
        second = (num >> 16) & 0xFF
        third =  (num >> 8) & 0xFF
        fourth = num & 0xFF

        

        return str(first) + "." + str(second) + "." + str(third) + "." + str(fourth)
       
 
    def IpToNum(ip):
        total = ""
        goal = "."
        periods = []
      
        for index, element in enumerate(ip):
            if (element == goal):
              periods.append(index)
        
        first = (ip[0:periods[0]])
        second = (ip[periods[0]+1:periods[1]])
        third = (ip[periods[1]+1:periods[2]])
        fourth = (ip[periods[2]+1:len(ip)])
        
        StrfirstDec = str(IpAddressConverter.convertDecToBin(int(first)))
        StrfirstDec = (StrfirstDec.zfill(8))
        
        StrSecondDec = str(IpAddressConverter.convertDecToBin(int(second)))
        StrSecondDec = (StrSecondDec.zfill(8))
        
        StrthirdDec = str(IpAddressConverter.convertDecToBin(int(third)))
        StrthirdDec = (StrthirdDec.zfill(8))
        
        StrfourthDec = str(IpAddressConverter.convertDecToBin(int(fourth)))
        StrfourthDec = (StrfourthDec.zfill(8))
        
        total = StrfirstDec + StrSecondDec + StrthirdDec + StrfourthDec
        totalDec = IpAddressConverter.convertBinToDec(total)
        
        return totalDec
       
       
class MonoalphabeticCipher:
    def __init__(self):
        self.generateKey()   
    
    def alphabet():
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        
    def generateKeyHelper(originalAlphabet, inProgressAlphabet):
        if (originalAlphabet == ""):
            return inProgressAlphabet
            
        index = random.randrange(len(originalAlphabet))
        inProgressAlphabet = inProgressAlphabet+(originalAlphabet[index])
        originalAlphabet = originalAlphabet[:index]  + originalAlphabet[index+1:]
        return MonoalphabeticCipher.generateKeyHelper(originalAlphabet,inProgressAlphabet)
        
    
    def generateKey(self):
        self.key = MonoalphabeticCipher.generateKeyHelper(MonoalphabeticCipher.alphabet() , "")
        return self.key
        
    
    def encryptLetter(self, letter):
        index = MonoalphabeticCipher.alphabet().find(letter)
        
        if (index < 0):
            return letter
        
        return self.key[index]
        
    def encrypt(self, plainText):
        encryption = ""
       
        plainText = plainText.upper()
       
        for eachLetter in plainText:
            encryption = encryption + self.encryptLetter(eachLetter)
            
        return encryption
    
    def decryptLetter(self,letter):
        index = self.key.find(letter)
        
        if (index < 0):
            return letter
        
        return MonoalphabeticCipher.alphabet()[index]

    def decrypt(self, cipherText):
        decryption = ""
       
        cipherText = cipherText.upper()
       
        for eachLetter in cipherText:
            decryption = decryption + self.decryptLetter(eachLetter)
            
        return decryption
    
    def checkNoDuplicates(text):
        if (len(set(text)) == len(text)):
            return True
        return False
    
    
        
    
class TestIPAddressConverter(unittest.TestCase):
    def test_IpToNum(self):
        print("IP TO NUM TESTS")
        print("_______________")
        print("Testing 127.0.0.1 -> 2130706433")
        self.assertEqual(IpAddressConverter.IpToNum("127.0.0.1") , 2130706433)
        print("Testing 127.0.0.2 -> 2130706434")
        self.assertEqual(IpAddressConverter.IpToNum("127.0.0.2") , 2130706434)
        print("Testing 127.1.1.2 -> 2130772226")
        self.assertEqual(IpAddressConverter.IpToNum("127.1.1.2") , 2130772226)
        print("Testing 255.255.255.255 -> 4294967295")
        self.assertEqual(IpAddressConverter.IpToNum("255.255.255.255") , 4294967295)
        print("Testing 255.255.255.254 -> 4294967294")
        self.assertEqual(IpAddressConverter.IpToNum("255.255.255.254") , 4294967294)
        print("Testing 0.0.0.0 -> 0")
        self.assertEqual(IpAddressConverter.IpToNum("0.0.0.0") , 0)
        print("Testing 1.1.1.1 -> 16843009")
        self.assertEqual(IpAddressConverter.IpToNum("1.1.1.1") , 16843009)
        print("Testing 2.2.2.2 ->  33686018")
        self.assertEqual(IpAddressConverter.IpToNum("2.2.2.2") , 33686018)
        print("Testing 3.3.3.3 ->  50529027.")
        self.assertEqual(IpAddressConverter.IpToNum("3.3.3.3") , 50529027)
        print("Testing 4.4.4.4 -> 67372036")
        self.assertEqual(IpAddressConverter.IpToNum("4.4.4.4") , 67372036)
    
    def test_NumToIp(self):    
        print("\nNUM TO IP TESTS")
        print("_______________")
        print("Testing 2130706433 -> 127.0.0.1")
        self.assertEqual(IpAddressConverter.numToIPAddress(2130706433),"127.0.0.1")
        print("Testing 2130706434 -> 127.0.0.2")
        self.assertEqual(IpAddressConverter.numToIPAddress( 2130706434),"127.0.0.2")
        print("Testing 2130772226 -> 127.1.1.2 ")
        self.assertEqual(IpAddressConverter.numToIPAddress(2130772226),"127.1.1.2")
        print("Testing 4294967295 -> 255.255.255.255")
        self.assertEqual(IpAddressConverter.numToIPAddress(4294967295) , "255.255.255.255")
        print("Testing 4294967294 -> 255.255.255.254")
        self.assertEqual(IpAddressConverter.numToIPAddress(4294967294) , "255.255.255.254")
        print("Testing 0 -> 0.0.0.0")
        self.assertEqual(IpAddressConverter.numToIPAddress(0) , "0.0.0.0")
        print("Testing 16843009 -> 1.1.1.1")
        self.assertEqual(IpAddressConverter.numToIPAddress(16843009) , "1.1.1.1")
        print("Testing 33686018 -> 2.2.2.2")
        self.assertEqual(IpAddressConverter.numToIPAddress(33686018) , "2.2.2.2")
        print("Testing 50529027 -> 3.3.3.3")
        self.assertEqual(IpAddressConverter.numToIPAddress(50529027) , "3.3.3.3")
        print("Testing 67372036 -> 4.4.4.4 ")
        self.assertEqual(IpAddressConverter.numToIPAddress(67372036) ,"4.4.4.4")
     
class TestMonoalphabeticCipher(unittest.TestCase):     
    def test_generateKey(self):
        print("\nGenerateKey() Tests")
        print("___________________")
        key1 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key1) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key1))
        print("Testing " + key1)
        self.assertTrue(testing, "Bad Key")
        
        key2 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key2) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key2))
        print("Testing " + key2)
        self.assertTrue(testing, "Bad Key")
        
        key3 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key3) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key3))
        print("Testing " + key3)
        self.assertTrue(testing, "Bad Key")

        key4 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key4) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key4))
        print("Testing " + key4)
        self.assertTrue(testing, "Bad Key")

        key5 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key5) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key5))
        print("Testing " + key5)
        self.assertTrue(testing, "Bad Key")

        key6 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key6) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key6))
        print("Testing " + key6)
        self.assertTrue(testing, "Bad Key")

        key7 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key7) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key7))
        print("Testing " + key7)
        self.assertTrue(testing, "Bad Key")

        key8 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key8) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key8))
        print("Testing " + key8)
        self.assertTrue(testing, "Bad Key")

        key9 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key9) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key9))
        print("Testing " + key9)
        self.assertTrue(testing, "Bad Key")

        key10 = MonoalphabeticCipher.generateKey(self)
        testing = (len(key10) == 26) and (MonoalphabeticCipher.checkNoDuplicates(key10))
        print("Testing " + key10 + "\n")
        self.assertTrue(testing, "Bad Key")

    def test_encrpyt(self):
        cipher = MonoalphabeticCipher()
        cipher.key = "FOZWATCKEXNVYSUHQBGDLIPRMJ"
        print("\nEncrypt Test")
        print("____________________")
        print("\nKey for Testing: " + cipher.key)
       
        encryption1 = cipher.encrypt("Hello World")
        print("Hello World -> " + encryption1)
        self.assertEqual(encryption1, "KAVVU PUBVW")       
        
        encryption2 = cipher.encrypt("Hello")
        print("Hello World -> " + encryption2)
        self.assertEqual(encryption2, "KAVVU") 
        
        encryption3 = cipher.encrypt("World")
        print("Hello World -> " + encryption3)
        self.assertEqual(encryption3, "PUBVW") 
        
        encryption4 = cipher.encrypt("I")
        print("I -> " + encryption4)
        self.assertEqual(encryption4, "E") 

        encryption5 = cipher.encrypt("Am")
        print("Am -> " + encryption5)
        self.assertEqual(encryption5, "FY")
        
        encryption6 = cipher.encrypt("Finally")
        print("Finally -> " + encryption6)
        self.assertEqual(encryption6, "TESFVVM")
        
        encryption7 = cipher.encrypt("Done")
        print("Done -> " + encryption7)
        self.assertEqual(encryption7, "WUSA")
        
        encryption8 = cipher.encrypt("With")
        print("With -> " + encryption8)
        self.assertEqual(encryption8, "PEDK")
        
        encryption9 = cipher.encrypt("This")
        print("This -> " + encryption9)
        self.assertEqual(encryption9, "DKEG")
        
        encryption10 = cipher.encrypt("Homework")
        print("Homework -> " + encryption10)
        self.assertEqual(cipher.encrypt("Homework"), "KUYAPUBN")
    
    def test_decrpyt(self):
        cipher = MonoalphabeticCipher()
        cipher.key = "FOZWATCKEXNVYSUHQBGDLIPRMJ"
        print("\nDecrypy Tests")
        print("____________________")
        print("\nKey for Testing: " + cipher.key)
       
        decryption1 = cipher.decrypt("KAVVU PUBVW")
        print("KAVVU PUBVW -> Hello World")
        self.assertEqual(decryption1, "HELLO WORLD")       
        
        decryption2 = cipher.decrypt("KAVVU")
        print("KAVVU -> Hello")
        self.assertEqual(decryption2,"HELLO" ) 
        
        decryption3 = cipher.decrypt("PUBVW")
        print("PUBVW -> World")
        self.assertEqual(decryption3, "WORLD") 
        
        decryption4 = cipher.decrypt("E")
        print("E -> I")
        self.assertEqual(decryption4, "I") 

        decryption5 = cipher.decrypt("FY")
        print("FY -> Am")
        self.assertEqual(decryption5, "AM")
        
        decryption6 = cipher.decrypt("TESFVVM")
        print("TESFVVM ->Finally ")
        self.assertEqual(decryption6, "FINALLY")
        
        decryption7 = cipher.decrypt("WUSA")
        print("WUSA -> Done")
        self.assertEqual(decryption7, "DONE")
        
        decryption8 = cipher.decrypt("PEDK")
        print("PEDK -> With")
        self.assertEqual(decryption8, "WITH")
        
        decryption9 = cipher.decrypt("DKEG")
        print("DKEG -> This")
        self.assertEqual(decryption9, "THIS")
        
        decryption10 = cipher.decrypt("KUYAPUBN")
        print("KUYAPUBN -> Homework")
        self.assertEqual(decryption10, "HOMEWORK")
     
if __name__ == '__main__':
    unittest.main()
