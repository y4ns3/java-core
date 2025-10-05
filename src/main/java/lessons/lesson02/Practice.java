package lessons.lesson02;

import java.util.Scanner;

public class Practice {
    // функция которая выводит числа от 1 до 100, по 10 чисел в строке
    public void printNumbers(){
        final int NUMBERS_PER_LINE = 10;

        for(int i = 1;i<=100;++i){
            System.out.print(i + " ");

            // после каждого 10-го числа делается перенос
            if(i % NUMBERS_PER_LINE==0){
                System.out.print('\n');
            }
        }
    }

    // выводит сумму чисел от 1 до n
    public void sumOfNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = sc.nextInt();
        if(number < 0){
            System.out.println("Invalid number");
            return;
        }
        int sum = 0;
        for(int i = 1;i<=number;++i){
            sum += i;
        }
        System.out.println("The sum is " + sum);
        sc.close();
    }

    // произведение чисел от 1 до n
    public void productOfNumbers(int n){
        int product = 1;
        for(int i = 1;i<=n;++i){
            product *= i;
        }
        System.out.println("The product is " + product);
    }

    // Сумма чётных чисел
    public void sumOfEvenNumbers(int n){

        if(n < 0){
            System.out.println("Invalid number");
            return;
        }
        int sum = 0;
        for(int i = 1;i<=n;++i){
            if(i%2==0){
                sum += i;
            }
        }
        System.out.println("The sum of even numbers is " + sum);
    }

    // сумма цифр из числа
    public void sumOfDigits(int number){
        int sum = 0;
        while(number!=0){
            sum += number%10;
            number/=10;
        }
        System.out.println("The sum is " + sum);
    }

    // функция которая выводит число в обратном порядке
    public void reverseNumbers(int number){
        int reversedNumber = 0;
        while(number!=0){
            reversedNumber = reversedNumber * 10 + number % 10;
            number/=10;
        }
        System.out.println("The reversed number is " + reversedNumber);
    }

    // факториал числа n
    public void factorial(int n){
        int factorial = 1;
        while(n!=1){
            factorial = factorial * n;
            --n;
        }
        System.out.println("Factorial is " + factorial);
    }

    /*
    функция выводит первое число, которое делится на 7 без остатка
    и больше 1000
    */
    public void firstDevisibleBy7Over1000(){
        final int START = 1001;
        final int DIVISOR = 7;

        int number = START;

        while(number % DIVISOR !=0){
            ++number;
        }
        System.out.println("first number divisible by 7 and over 1000 is :" + number);
    }

    // простые числа до N
    public void primeNumbers(int n){
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }

    // функция которая рисует триугольники
    public void triangle(int n){

        // первый треугольник
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.print('\n');
        }

        // второй треугольник
        for(int i = 1; i <= n; i++){
            for(int j = n-i; j >=0; j--){
                System.out.print("*");
            }
            System.out.print('\n');
        }
    }
}



