package Ugadaiki;

import java.io.IOException; // Объявление утилиты, для использования метода очистки окна в консоли
import java.util.Scanner; // Объявление утилиты для использования ввода информации в консоль
import java.lang.Object;


public class MainApp
{
    static Scanner scanner;

    public static void main(String[] args)
    {
        scanner = new Scanner(System.in); // Задание сканера, считывающего информацию, вводиму в консоль
        clrScreen(); // Запуска метода очистки окна

        boolean firstShow = true;
        int numberTask = -1;
        boolean errInput = false;

        while (true)
        {
            if (numberTask != -1)
            {
                firstShow = false;
            }
            if (firstShow == true)
            {
                System.out.println("\nДобрый день!\nВашему вниманию предлагается домашняя работа №3\nстудента GeekBrains Хахалина Андрея Владимировича.\n");
                System.out.println("\nДомашнее задание включало в себя решение следующих задач:\n");
            }
            else
            {
                System.out.println("\nРешение какой следующей задачи Вы хотите проверить?\n");
            }
            System.out.println("1. Написать программу, которая загадывает случайное число от 0 до 9...");
            System.out.println("2. * Создать массив из слов String[] words = {\"apple\", \"orange\",...");
            if ((Math.abs(numberTask) > 2) || (errInput == true))
            {
                System.out.print("\nВАЖНО: Нужно ввести одну из цифр 0, 1 или 2. Знак точки \".\" вводить не нужно.\nПожалуйста, попробуйте ввести цифру ещё раз.\n");
            }
            System.out.print("\nУкажите НОМЕР ЗАДАЧИ для проверки (0 - для ВЫХОДА из программы): ");

            if (scanner.hasNextInt() || scanner.hasNextFloat())
            {
                if (scanner.hasNextInt())
                {
                    numberTask = Math.abs(scanner.nextInt());
                }
                else
                {
                    numberTask = Math.abs(Math.round(scanner.nextFloat()));
                }

                switch (numberTask)
                {
                    case 0:
                        clrScreen();
                        System.out.println("\nСпасибо Вам за потраченное время!\nЖелаю хорошего дня.");
                        return;
                    case 1:
                        errInput = false;
                        firstShow = false;
                        clrScreen();
                        task1();
                        break;
                    case 2:
                        errInput = false;
                        firstShow = false;
                        clrScreen();
                        task2();
                        break;
                    default:
                        errInput = true;
                        clrScreen(); // Запуска метода очистки окна
                }
            }
            else
            {
                errInput = true;
                scanner.next();
                clrScreen(); // Запуска метода очистки окна
            }
        }
        // КАК ЗАКРЫТЬ ОТКРЫТЫЙ СКАНЕР
        // scanner.close(); - команда выдает сообщение об ошике "Delete unreachable statement"
    }

    //region Задача  №1
    // 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки  угадать это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша выводится запрос - "Повторить игру еще раз? 1 - да / 0 - нет" (1 - повторить, 0 - нет).
    public static void task1()
    {
        System.out.println("\nЗАДАНИЕ №1");
        System.out.println("Написать программу, которая загадывает случайное число от 0 до 9\nи пользователю дается 3 попытки  угадать это число.\nПри каждой попытке компьютер должен сообщить,\nбольше ли указанное пользователем число, чем загаданное, или меньше.\nПосле победы или проигрыша выводится запрос -\n\"Повторить игру еще раз? 1 - да / 0 - нет\"\n(1 - повторить, 0 - нет).\n\n");
        System.out.println("РЕШЕНИЕ:\n");

    }
    //endregion

    //region Задача №2
    // 2. * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}. При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах. apple - загаданное, apricot - ответ игрока ap############# (15 символов, чтобы пользователь не мог узнать длину слова). Для сравнения двух слов посимвольно можно пользоваться: String str = "apple"; char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции. Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
    public static void task2()
    {
        System.out.println("\nЗАДАНИЕ №2");
        System.out.println("* Создать массив из слов String[] words = {\"apple\", \"orange\", \"lemon\",\n\"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\",\n\"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\",\n\"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"}.\nПри запуске программы компьютер загадывает слово, запрашивает ответ\nу пользователя, сравнивает его с загаданным словом и сообщает,\nправильно ли ответил пользователь. Если слово не угадано,\nкомпьютер показывает буквы, которые стоят на своих местах.\napple - загаданное, apricot - ответ игрока ap#############\n(15 символов, чтобы пользователь не мог узнать длину слова).\nДля сравнения двух слов посимвольно можно пользоваться:\nString str = \"apple\"; char a = str.charAt(0); - метод, вернет char,\nкоторый стоит в слове str на первой позиции.\nИграем до тех пор, пока игрок не отгадает слово.\nИспользуем только маленькие буквы.\n\n");
        System.out.println("РЕШЕНИЕ:\n");

    }
    //endregion

    //region Метод очистки консольного окна
    public static void clrScreen() // Очистка консольного окна
    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex)
        {
        }
    }
    //endregion

}
