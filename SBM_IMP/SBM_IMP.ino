#include<String.h>
#include <SoftwareSerial.h>

SoftwareSerial mySerial(D5, D6); // RX, TX
String  R1= "";
String  R2= "";
String  R3= "";
String  R4= "";
int ind1; // locations
int ind2;
int ind3;
int ind4;
int ind5;
int inds;
String readString;        //main captured String
String flag;
const int ledgreen = D2;     
const int ledyellow = D1; 
int count = 0;        
char c; 
String RFID;
void setup() 
{  
    pinMode(ledgreen, OUTPUT);
 
  pinMode(ledyellow, OUTPUT);
  Serial.begin(9600);
 mySerial.begin(9600);
 char ch = Serial.read();
  while(ch != '#')
  {
    mySerial.println("waiting for Data");
    ch = mySerial.read();
  }
  
    StoreData();
}

void StoreData() 
{ 
  while(mySerial.available())
  {
  if (mySerial.available())  //Expected string from serial input (1,U1, U2,U3 ,U4*)
  { mySerial.println("waiting for Data....");
    char c = mySerial.read();  //gets one byte from serial buffer
    if (c == '*') 
    {mySerial.println("Hello");
      mySerial.println(readString);
      ind1 = readString.indexOf(',');         //finds location of first ,
      flag = readString.substring(0, ind1);   //captures first data String
      if (flag.toInt() == 1)                  // flag 0 indicates user data from remote side and parses the information
      {
        ind2 = readString.indexOf(',', ind1+1 );   //finds location of second ,
        R1 = readString.substring(ind1+1, ind2);   mySerial.println('1' + R1);//captures second data String
        ind3 = readString.indexOf(',', ind2+1 );
        R2 = readString.substring(ind2+1,ind3);    mySerial.println('2' + R2);
        ind4 = readString.indexOf(',', ind3+1 );//captures second data String
        R3 = readString.substring(ind3+1,ind4);    mySerial.println('3' + R3);
        ind5 = readString.indexOf(',', ind4+1 );//captures second data String
        inds = readString.indexOf('*');
        R4 = readString.substring(ind4+1,inds);    mySerial.println('4' + R4);
        readString=""; 
        flag="";
        delay(1000);
        break;
        //c='*';    
      }
      else
      {
        readString=""; //clears variable for new input
        flag="";
      }
    } 
    else if (c == ':') 
    {
      readString="";
    }
    else
    {     
      readString += c; //makes the string readString
    }
  }
  }
}
  
void loop()
{       
  if(Serial.available())
  {
    count = 0; 
    
    while(Serial.available() && count < 12) 
    {
      c = Serial.read(); 
      count++;
      delay(5);
      RFID += c;
    }
    mySerial.println(RFID); 
    Detect_RFID();
    RFID="";
    
  }
}

void Detect_RFID()
{
  while(RFID!="")
  {
    if (RFID.equals(R1)) 
    {
      digitalWrite(ledgreen,HIGH);
      digitalWrite(ledyellow,LOW);
      delay(1000);
      digitalWrite(ledgreen,LOW);
      break;
    } 
    else if (RFID.equals(R2)) 
    {
      digitalWrite(ledgreen,HIGH);
      digitalWrite(ledyellow,LOW);
      delay(1000);
      digitalWrite(ledgreen,LOW);
      break;
    } 
    else if (RFID.equals(R3)) 
    {
      digitalWrite(ledgreen,HIGH);
      digitalWrite(ledyellow,LOW);
      delay(1000);
      digitalWrite(ledgreen,LOW);
      break;
    } 
    else if (RFID.equals(R4)) 
    {
      digitalWrite(ledgreen,HIGH);
      digitalWrite(ledyellow,LOW);
      delay(1000);
      digitalWrite(ledgreen,LOW);
      break;
    } 
    else 
    {
      digitalWrite(ledgreen,LOW);
      digitalWrite(ledyellow, HIGH); 
      delay(1000);
      digitalWrite(ledyellow, LOW); 
    }
  }
  
}
