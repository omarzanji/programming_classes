#include <stdio.h>
#include <math.h>

char nameOfMetal();

double diameterOfWire();

double lengthOfWire();

double areaOfWire();

double resistanceOfWire();

int main()
{
   char metalName;
   metalName = nameOfMetal();
   double diameterWire; 
   diameterWire = diameterOfWire();
   double wireLength
   wireLength = lengthOfWire();
   double wireArea
   wireArea = areaOfWire();
    




}


char nameOfMetal()
{  
   char metal;
   printf("Enter the name of the metal\n");
   scanf("%s", &metal);
   return metal;
}

double diameterOfWire()
{
   double diameter
   printf("Enter the diameter of the wire\n");
   scanf("%lf", &diameter);
   return diameter;

}
double lengthOfWire()
{
   double length;
   printf("Enter the length of the wire\n");
   scanf("%lf", &length);
   return length;

}
double areaOfWire()
{
   double radius
   radius = diameter /2;
   pow(radius, 2)* M_PI;
      
}