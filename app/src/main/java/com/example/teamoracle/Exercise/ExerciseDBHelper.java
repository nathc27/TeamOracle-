package com.example.teamoracle.Exercise;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.teamoracle.Forum.Post;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExerciseDBHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "ExDatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "teamoracle.exercise_database.post";


    public ExerciseDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        Cursor c = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = 'exercise'", null);
        if (c.getCount() <= 0) {
            db.execSQL("CREATE TABLE IF NOT EXISTS exercise ("
                    + "seq INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "topic TEXT,"
                    + "question TEXT,"
                    + "answer TEXT)");
        }

        Log.i("Exercise DB SETTING", "TABLE CREATION COMPLETED");
    }

    //onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS post");
        // create new tables
        onCreate(db);
    }

    public void cleanDatabase() {
        // on upgrade drop older tables
        Log.i("CLEAN", "cleaning database");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS exercise");
        onCreate(db);
        //TODO: add more exercises here if you want
        createExercise(new Exercise("Week 1: Introduction to Java", "Write a program that displays Welcome to Java",
                "public class Q {\n" +
                        "\tpublic static void main(String[ ] args) {\n" +
                        "\t\tSystem.out.println(\"Welcome to Java!\");\n" +
                        "\t }\n" +
                        "}\n"));
        createExercise(new Exercise("Week 1: Introduction to Java", "Write a program that displays the result of 1+2+3+4+5+6+7+8+9",
                "public class Q {\n" +
                        "\tpublic static void main(String[ ] args) {\n" +
                        "\t\tSystem.out.println(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9);\n" +
                        "\t }\n" +
                        "}\n"));
        createExercise(new Exercise("Week 1: Introduction to Java", "Write a program that displays the result of  (10*2 + 3.3*2) / (10-3)",
                "public class Q {\n" +
                        "\tpublic static void main(String[ ] args) {\n" +
                        "\t\tSystem.out.println((10*2 + 3.3*2) / (10-3));\n" +
                        "\t }\n" +
                        "}\n"));
        createExercise(new Exercise("Week 2, 3, 4", "Write a program that displays the result of (number1 + number2 + number3) / 3",
                "import java.util.Scanner;\n" +
                        " \n" +
                        "public class Test {\n" +
                        "   public static void main(String[] args) {\n" +
                        "       Scanner input = new Scanner(System.in);\n" +
                        "       System.out.print(\"Enter three numbers: \");\n" +
                        "       double number1 = input.nextDouble();\n" +
                        "\t\tdouble number2 = input.nextDouble();\n" +
                        "\t\tdouble number3 = input.nextDouble();\n" +
                        "\t\tdouble average = (number1 + number2 + number3) / 3;\n" +
                        "\t\tSystem.out.println(average);\n" +
                        "}}\n"));
        createExercise(new Exercise("Week 2, 3, 4", "Write a program that converts pounds into kilo- grams. " +
                "The program prompts the user to enter a number in pounds, " +
                "converts it to kilograms, and displays the result. One pound is 0.454 kilograms.",
                "public class Q {\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tString poundString = JOptionPane.showInputDialog(null, \"Enter a number in pound:\", \"Input\", JOptionPane.QUESTION_MESSAGE);\n" +
                        " \t\t// Convert string to double\n" +
                        "\t\tdouble pound = Double.parseDouble(poundString);\n" +
                        "\t\tdouble kilogram = pound * 0.454;\n" +
                        "\t\tSystem.out.println(\"It is \" + kilogram + \" kilograms\");\n" +
                        "\t\tSystem.exit(0);\n" +
                        "\t}\n" +
                        "}\n"));
        createExercise(new Exercise("Week 2, 3, 4", "Write a program that displays the current time in GMT. " +
                "Revise the program so that it prompts the user to enter the time zone offset to GMT and displays the time in the specified time zone. Here is a sample run: ",
                "import java.util.Scanner;\n" +
                        "public class Exercise {\n" +
                        "\tpublic static void main(String args[]) {\n" +
                        "\t// Enter an ASCII code\n" +
                        "\t\tString numberString = JOptionPane.showInputDialog(null, \"Enter an ASCII code:\", \" Input\", JOptionPane.QUESTION_MESSAGE);\n" +
                        "\t\t// Convert string to int\n" +
                        "\t\tint code = Integer.parseInt(numberString);\n" +
                        "\t\t // Display result\n" +
                        "\t\tSystem.out.println(\"The character for ASCII code \" + code + \" is \" + (char)code);\n" +
                        "\t\tSystem.exit(0);\n" +
                        "\t}\n" +
                        "}\n"));
        createExercise(new Exercise("Week5 : Selection", "Write a program that sorts three integers. " +
                "The integers are entered from the input dialogs and stored in variables num1, num2, and num3, respectively. " +
                "The program sorts the numbers so that num ≤ num2 ≤ num3:. ",
                "iimport java.util.Scanner;\n" +
                        "public class Q {\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tScanner s = new Scanner(System.in);\n" +
                        "\t\t// Enter three numbers\n" +
                        "\t\tSystem.out.print(\"Enter three integers: \");\n" +
                        "i\t\tnt number1 = input.nextInt();\n" +
                        "\t\tint number2 = input.nextInt();\n" +
                        "\t\tint number3 = input.nextInt();\n" +
                        "\n" +
                        "\t\tif (number1 >= number2) {\n" +
                        " \t\t\tint temp = number1;\n" +
                        " \t\t\tnumber1 = number2;\n" +
                        "  \t\t\ttnumber2 = temp;\n" +
                        " \t\t}\n" +
                        " \t\tif (number2 >= number3) {\n" +
                        "\t\t\t int temp = number2;\n" +
                        " \t\t\tnumber2 = number3;\n" +
                        " \t\t \tnumber3 = temp;\n" +
                        "}\n" +
                        " \t\tif (number1 > number2) {\n" +
                        "\t\t\tint temp = number1;\n" +
                        "\t\t\tnumber1 = number2;\n" +
                        "\t\t\tnumber2 = temp;\n" +
                        "\t\t}\n" +
                        "\t\tSystem.out.println(\"The sorted numbers are \" + number1 + \" \" + number2 + \" \" + number3);\n" +
                        "\t}\n" +
                        "}\n"));
        createExercise(new Exercise("Week5 : Selection", "Write a program that accepts three integers.\n" +
                "Using the three below conditions, compare the integers and display the relevant result. \n" +
                "True? Display “Condition x is met”\n" +
                "False? Display “Condition x is not met”\n" +
                "Where x is the condition number\n" +
                "Condition 1:Integer one and integer two are larger than 0.\n" +
                "Condition 2:Integer one or integer three are larger than 5.\n" +
                "Condition 3:The sum of integer one and two, or two and three, is greater than 10.\n",
                "public class Q {\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tScanner s = new Scanner(System.in);\n" +
                        "\t\tint first = s.nextInt();\n" +
                        "\t\tint second = s.nextInt();\n" +
                        "\t\tint third = s.nextInt();\n" +
                        "\t\tSystem.out.println(first > 0 && second > 0 ? \"Condition 1 met.\" : \"Condition 1 not met.\");\n" +
                        "\t\tSystem.out.println(first > 5 || third > 5 ? \"Condition 2 met.\" : \"Condition 2 not met.\");\n" +
                        "\t\tSystem.out.println(first + second > 10 || second + third > 10 ? \"Condition 3 met.\" : \"Condition 3 not met.\");\n" +
                        "\t}\n" +
                        "}\n"));
        createExercise(new Exercise("Week 6: loop", "Write a program that displays all the numbers from 100 to 1,000, " +
                "ten per line, that are divisible by 5 and 6. Numbers are separated by exactly one space.\n",
                "public class Q {\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tint count = 1;\n" +
                        "\t\tfor (int i = 100; i <= 1000; i++)\n" +
                        "\t\tif (i % 5 == 0 && i % 6 == 0)\n" +
                        "\t\tSystem.out.print((count++ % 10 != 0) ? i + \" \": i + \"\\n\");\n" +
                        "\t }\n" +
                        "}\n"));
        createExercise(new Exercise("Week 6: loop", "Prompt the user for an integer, and display the following pattern for the integer using a counted loop.\n" +
                "Enter an integer: 6\n" +
                "Pattern:\n" +
                "1\n" +
                "1 2\n" +
                "1 2 3 \n" +
                "1 2 3 4\n" +
                "1 2 3 4 5\n" +
                "1 2 3 4 5 6\n",
                "import java.util.Scanner;\n" +
                        "\n" +
                        "public class Q1 {\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tScanner s = new Scanner(System.in);\n" +
                        "\t\tSystem.out.print(\"Please input number of iterations: \");\n" +
                        "\t\tint iterations = s.nextInt();\n" +
                        "\t\tfor (int i = 1; i <= iterations; i++) {\n" +
                        "\t\t\tfor (int j = 1; j <= i; j++) {\n" +
                        "\t\t\t\tSystem.out.print(j + \" \");\n" +
                        "\t\t\t}\n" +
                        " \t\t\tSystem.out.println();\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "}\n"));
        createExercise(new Exercise("Week 7: method", "Write a method with the following header to display an integer in reverse order:\n" +
                "public static void reverse(int number)\n" +
                "For example, reverse(3456) displays 6543\n",
                "public class Q {\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tSystem.out.print(\"Enter an integer: \");\n" +
                        "\t\tScanner input = new Scanner(System.in);\n" +
                        "\t\tint number = input.nextInt();\n" +
                        "\t\treverse(number);\n" +
                        "\t}\n" +
                        "\tpublic static void reverse(int number) {\n" +
                        "\t\twhile (number != 0) {\n" +
                        "\t\t\tint remainder = number % 10;\n" +
                        "\t\t\tSystem.out.print(remainder);\n" +
                        "\t\t\tnumber = number / 10;\n" +
                        "\t\t}\n" +
                        "\t\tSystem.out.println();\n" +
                        "\t}\n" +
                        "}\n"));
        createExercise(new Exercise("Week 7: method", "Write a method takes in 3 integers and returns the largest value.\n" +
                "• Call the method 4 times.\n" +
                "• Sum the output of the 4 values and print it out.\n" +
                "• Get the input from the user\n" +
                "Example:\n" +
                "Please provide 3 integers(#1): (enter: -5 0 5)\n" +
                "Please provide 3 integers(#2): (enter: 3 6 9)\n" +
                "Please provide 3 integers(#3): (enter: 12 8 4)\n" +
                "Please provide 3 integers(#4): (enter: 3 3 3)\n" +
                "The sum of the four values is: 29\n",
                "public class Q {\n" +
                        "\tpublic static void main(String[] args) {\n" +
                        "\t\tScanner input = new Scanner(System.in);\n" +
                        "\t\tint sum = 0;\n" +
                        "\t\tfor (int i = 1; i <= 4; i++) {\n" +
                        "\t\t\tSystem.out.print(\"Please provide 3 integers (#\" + i + \"): \");\n" +
                        "\t\t\tsum += max(s.nextInt(), s.nextInt(), s.nextInt());\n" +
                        "\t\t}\n" +
                        "\t\tSystem.out.println(\"The sum of the four values is \" + sum);\n" +
                        "\t}\n" +
                        "\n" +
                        "\tpublic static int max(int num1, int num2, int num3) {\n" +
                        "\t\tint max = num1;\n" +
                        "\t\tif (num2 > max) {\n" +
                        "\t\t\tmax = num2;\n" +
                        "\t\t}\n" +
                        "\t\tif (num3 > max) {\n" +
                        "\t\t\tmax = num3;\n" +
                        "\t\t}\n" +
                        "\t\treturn max;\n" +
                        "\t}\n" +
                        "}"));
        createExercise(new Exercise("Week 8: Arrays", "Write a program that reads ten integers and " +
                "displays them in the reverse of the order in which they were read.",
                "public class Q {\n" +
                        "\tpublic static void main (String[] args) {\n" +
                        "\t\tScanner input = new Scanner(System.in);\n" +
                        "\t\tint[] num = new int[10];\n" +
                        "\t\tfor (int i = 0; i < 10; i++) {\n" +
                        "\t\t\t// Read a number\n" +
                        "\t\t\tSystem.out.print(\"Read a number: \");\n" +
                        "\t\t\tnum[i] = input.nextInt();\n" +
                        "   \t\t}\n" +
                        "\n" +
                        "    \t\t// Display the array\n" +
                        "\t\tfor (int i = 9; i >= 0; i--) {\n" +
                        "\t\t\tSystem.out.println(num[i]);\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "}"));
        createExercise(new Exercise("Week 9: Inheritance & Polymorphism", "Overloads the method in Class B\n" +
                "class B {\n" +
                "\tpublic void p(double i) {\n" +
                "\t\tSystem.out.println(i * 2);\n" +
                "\t}\n" +
                "}",
                "class A extends B {\n" +
                        "\tpublic void p(int i) {\n" +
                        "\t\tSystem.out.println(i);\n" +
                        "\t}\n" +
                        "}"));
        createExercise(new Exercise("Week 9: Inheritance & Polymorphism", "Override the method in Class B\n" +
                "class B {\n" +
                "\tpublic void p(double i) {\n" +
                "\t\tSystem.out.println(i * 2);\n" +
                "\t}\n" +
                "}",
                "class A extends B {\n" +
                        "\tpublic void p(double i) {\n" +
                        "\t\tSystem.out.println(i);\n" +
                        "\t}\n" +
                        "}"));
        createExercise(new Exercise("Week 10: OOP", "Write a method with ‘this’ keyword to calculate the area of a circle",
                "public class Circle { \n" +
                        "\tprivate double radius;\n" +
                        "\tpublic Circle(double radius) {\n" +
                        "\t\tthis.radius = radius;\n" +
                        "\t}\n" +
                        "\tpublic Circle() {\n" +
                        "\t\tthis(1.0);\n" +
                        "\t}\n" +
                        "\tpublic double getArea() {\n" +
                        "\t\treturn this.radius * this.radius * Math.PI; \n" +
                        "\t}\n" +
                        "}"));
        createExercise(new Exercise("Week 10: OOP", "Create a constructor to the StudentResults class:\n" +
                "Public class StudentResults{\n" +
                "\tPublic string Full_Name;\n" +
                "\tPublic string Exam_Name;\n" +
                "\tPublic string Exam_Score;\n" +
                "\tPublic string Exam_Grade;\n" +
                "\t...\n" +
                "}",
                "Public class StudentResults{\n" +
                        "\tPublic string Full_Name;\n" +
                        "\tPublic string Exam_Name;\n" +
                        "\tPublic string Exam_Score;\n" +
                        "\tPublic string Exam_Grade;\n" +
                        "StudentResults () {\n" +
                        "Full_Name = “No name given”\n" +
                        "\t\tExam_Name = “Unknown”\n" +
                        "\t\tExam_Score = No score\n" +
                        "\t\tExam_Grade = “Unknown”\n" +
                        "}\n"));

        Log.i("CLEAN", "DATABASE CLEANED");
    }

    //create post
    public void createExercise(Exercise e) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("topic", e.getTopic());
        c.put("question", e.getQuestion());
        c.put("answer", e.getAnswer());
        db.insert("exercise", null, c);
        Log.i("DATABASE", "EXERCISE CREATED", null);
        db.close();
    }

    public List<String> getTopics() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> topics = new ArrayList<String>();
        Cursor c = db.rawQuery("SELECT DISTINCT topic FROM exercise", null);
        while (c.moveToNext()) {
            topics.add(c.getString(c.getColumnIndex("topic")));
        }
        db.close();
        return topics;
    }

    public Queue<Exercise> getExerciseByTopic(String t) {
        SQLiteDatabase db = this.getReadableDatabase();
        Queue<Exercise> exercises = new LinkedList<>();
        Cursor c = db.rawQuery("SELECT * FROM exercise WHERE topic = " + "'" + t + "'", null);
        while (c.moveToNext()) {
            Exercise e = new Exercise();
            e.setSeq(c.getInt(c.getColumnIndex("seq")));
            e.setTopic(c.getString(c.getColumnIndex("topic")));
            e.setQuestion(c.getString(c.getColumnIndex("question")));
            e.setAnswer(c.getString(c.getColumnIndex("answer")));
            exercises.add(e);
        }
        db.close();
        return exercises;
    }
}
