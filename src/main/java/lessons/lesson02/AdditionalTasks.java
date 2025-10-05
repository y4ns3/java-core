package lessons.lesson02;

import java.util.Random;
import java.util.Scanner;

public class AdditionalTasks {

    // меняет местами 2 числа
    public void swapNumbers(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a and b: ");
        int a=sc.nextInt();
        int b=sc.nextInt();

        System.out.println("initial values: a=" + a + " b=" + b);

        // меняем числа местами
        int temp = a;
        a = b;
        b = temp;

        System.out.println("new values: a=" + a + " b=" + b);
        sc.close();
    }

    // конвертирует доллары в суммы, не хорошо считать деньги в float/double, это учебный пример :)
    public void converter(){
        // 1 доллар в суммах
        double dollarPerSum = 12500.00;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a value in dollar: ");
        double dollars =sc.nextDouble();

        double sum = dollarPerSum * dollars;
        System.out.println(dollars + " in sum is :" + sum);
        sc.close();
    }
    // чётное или нечётное
    public void oddOrEven(){
        final int EVEN_DEVISOR = 2;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number=sc.nextInt();
        if(number%EVEN_DEVISOR==0){
            System.out.println("The number is even");
        }else{
            System.out.println("The number is odd");
        }
        sc.close();
    }

    // функция которая определяет максимальное число
    public void largestNumber(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number1: ");
        int number1=sc.nextInt();
        System.out.println("Enter a number2: ");
        int number2=sc.nextInt();
        System.out.println("Enter a number3: ");
        int number3=sc.nextInt();

        if(number1>number2 && number1>number3){
            System.out.println("The largest number is "+number1);
        }
        else if(number2>number1 && number2>number3){
            System.out.println("The largest number is "+number2);
        }else {
            System.out.println("The largest number is "+number3);
        }
        sc.close();
    }
    // мини калькулятор
    public void calculator(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number1: ");
        int number1 = sc.nextInt();
        System.out.println("Enter a number2: ");
        int number2 = sc.nextInt();

        System.out.println("Enter operator (+,-,*,/): ");
        char operator =  sc.next().charAt(0);
        if(operator=='+'){
            int result = number1 + number2;
            System.out.println("result is: "+result);
        }else if(operator=='-'){
            int result = number1 - number2;
            System.out.println("result is: " +result);
        }else if(operator=='*'){
            int result = number1 * number2;
            System.out.println("result is: "+result);
        }else if(operator=='/'){
            if(number2==0){
                System.out.println("cannot divide by zero");
                return;
            }
            int result = number1 / number2;
            System.out.println("result is: "+result);
        }

        sc.close();
    }

    // среднее арифметическое число
    public void meanValue(){
        Scanner sc=new Scanner(System.in);

        //кол-во элементов массива
        System.out.println("Enter a number: ");
        int number=sc.nextInt();
        int[] arr = new int[number];

        for(int i=0;i<number;i++){
            //System.out.println("Enter a number: ");
            arr[i]=sc.nextInt();
        }
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        int mean = sum/number;
        System.out.println("mean is: "+mean);

        sc.close();
    }

    // функция которая ищет число в массиве
    public boolean numberExistsInArray(int[] arr,int n){
        for(int i:arr){
            if(arr[i]==n){
                return true;
            }
        }
        return false;
    }

    // мини игра в которой пользователь пытается угадать рандомное число
    public void guessNumber(int numberOfAttempts){
        Random rand=new Random();
        final int MAX_VALUE = 100;// максимальное число 100 (для примера)
        int number=rand.nextInt(MAX_VALUE) + 1;// от 1 до 100
        int counter = 1;

        Scanner sc=new Scanner(System.in);
        while(counter<numberOfAttempts){
            System.out.println(numberOfAttempts+" attempts left");
            int value = sc.nextInt();
            if(value==number){
                System.out.println("you won ");
            }else{
                --numberOfAttempts;
            }
        }
        System.out.println("The number is "+number);
    }
}
