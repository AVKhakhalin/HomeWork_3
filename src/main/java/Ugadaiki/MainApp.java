package Ugadaiki;

import java.io.IOException; // Объявление утилиты, для использования метода очистки окна в консоли
import java.util.Scanner; // Объявление утилиты для использования ввода информации в консоль
import java.util.Random;


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
            if ((numberTask != -1) && (errInput == false))
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

            if (scanner.hasNextInt())
            {
                numberTask = scanner.nextInt();

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

        Random rand = new Random ();
        int number;
        int answerNumber;
        int caseAnswer = 1;
        boolean errorInput = false;

        number = rand.nextInt( 9 );
        while(true)
        {
            System.out.println("Попробуйте угадать загаданное число от 0 до 9 за 3 попытки. Удачи!");
            while (true)
            {
                if (errorInput == true)
                {
                    System.out.print("\nЗагаданное число (введите число от 0 до 9 без точки) = ");
                }
                else
                {
                    System.out.print("\nПОПЫТКА №" + caseAnswer + "\nЗагаданное число (введите число от 0 до 9 без точки) = ");
                }
                if (scanner.hasNextInt())
                {
                    answerNumber = scanner.nextInt();

                    if ((answerNumber >= 0) && (answerNumber <= 9))
                    {
                        if (answerNumber == number)
                        {
                            errorInput = false;
                            if (caseAnswer == 1)
                            {
                                System.out.println("\nВЫ ОТГАДАЛИ С 1 ПОПЫТКИ! НАВЕРНОЕ, ВЫ ПРОВИДЕЦ 100-ГО УРОВНЯ.\n");
                            }
                            else
                            {
                                System.out.println("\nПОЗДРАВЛЯЮ! ВЫ УГАДАЛИ!\n");
                            }
                            caseAnswer = 1;
                            break;
                        }
                        else
                        {
                            caseAnswer++;
                            errorInput = false;
                            if (answerNumber > number)
                            {
                                System.out.println("Нет. Загаданное число МЕНЬШЕ Вашего числа.");
                            }
                            else
                            {
                                System.out.println("Нет. Загаданное число БОЛЬШЕ Вашего числа.");
                            }
                            if (caseAnswer > 3)
                            {
                                System.out.println("\nВам НЕ УДАЛОСЬ ОТДГАДАТЬ число " + number + ". Исчерпаны все попытки.\n");
                                caseAnswer = 1;
                                break;
                            }
                        }
                    }
                    else
                    {
                        errorInput = true;
                        System.out.println("Нужно вводить только цифры от 0 до 9. Попробуйте ещё раз.");
                    }
                }
                else
                {
                    errorInput = true;
                    System.out.println("Нужно вводить только цифры от 0 до 9. Попробуйте ещё раз.");
                    scanner.next();
                }
            }
            answerNumber = -1;
            while ((answerNumber != 1) && (answerNumber != 0))
            {
                System.out.print("Повторить игру еще раз? (1 - да / 0 - нет): ");
                if (scanner.hasNextInt())
                {
                    answerNumber = scanner.nextInt();

                    if ((answerNumber != 0) && (answerNumber != 1))
                    {
                        System.out.println("Нужно вводить только цифры 0 и 1. Попробуйте ещё раз.\n");
                    }
                }
                else
                {
                    System.out.println("Нужно вводить только цифры от 0 до 1. Попробуйте ещё раз.\n");
                    scanner.next();
                }
            }
            if (answerNumber == 0)
            {
                System.out.println("\n\nСпасибо Вам за игру!");
                break;
            }
            else
            {
                clrScreen();
                System.out.println("\nЗАДАНИЕ №1");
                System.out.println("Написать программу, которая загадывает случайное число от 0 до 9\nи пользователю дается 3 попытки  угадать это число.\nПри каждой попытке компьютер должен сообщить,\nбольше ли указанное пользователем число, чем загаданное, или меньше.\nПосле победы или проигрыша выводится запрос -\n\"Повторить игру еще раз? 1 - да / 0 - нет\"\n(1 - повторить, 0 - нет).\n\n");
                System.out.println("РЕШЕНИЕ:\n");
                number = rand.nextInt( 9 );
            }
        }
    }
    //endregion

    //region Задача №2
    // 2. * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}. При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах. apple - загаданное, apricot - ответ игрока ap############# (15 символов, чтобы пользователь не мог узнать длину слова). Для сравнения двух слов посимвольно можно пользоваться: String str = "apple"; char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции. Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
    public static void task2()
    {
        System.out.println("\nЗАДАНИЕ №2");
        System.out.println("* Создать массив из слов String[] words = {\"apple\", \"orange\", \"lemon\",\n\"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\",\n\"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\",\n\"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"}.\nПри запуске программы компьютер загадывает слово, запрашивает ответ\nу пользователя, сравнивает его с загаданным словом и сообщает,\nправильно ли ответил пользователь. Если слово не угадано,\nкомпьютер показывает буквы, которые стоят на своих местах.\napple - загаданное, apricot - ответ игрока ap#############\n(15 символов, чтобы пользователь не мог узнать длину слова).\nДля сравнения двух слов посимвольно можно пользоваться:\nString str = \"apple\"; char a = str.charAt(0); - метод, вернет char,\nкоторый стоит в слове str на первой позиции.\nИграем до тех пор, пока игрок не отгадает слово.\nИспользуем только маленькие буквы.\n");
        System.out.println("УТОЧНЕНИЕ: Если игрок открыл все буквы перевода слова, без последней буквы,\nи предложил ошибочный вариант перевода слова, то считается,\nчто он не смог отгадать слово!\n\n");
        System.out.println("РЕШЕНИЕ:\n");

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String[] wordsRus = {"яблоко", "апельсин", "лемон", "банан", "абрикос", "авокадо", "брокколи", "морковь", "вишня", "чеснок", "виноград", "дыня", "протечка", "киви", "манго", "гриб", "орех", "олива", "горох", "арахис", "груша", "перец", "ананас", "тыква", "картофель"};
        int maxnumberWords = 25;

        int numberWords = -1;
        while(true)
        {
            System.out.print("Введите количество английских слов для отгадывания (не более 25): ");
            if (scanner.hasNextInt())
            {
                numberWords = scanner.nextInt();
                if ((numberWords > 0) && (numberWords <= maxnumberWords))
                {
                    break;
                }
                else
                {
                    System.out.print("Нужно ввести число от 1 до 25 включительно. Попробуйте ещё раз.\n");
                }
            }
            else
            {
                System.out.print("Нужно ввести число от 1 до 25 включительно. Попробуйте ещё раз.\n");
                scanner.next();
            }
        }

        int numberCorrectAnswers = 0;

        Random rand = new Random ();
        int newRand;
        int[] showOrder = new int[maxnumberWords];
        boolean exitLoop;
        String answerWord;
        newRand = rand.nextInt(maxnumberWords);
        showOrder[0] = newRand;
        for (int i = 1; i < numberWords; i++)
        {
            exitLoop = false;
            while(exitLoop == false)
            {
                newRand = rand.nextInt(maxnumberWords);
                exitLoop = true;
                for (int j = 0; j < i; j++)
                {
                    if (showOrder[j] == newRand)
                    {
                        exitLoop = false;
                        break;
                    }
                }
            }
            showOrder[i] = newRand;
        }

        for (int i = 0; i < numberWords; i++)
        {
            clrScreen();
            System.out.println("\nЗАДАНИЕ №2");
            System.out.println("* Создать массив из слов String[] words = {\"apple\", \"orange\", \"lemon\",\n\"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\",\n\"grape\", \"melon\", \"leak\", \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\",\n\"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"}.\nПри запуске программы компьютер загадывает слово, запрашивает ответ\nу пользователя, сравнивает его с загаданным словом и сообщает,\nправильно ли ответил пользователь. Если слово не угадано,\nкомпьютер показывает буквы, которые стоят на своих местах.\napple - загаданное, apricot - ответ игрока ap#############\n(15 символов, чтобы пользователь не мог узнать длину слова).\nДля сравнения двух слов посимвольно можно пользоваться:\nString str = \"apple\"; char a = str.charAt(0); - метод, вернет char,\nкоторый стоит в слове str на первой позиции.\nИграем до тех пор, пока игрок не отгадает слово.\nИспользуем только маленькие буквы.\n");
            System.out.println("УТОЧНЕНИЕ: Если игрок открыл все буквы перевода слова, без последней буквы,\nи предложил ошибочный вариант перевода слова, то считается,\nчто он не смог отгадать слово!\n\n");
            System.out.println("РЕШЕНИЕ:");
            System.out.print("\nНапишите, как пишется слово \"" + wordsRus[showOrder[i]] + "\" по-английски? ");
            if (i == 0)
            {
                scanner.nextLine();
            }
            answerWord = scanner.nextLine();
            for (int j = 0; j < words[showOrder[i]].length(); j++)
            {
                if (answerWord.toLowerCase().equals(words[showOrder[i]]) == true)
                {
                    numberCorrectAnswers++;
                    System.out.println("\n                          П Р А В И Л Ь Н О!\n");
                    if (i < numberWords - 1)
                    {
                        System.out.print("Нажмите клавишу Enter для продолжения...");
                        scanner.nextLine();
                    }
                    break;
                }
                else
                {
                    if (j == words[showOrder[i]].length() - 1)
                    {
                        System.out.print("\nВы НЕ СМОГЛИ ВСПОМНИТЬ перевод слова " + wordsRus[showOrder[i]].toUpperCase() + ".\n\n                          О Т В Е Т: ");
                    }
                    else
                    {
                        System.out.print("Нет. Подсказка: ");
                    }
                    for (int k = 0; k < 15; k++)
                    {
                        if ((k <= j) && (k < words[showOrder[i]].length()))
                        {
                            if (j == words[showOrder[i]].length() - 1)
                            {
                                System.out.print(words[showOrder[i]].toUpperCase().charAt(k));
                            }
                            else
                            {
                                System.out.print(words[showOrder[i]].charAt(k));
                            }
                            if ((j == words[showOrder[i]].length() - 1) && (k == words[showOrder[i]].length() - 1))
                            {
                                break;
                            }
                        }
                        else
                        {
                            System.out.print("*");
                        }
                    }
                    if ((j == words[showOrder[i]].length() - 1) && (i != numberWords - 1))
                    {
                        System.out.print("\n\nНажмите клавишу Enter для продолжения...");
                        scanner.nextLine();
                    }
                }
                if (j != words[showOrder[i]].length() - 1)
                {
                    System.out.print("\n\nПопробуйте вспомнить английский перевод слова " + wordsRus[showOrder[i]] + " ещё раз: ");
                    answerWord = scanner.nextLine();
                }
            }
        }
        System.out.print("Вы правильно перевели " + numberCorrectAnswers + " ");
        endWords1(numberCorrectAnswers);
        System.out.print(" из " + numberWords + " ");
        endWords2(numberWords);
        System.out.print(".\n\n");
    }
    //endregion

    //region Общие методы
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

    //region Корректировка окончания слов 1
    public static void endWords1(int number)
    {
        if ((number != 11) && (number % 10 == 1))
        {
            System.out.print("слово");
        }
        else if ((number != 12) && (number != 13) && (number != 14) && ((number % 10 == 2) || (number % 10 == 3) || (number % 10 == 4)))
        {
            System.out.print("слова");
        }
        else
        {
            System.out.print("слов");
        }
    }
    //endregion

    //region Корректировка окончания слов 2
    public static void endWords2(int number)
    {
        if ((number != 11) && (number % 10 == 1))
        {
            System.out.print("слова");
        }
        else
        {
            System.out.print("слов");
        }
    }
    //endregion

}
