namespace IntroductionCSharp
{
    class Class1
    {

        public static void Main()
        {
            int n = 5;

            for (int i = 1; i <= n; i++)//5 rows
            {
                for (int j = 1; j <= i; j++)
                {
                    //Console.WriteLine(j + " "); //adds \n
                    //Console.Write(j + " ");//does not add \n
                    
                }
                Console.Write("\n");
            }

            for (int i = n-1;  i >= 1; i--){
                for (int j = 1; j <= i; j++)
                {
                    Console.Write(j + " ");
                }
                Console.Write("\n");
            }

            
        }

    }
}
