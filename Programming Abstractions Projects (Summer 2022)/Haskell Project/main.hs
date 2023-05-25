    import Data.Bits 
    import Data.List
    import Data.Char
    import Data.Maybe
    
    randomArray = 25: 17: 10: 3: 3: 24: 13: 17: 3: 21: 25: 22: 15: 8: 22: 5: 3: 11: 22: 19: 14: 17: 0: 22: 7: 16: 20: 6: 11: 20: 5: 1: 12: 24: 2: 17: 3: 22: 14: 13: 12: 12: 2: 25: 20: 2: 14: 19: 9: 3: 1: 13: 4: 7: 21: 2: 23: 19: 17: 19: 13: 24: 20: 9: 8: 2: 19: 21: 4: 20: 23: 22: 12: 20: 4: 18: 4: 13: 23: 1: 20: 1: 1: 4: 21: 14: 22: 19: 13: 22: 18: 8: 2: 4: 24: 17: 5: 25: 15: 19: 4: 23: 2: 10: 25: 23: 17: 4: 15: 25: 11: 7: 4: 7: 20: 9: 11: 14: 19: 1: 15: 17: 19: 23: 20: 11: 0: 3: 13: 23: 22: 17: 7: 9: 24: 25: 7: 20: 2: 9: 11: 20: 18: 15: 18: 23: 19: 3: 0: 9: 5: 10: 17: 2: 1: 22: 9: 17: 9: 1: 13: 5: 3: 1: 20: 21: 18: 19: 4: 17: 20: 20: 25: 17: 9: 7: 4: 19: 8: 3: 5: 1: 7: 21: 16: 17: 14: 24: 6: 10: 5: 20: 25: 4: 11: 19: 5: 5: 17: 7: []
  
    convertDecToBin :: Integer -> String
    convertDecToBin 0 = ""
    convertDecToBin dec 
     | dec `mod` 2 == 1 =  
     "1" ++ 
     convertDecToBin (dec `div` 2)
     | dec `mod` 2 == 0 = 
     "0" ++ 
     convertDecToBin (dec `div` 2)
    
    cDTPadding :: String -> String  
    cDTPadding unpadded = 
     let unpaddedLength = length (unpadded)
         numZeros = 8 - unpaddedLength 
    
     in (replicate numZeros '0') ++ unpadded
    
    --127.0.0.1
    ipATNHelper :: String -> String
    ipATNHelper "" = ""
    ipATNHelper unParsedIP =
     let (x,y) = span (isNotDot) unParsedIP
     in cDTPadding(convertDecToBin (read x)) ++ ipATNHelper (drop 1 y)
     where
      isNotDot :: Char -> Bool
      isNotDot c = (c /= '.') 
    
    --1000
    convertBinToDec :: String -> Integer
    convertBinToDec "" = 0
    convertBinToDec bin = 
     let a = length(bin)-1
     in (read [head(bin)] * (2^a)) + convertBinToDec(tail(bin))
     
    ipAddressToNum :: String -> Integer
    ipAddressToNum address =
     convertBinToDec (ipATNHelper (address))
    
    numToIpAddress :: Integer -> String
    numToIpAddress input = show first ++ "." ++ show second ++ "." ++ show third ++ "." ++ show fourth 
     where 
      fourth = (.&.) input 0xFF 
      third = (.&.) (shiftR input 8) 0xFF
      second = (.&.) (shiftR input 16) 0xFF
      first = (.&.) (shiftR input 24) 0xFF
    
    removeElement :: String -> Int -> String
    removeElement unalteredString index = 
    -- "ABCD" -> "AB" "CD"
     let (x,y) = splitAt index unalteredString
     in x ++ tail y 
     
     
     --select one of the elements out of the originalAlphabet. Using random array 
     -- select one of the elements in originalAlphabet and move it to 
     -- inProgressAlphabet
     
    generateKeyHelper :: String -> String -> [Int] -> String
    generateKeyHelper "" inProgressAlphabet _ = inProgressAlphabet
    generateKeyHelper originalAlphabet inProgressAlphabet randomArray =
     let index = head randomArray `mod` length (originalAlphabet)
     in generateKeyHelper (removeElement originalAlphabet index) 
         ((originalAlphabet !! index) : inProgressAlphabet)
         (tail randomArray) 
        
    generateKey :: String
    generateKey =
     generateKeyHelper(alphabet)("")(randomArray)   
   
    toUppercase :: String -> String 
    toUppercase = map toUpper
    
    alphabet :: String 
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    
    decryptLetter :: String -> Char -> Char
    decryptLetter key firstCypherLetter = 
     alphabet !! (fromJust (elemIndex firstCypherLetter key))
     
    
    decrypt :: String -> String -> String
    decrypt key cypherText = 
     map (\x -> if isAlpha x then (decryptLetter key x) else x) (toUppercase cypherText)
      -- map (func -> list) takes every element of the list, calls function on that element
      -- and returns a list of the results
      
    encryptLetter :: String -> Char -> Char
    encryptLetter key firstDecryptLetter =
     key !! (fromJust (elemIndex firstDecryptLetter alphabet))
     
    encrypt :: String -> String -> String
    encrypt key plainText =
     map (\x -> if isAlpha x then (encryptLetter key x) else x) (toUppercase plainText)
   
   
    main :: IO () 
    main =
     do
      putStrLn $ "Key: " ++ show generateKey
      putStrLn $ "IP: " ++ show (numToIpAddress 2130706433)
      putStrLn $ "Address: " ++ show (ipAddressToNum "127.0.0.1")
      putStrLn $ "IP2: " ++ show (numToIpAddress 4294967295)
      putStrLn $ "Address2: " ++ show (ipAddressToNum "255.255.255.255")
      putStrLn $ "Encrypt: " ++ show (encrypt generateKey "Hello World")
      putStrLn $ "Decrypt: " ++ show (decrypt generateKey "VOWWN DNGWA")
      putStrLn $ "Encrypt: " ++ show (encrypt generateKey "A long time ago, in a galaxy far, far away... It is a dark time for the Rebellion. Although the Death Star has been destroyed, Imperial troops have driven the Rebel forces from their hidden base and pursued them across the galaxy. Evading the dreaded Imperial Starfleet, a group of freedom fighters led by Luke Skywalker has established a new secret base on the remote ice world of Hoth. The evil lord Darth Vader, obsessed with finding young Skywalker, has dispatched thousands of remote probes into the far reaches of space")
      putStrLn $ "Decrypt: " ++ show (decrypt generateKey "C WNBU SHTO CUN, HB C UCWCKR LCG, LCG CDCR... HS HX C ACGM SHTO LNG SVO GOYOWWHNB. CWSVNFUV SVO AOCSV XSCG VCX YOOB AOXSGNROA, HTPOGHCW SGNNPX VCEO AGHEOB SVO GOYOW LNGQOX LGNT SVOHG VHAAOB YCXO CBA PFGXFOA SVOT CQGNXX SVO UCWCKR. OECAHBU SVO AGOCAOA HTPOGHCW XSCGLWOOS, C UGNFP NL LGOOANT LHUVSOGX WOA YR WFMO XMRDCWMOG VCX OXSCYWHXVOA C BOD XOQGOS YCXO NB SVO GOTNSO HQO DNGWA NL VNSV. SVO OEHW WNGA ACGSV ECAOG, NYXOXXOA DHSV LHBAHBU RNFBU XMRDCWMOG, VCX AHXPCSQVOA SVNFXCBAX NL GOTNSO PGNYOX HBSN SVO LCG GOCQVOX NL XPCQO")
