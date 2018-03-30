void setup() {
Serial.begin(115200);
Serial.println("Hello World");

}

void loop() {
int pubg =123;
double level =12.3;
Serial.print("[");
Serial.print(level);
Serial.print("|");
Serial.print(pubg);
Serial.print("]");
Serial.print("");
delay(1000);
}
