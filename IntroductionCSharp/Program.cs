// See https://aka.ms/new-console-template for more information
//https://www.youtube.com/watch?v=9ITSbGZiHRo&list=PLGmYIROty-5Y6IpaO1KH9PvvGD9aiFiDl&index=6
using System;
namespace IntroductionCSharp
{

    class MainClass
    {
        public static void Main()
        {
            int num1 = 7;
            float num2 = 11.3f;///IN THE CONSOLE INPUT, FLOAT USE , INSTEAD OF .
            string name = "John";
            int option = 1;
            Console.WriteLine("Welcome " + name);

            while (option != 0)
            {


                Console.WriteLine("Choose an operation\n" +
                    "1) Sum two numbers\n" +
                    "2) Substract two numbers\n" +
                    "3) Multiply two numbers\n" +
                    "4) Divide two numbers\n" +
                    "5) First number raised to second number\n" +
                    "6) First number modulo second number\n" +
                    "0) exit: ");
                option = int.Parse(Console.ReadLine());
                if (option < 0 || option > 6)
                {
                    Console.WriteLine("You Moron that's not an option");
                }
                else if ((option > 0 && option <= 6))
                {
                    Console.WriteLine("\nPlease enter a first number (integer): ");
                    num1 = int.Parse(Console.ReadLine());

                    Console.WriteLine("\nPlease enter a second number (decimal): ");
                    num2 = float.Parse(Console.ReadLine());
                }



                if (option == 1)
                {
                    Console.WriteLine(num1 + " + " + num2 + " = " + (num1 + num2));
                }
                else if (option == 2)
                {
                    Console.WriteLine(num1 + " - " + num2 + " = " + (num1 - num2));
                }

                if (option != 1 && option != 2)
                {
                    switch (option)
                    {
                        case 3:
                            {
                                Console.WriteLine(num1 + " * " + num2 + " = " + (num1 * num2));
                            }
                            break;

                        case 4:
                            {
                                Console.WriteLine(num1 + " / " + num2 + " = " + (num1 / num2));
                            }
                            break;

                        case 5:
                            {
                                Console.WriteLine(num2 + " ^ " + num1 + " = " + Math.Pow(num2, num1));
                            }
                            break;

                        case 6:
                            {
                                Console.WriteLine(num1 + " % " + num2 + " = " + (num1 % (int)num2));
                            }
                            break;

                        case 0:
                            {
                                Console.WriteLine("THANKS FOR YOUR PREFERENCE");
                            }
                            break;

                        default:
                            {
                                Console.WriteLine("ERROR");
                            }
                            break;
                    }//switch
                }
            }

        }//MAIN

        
    }//CLASS

}


