 /*
  *
  * Project Name:   Smart Bus Mangement
  * Author List:    Ojas Khamkar, Siddharth Shrivastava,Rajeshwari Kaushal 
  * Filename:     SBMversion1
  * Functions:    StoreData, Waitfetch,DetectRFID, ReadRFID, Connection, FetchData
  * Global Variables: R1-R20,ind1-ind21,inds,readstring, flag,ssid, pass, mac, RFID, c ,count,query, result.
  *
  */

#include <MySQL_Connection.h>
#include <MySQL_Cursor.h>
#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include<String.h>
#include <SoftwareSerial.h>


SoftwareSerial mySerial(D5, D6); // RX, TX
String  R1= "";
String  R2= "";
String  R3= "";
String  R4= "";
String  R5= "";
String  R6= "";
String  R7= "";
String  R8= "";
String  R9= "";
String  R10= "";
String  R11= "";
String  R12= "";
String  R13= "";
String  R14= "";
String  R15= "";
String  R16= "";
String  R17= "";
String  R18= "";
String  R19= "";
String  R20= "";

int ind1; // locations
int ind2;
int ind3;
int ind4;
int ind5;
int ind6;
int ind7;
int ind8;
int ind9;
int ind10;
int ind11;
int ind12;
int ind13;
int ind14;
int ind15;
int ind16;
int ind17;
int ind18;
int ind19;
int ind20;
int ind21;

int inds;

String readString;        //main captured String
String flag;
const int ledgreen = D2;     
const int ledred = D1; 
int count = 0;        
char c; 
String RFID;

char ssid[] = "Mm";                 // Network Name
char pass[] = "12345678";                 // Network Password
byte mac[6];
const int bus=1;
WiFiServer server(80);
IPAddress ip;

WiFiClient client;
MySQL_Connection conn((Client *)&client);   //Sql connection
char conn_database[] = "USE bjnofkkacvj1c1n7movt";          //Database name Use Database
char getvalue[] = "SELECT * FROM bus_det where bus_no= %d";
IPAddress server_addr(54,39,75,7); //db sserver address

char user[] = "uraoq120p1txr6ld";           // MySQL user
char password[] = "ODYOpWMmy3iDpHFwtuUn";       // MySQL password

char query[100];
String result;
void setup()
{
  pinMode(ledgreen, OUTPUT);
  pinMode(ledred, OUTPUT);
  Serial.begin(9600);
  mySerial.begin(9600);
  connection();
  waitFetch();
  storeData();
  
}
void loop()
{
  readRFID();
}

/*
*
* Function Name:   storeData()
* Input:    -
* Output:   -
* Logic:    Stores data fetched from the database related with RFID details of Booked seats.
* Example Call:  readRFID();
*
*/

void storeData() 
{ int i=1;
  while(result!="")
  {
  if (result!="")  //Expected string from serial input (1,U1, U2,U3 ,U4*)
  { //mySerial.println("waiting for Data....");
    char c = result.charAt(i);++i;  //gets one byte from result String
    if (c == '*') 
    {mySerial.println("Hello");
      mySerial.println(readString);
      mySerial.println("Hello1");
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
/*
*
* Function Name:   waitFetch()
* Input:    -
* Output:   -
* Logic:    Waits till the server is connected to the server or database.
* Example Call:  waitFetch();
*
*/
void waitFetch()
{
  fetchData();
  char ch = result.charAt(0);
  while(ch != '#')
  {
    mySerial.print("waiting for Data");
    delay(500);
    mySerial.print(".");
    delay(500);
    mySerial.print(".");
    delay(500);
    mySerial.print(".");
    delay(500);
    ch = result.charAt(0);
  }
  
}
/*
*
* Function Name:   connection()
* Input:    -
* Output:   -
* Logic:    Establishes connection between the NodeMCU and SQL Database using Wifi
* Example Call:  connection();
*
*/
void connection()
{
  mySerial.println("Initialising connection:");
  mySerial.print(F("Setting static ip to : "));
  mySerial.println(ip);
  mySerial.println("");
  mySerial.println("");
  mySerial.print("Connecting to : ");
  mySerial.println(ssid);
  WiFi.begin(ssid, pass);

  while (WiFi.status() != WL_CONNECTED) {
    delay(200);
    mySerial.print(".");
  }

  mySerial.println("");
  mySerial.println("WiFi Connected:");

  WiFi.macAddress(mac);
  mySerial.print("MAC: ");
  mySerial.print(mac[5], HEX);
  mySerial.print(":");
  mySerial.print(mac[4], HEX);
  mySerial.print(":");
  mySerial.print(mac[3], HEX);
  mySerial.print(":");
  mySerial.print(mac[2], HEX);
  mySerial.print(":");
  mySerial.print(mac[1], HEX);
  mySerial.print(":");
  mySerial.println(mac[0], HEX);
  mySerial.println("");
  mySerial.print("Assigned IP: ");
  mySerial.print(WiFi.localIP());
  mySerial.println("");

  mySerial.println("Connecting to database");
  mySerial.println(server_addr);

  while (conn.connect(server_addr, 3306, user, password) != true) {
    delay(200);
    mySerial.print ( "." );
  }
  mySerial.println("");
  mySerial.println("Connected to SQL Server!");
  sprintf(query, conn_database );
  mySerial.println("Connecting Database");
  mySerial.println(query);
  MySQL_Cursor *cur_mem = new MySQL_Cursor(&conn); //Establishing connection
  cur_mem->execute(query);
  sprintf(query, conn_database);                        //Selecting Database
  cur_mem->execute(query);
  delete cur_mem;
}
/*
*
* Function Name:   fetchData
* Input:    -
* Output:   -
* Logic:    Generates query to SQL database to fetch details of Booked seats from the server
* Example Call:  fetchData();
*
*/
void fetchData(){
  MySQL_Cursor *cur_mem = new MySQL_Cursor(&conn);
  // Execute the query
  sprintf(query,getvalue,bus);
  cur_mem->execute(query);
  // Fetch the columns and print them
  column_names *cols = cur_mem->get_columns();
  mySerial.println();
  // Read the rows and print them
  row_values *row = NULL;
  result+="#";
  result+=bus; 
  do {
    row = cur_mem->get_next_row();
    if (row != NULL) {
       result+=",";
       result+=row->values[1];        
        }
  } while (row != NULL);
  result+="*";
  mySerial.println(result);
  // Deleting the cursor also frees up memory used
  delete cur_mem;
  }
  
/*
*
* Function Name:   readRFID()
* Input:    -
* Output:   -
* Logic:    Scans the serial port to fetch RFID card details and prints on Software serial
* Example Call:  readRFID();
*
*/
void readRFID()
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
/*
*
* Function Name:   Detec_RFID()
* Input:    -
* Output:   -
* Logic:    Checks the validity RFID cards againts the data fed in R1-R20
* Example Call:  Detect_RFID();
*
*/
void Detect_RFID()
{
  while(RFID!="")
  {
    if (RFID.equals(R1)||RFID.equals(R2)||RFID.equals(R3)||RFID.equals(R4)||RFID.equals(R5)||RFID.equals(R6)||RFID.equals(R7)||RFID.equals(R8)||RFID.equals(R9)||RFID.equals(R10)||RFID.equals(R11)||RFID.equals(R12)||RFID.equals(R13)||RFID.equals(R14)||RFID.equals(R15)||RFID.equals(R16)||RFID.equals(R17)||RFID.equals(R18)||RFID.equals(R19)||RFID.equals(R20)) 
    {
      digitalWrite(ledgreen,HIGH);
      delay(500);
      digitalWrite(ledred,LOW);
      delay(1000);
      digitalWrite(ledgreen,LOW);
      break;
    }
      else 
    {
      digitalWrite(ledgreen,LOW);
      delay(500);
      digitalWrite(ledred, HIGH); 
      delay(1000);
      digitalWrite(ledred, LOW); 
      break;
    }
  }
  
}
