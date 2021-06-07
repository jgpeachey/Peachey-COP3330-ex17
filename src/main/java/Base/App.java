/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 John Peachey
 */

package Base;

/*
Create a program that prompts for your weight, gender, number of drinks,
the amount of alcohol by volume of the drinks consumed (as a percent), and
the amount of time since your last drink. Calculate your blood alcohol
content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H
where:
A = (number of drinks * alcohol by volume) is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.
Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output:
Your BAC is 0.08
It is not legal for you to drive.

Constraint:
Prevent the user from entering non-numeric values.

Challenges:
*Handle metric units.
*Look up the legal BAC limit by state and prompt for the state. Display a
message that states whether or not it’s legal to drive based on the
computed BAC.
*Develop this as a mobile application that makes it easy to record each
drink, updating the BAC each time a drink is entered.
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    static double isNumber(){
        int i = 1;
        double input = 0;
        boolean honest = in.hasNextDouble();
        while(i == 1){
            if(honest){
                input = in.nextDouble();
                i = 0;
            }
            else{
                System.out.println("Please enter a number.");
                in.next();
                honest = in.hasNextDouble();
            }
        }
        return input;
    }


    public static void main(String[] args) {

        double bac;
        int i = 1;

        System.out.println("What is your weight?");
        double weight = isNumber();
        System.out.println("What is your gender (male = 1 female = 2)?");
        double gender = isNumber();

        while(i == 1){
            if(gender == 1 || gender == 2){
               i = 0;
            }
            else{
                System.out.println("Please enter 1 or 2.");
                gender = isNumber();
            }
        }

        System.out.println("What is the number of drinks you have had?");
        double nod = isNumber();
        System.out.println("What is the amount of alcohol by volume of the drinks consumed (as a percent)?");
        double abv = isNumber();
        System.out.println("What is the amount of time since your last drink (in hours)?");
        double time = isNumber();

        if(gender == 1.0) {
            bac = ((nod * abv) * (5.14/weight)*0.73)-(0.015*time);
        }
        else{
            bac = Math.round((((nod * abv) * (5.14/weight)*0.66)-(0.015*time))*100.0)/100.0;
        }

        System.out.println("Your BAC is "+bac);
        if(bac < 0.08){
            System.out.println("It is legal for you to drive.");
        }
        else{
            System.out.println("It is not legal for you to drive.");
        }
    }
}
