package com.example.teamoracle.Quiz;

import java.util.ArrayList;

public class Questions {

    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String correct;
    private String category;

    public Questions(){}

    public Questions(String question, String choice1, String choice2, String choice3, String choice4, String correct, String category) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.correct = correct;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public String getCorrect() {
        return correct;
    }

    public String getCategory() {
        return category;
    }

    public static ArrayList<Questions> getDummyQuestions() {
        ArrayList<Questions> set = new ArrayList<>();

        set.add(new Questions("The extension name of a Java source code file is",".java",".obj",".class",".exe",".java","T1"));
        set.add(new Questions("________  provides an integrated development environment (IDE) for rapidly developing Java programs. Editing, compiling, building, debugging, and online help are integrated in one graphical user interface. ","Java language specification","Java API","Java JDK",".exe","Java IDE","T1"));
        set.add(new Questions("Every statement in Java ends with ________.","a semicolon (;)"," a comma (,)","a period (.)","an asterisk (*)","a semicolon (;)","T1"));
        set.add(new Questions(" ________  is a technical definition of the language that includes the syntax and semantics of the Java programming language.","Java language specification","Java API","Java JDK","Java IDE","Java language specification","T1"));
        set.add(new Questions("________ contains predefined classes and interfaces for developing Java programs."," Java language specification","Java API","Java JDK","Java IDE","Java API","T1"));
        set.add(new Questions("Which of the following statements is correct?","Every line in a program must end with a semicolon.","Every statement in a program must end with a semicolon.","Every comment line must end with a semicolon.","Every method must end with a semicolon.","Every statement in a program must end with a semicolon.","T1"));
        set.add(new Questions("Which JDK command is correct to run a Java application in ByteCode.class?","java ByteCode","java ByteCode.class","javac ByteCode.java","javac ByteCode","java ByteCode","T1"));
        set.add(new Questions("Java compiler translates Java source code into _________.","Java bytecode","machine code","assembly code","another high-level language code","Java bytecode","T1"));
        set.add(new Questions("A block is enclosed inside __________.","parentheses","braces","brackets","quotes",".braces","T1"));
        set.add(new Questions("If a program compiles fine, but it produces incorrect result, then the program suffers  __________.","a compilation error","a runtime error","a logic error","none of the above","a logic error","T1"));

        set.add(new Questions("Suppose a Scanner object is created as follows:\n" + "\n" + "Scanner input = new Scanner(System.in);\n" + "\n" + "What method do you use to read an int value?\n", "input.nextInt();","input.nextInteger();"," input.int();","input.integer();","input.nextInt();","T2"));
        set.add(new Questions("_______ is the code with natural language mixed with Java code","Java program","A Java statement","Pseudocode",".A flowchart diagram","Pseudocode ","T2"));
        set.add(new Questions("Every letter in a Java keyword is in lowercase?","true","false"," "," "," ","T2"));
        set.add(new Questions("Which of the following are correct names for variables according to Java naming conventions?","radius","Radius","RADIUS","FindArea","radius","T2"));
        set.add(new Questions("To declare a constant MAX_LENGTH inside a method with value 99.98, you write","final MAX_LENGTH = 99.98;","final float MAX_LENGTH = 99.98;","double MAX_LENGTH = 99.98;","final double MAX_LENGTH = 99.98;","final double MAX_LENGTH = 99.98;","T2"));
        set.add(new Questions("To declare an int variable number with initial value 2, you write","int number = 2L;","int number = 2l;","int number = 2;","int number = 2.0;","int number = 2;","T2"));
        set.add(new Questions("The expression 4 + 20 / (3 - 1) * 2 is evaluated to","4","20","24","9","24","T2"));
        set.add(new Questions("Suppose x is 1. What is x after x += 2?","0","1","2","3","3","T2"));
        set.add(new Questions("Which of the following expression results in 45.37? ","(int)(45.378 * 100) / 100 ","(int)(45.378 * 100) / 100.0 ","(int)(45.378 * 100 / 100) ","(int)(45.378) * 100 / 100.0 ","(int)(45.378 * 100) / 100.0","T2"));
        set.add(new Questions("Analyze the following code.\n" + "\n" + "public class Test {\n" + "  public static void main(String[] args) {\n" + "    int month = 09;\n" + "    System.out.println(\"month is \" + month);\n" + "  }  \n" + "}\n","The program displays month is 09","The program displays month is 9","The program displays month is 9.0","The program has a syntax error, because 09 is an incorrect literal value.","The program has a syntax error, because 09 is an incorrect literal value.","T2"));

        set.add(new Questions("Suppose a Scanner object is created as follows:\n" + "\n" + "Scanner input = new Scanner(System.in);\n" + "\n" + "What method do you use to read an int value?\n", "input.nextInt();","input.nextInteger();"," input.int();","input.integer();","input.nextInt();","T3"));
        set.add(new Questions("_______ is the code with natural language mixed with Java code","Java program","A Java statement","Pseudocode",".A flowchart diagram","Pseudocode ","T3"));
        set.add(new Questions("Every letter in a Java keyword is in lowercase?","true","false"," "," "," ","T3"));
        set.add(new Questions("Which of the following are correct names for variables according to Java naming conventions?","radius","Radius","RADIUS","FindArea","radius","T3"));
        set.add(new Questions("To declare a constant MAX_LENGTH inside a method with value 99.98, you write","final MAX_LENGTH = 99.98;","final float MAX_LENGTH = 99.98;","double MAX_LENGTH = 99.98;","final double MAX_LENGTH = 99.98;","final double MAX_LENGTH = 99.98;","T3"));
        set.add(new Questions("To declare an int variable number with initial value 2, you write","int number = 2L;","int number = 2l;","int number = 2;","int number = 2.0;","int number = 2;","T3"));
        set.add(new Questions("The expression 4 + 20 / (3 - 1) * 2 is evaluated to","4","20","24","9","24","T3"));
        set.add(new Questions("Suppose x is 1. What is x after x += 2?","0","1","2","3","3","T3"));
        set.add(new Questions("Which of the following expression results in 45.37? ","(int)(45.378 * 100) / 100 ","(int)(45.378 * 100) / 100.0 ","(int)(45.378 * 100 / 100) ","(int)(45.378) * 100 / 100.0 ","(int)(45.378 * 100) / 100.0","T3"));
        set.add(new Questions("Analyze the following code.\n" + "\n" + "public class Test {\n" + "  public static void main(String[] args) {\n" + "    int month = 09;\n" + "    System.out.println(\"month is \" + month);\n" + "  }  \n" + "}\n","The program displays month is 09","The program displays month is 9","The program displays month is 9.0","The program has a syntax error, because 09 is an incorrect literal value.","The program has a syntax error, because 09 is an incorrect literal value.","T3"));

        set.add(new Questions("Suppose a Scanner object is created as follows:\n" + "\n" + "Scanner input = new Scanner(System.in);\n" + "\n" + "What method do you use to read an int value?\n", "input.nextInt();","input.nextInteger();"," input.int();","input.integer();","input.nextInt();","T4"));
        set.add(new Questions("_______ is the code with natural language mixed with Java code","Java program","A Java statement","Pseudocode",".A flowchart diagram","Pseudocode ","T4"));
        set.add(new Questions("Every letter in a Java keyword is in lowercase?","true","false"," "," "," ","T4"));
        set.add(new Questions("Which of the following are correct names for variables according to Java naming conventions?","radius","Radius","RADIUS","FindArea","radius","T4"));
        set.add(new Questions("To declare a constant MAX_LENGTH inside a method with value 99.98, you write","final MAX_LENGTH = 99.98;","final float MAX_LENGTH = 99.98;","double MAX_LENGTH = 99.98;","final double MAX_LENGTH = 99.98;","final double MAX_LENGTH = 99.98;","T4"));
        set.add(new Questions("To declare an int variable number with initial value 2, you write","int number = 2L;","int number = 2l;","int number = 2;","int number = 2.0;","int number = 2;","T4"));
        set.add(new Questions("The expression 4 + 20 / (3 - 1) * 2 is evaluated to","4","20","24","9","24","T4"));
        set.add(new Questions("Suppose x is 1. What is x after x += 2?","0","1","2","3","3","T4"));
        set.add(new Questions("Which of the following expression results in 45.37? ","(int)(45.378 * 100) / 100 ","(int)(45.378 * 100) / 100.0 ","(int)(45.378 * 100 / 100) ","(int)(45.378) * 100 / 100.0 ","(int)(45.378 * 100) / 100.0","T4"));
        set.add(new Questions("Analyze the following code.\n" + "\n" + "public class Test {\n" + "  public static void main(String[] args) {\n" + "    int month = 09;\n" + "    System.out.println(\"month is \" + month);\n" + "  }  \n" + "}\n","The program displays month is 09","The program displays month is 9","The program displays month is 9.0","The program has a syntax error, because 09 is an incorrect literal value.","The program has a syntax error, because 09 is an incorrect literal value.","T4"));

        set.add(new Questions("The 'less than or equal to' comparison operator in Java is __________","<","<=","=<","<<","<=","T5"));
        set.add(new Questions("In Java, the word true is ________.","a Java keyword","a Boolean literal ","same as value 1","same as value 0","a Boolean literal","T5"));
        set.add(new Questions("Suppose income is 4001, what is the output of the following code:\n" + "\n" + "if (income > 3000) {\n" + "  System.out.println(\"Income is greater than 3000\");\n" + "}\n" + "else if (income > 4000) {\n" + "  System.out.println(\"Income is greater than 4000\");\n","no output","Income is greater than 3000 ","Income is greater than 3000 followed by Income is greater than 4000","Income is greater than 4000","Income is greater than 3000 ","T5"));
        set.add(new Questions("What is the output from System.out.println((int)Math.random() * 4)?","0","1","2","3","0","T5"));
        set.add(new Questions("The __________ method immediately terminates the program.","System.terminate(0);","System.halt(0);","System.exit(0);","System.quit(0);","System.exit(0);","T5"));
        set.add(new Questions("Suppose isPrime is a boolean variable, which of the following is the correct and best statement for testing if isPrime is true. ","if (isPrime = true) ","if (isPrime == true) ","if (isPrime)","if (!isPrime = false) ","if (isPrime)","T5"));
        set.add(new Questions("Analyze the following program fragment:\n" + "\n" + "int x;\n" + "double d = 1.5;\n" + "\n" + "switch (d) {\n" + "  case 1.0: x = 1;\n" + "  case 1.5: x = 2;\n" + "  case 2.0: x = 3;\n" + "}\n","The program has a compile error because the required break statement is missing in the switch statement.","The program has a compile error because the required default case is missing in the switch statement.","The switch control variable cannot be double.","No errors.","The switch control variable cannot be double.","T5"));
        set.add(new Questions("The following code displays ___________.\n" + "\n" + "double temperature = 50;\n" + "\n" + "if (temperature >= 100)\n" + "  System.out.println(\"too hot\");\n" + "else if (temperature <= 40)\n" + "  System.out.println(\"too cold\");\n" + "else\n" + "  System.out.println(\"just right\");\n","too hot","too cold",".just right","too hot too cold just right","just right","T5"));
        set.add(new Questions("Which of the following is the correct expression that evaluates to true if the number x is between 1 and 100 or the number is negative? ","1 < x < 100 && x < 0","((x < 100) && (x > 1)) || (x < 0)","((x < 100) && (x > 1)) && (x < 0)","(1 > x >  100) || (x < 0)","((x < 100) && (x > 1)) || (x < 0)","T5"));
        set.add(new Questions("Assume x = 4 and y = 5, Which of the following is true?","x < 5 && y < 5","x < 5 || y < 5","x > 5 && y > 5","x > 5 || y > 5","x < 5 || y < 5","T5"));

        set.add(new Questions("How many times will the following code print \"Welcome to Java\"?\n" + "\n" + "int count = 0;\n" + "while (count < 10) {\n" + "  System.out.println(\"Welcome to Java\");\n" + "  count++;\n" + "}\n","8","9","10","11","10","T6"));
        set.add(new Questions("What the output of the following code:\n" + "\n" + "for ( ; ; ) \n" + "  System.out.println(\"Welcome to Java\");\n","does not print anything.","prints out Welcome to Java one time.","prints out Welcome to Java two times.","prints out Welcome to Java forever.","prints out Welcome to Java forever.","T6"));
        set.add(new Questions("Which of the loop statements always have their body executed at least once.","The while loop","The do-while loop","The for loop"," ","The do-while loop","T6"));
        set.add(new Questions("Which of the following is the correct expression that evaluates to true if the number x is between 1 and 100 or the number is negative? ","1 < x < 100 && x < 0","((x < 100) && (x > 1)) || (x < 0)","((x < 100) && (x > 1)) && (x < 0)","(1 > x >  100) || (x < 0)","((x < 100) && (x > 1)) || (x < 0)","T6"));
        set.add(new Questions("Assume x = 4 and y = 5, Which of the following is true?","x < 5 && y < 5","x < 5 || y < 5","x > 5 && y > 5","x > 5 || y > 5","x < 5 || y < 5","T6"));
        set.add(new Questions("The expression 4 + 20 / (3 - 1) * 2 is evaluated to","4","20","24","9","24","T6"));
        set.add(new Questions("Suppose x is 1. What is x after x += 2?","0","1","2","3","3","T6"));
        set.add(new Questions("Java compiler translates Java source code into _________.","Java bytecode","machine code","assembly code","another high-level language code","Java bytecode","T6"));
        set.add(new Questions("A block is enclosed inside __________.","parentheses","braces","brackets","quotes",".braces","T6"));
        set.add(new Questions("Analyze the following statement:\n" + "\n" + "double sum = 0;\n" + "for (double d = 0; d < 10;) {\n" + "  d += 0.1;\n" + "  sum += sum + d;\n" + "}\n","The program has a compile error because the adjustment is missing in the for loop.","The program has a compile error because the control variable in the for loop cannot be of the double type.","The program runs in an infinite loop because d&lt;10 would always be true.","The program compiles and runs fine.","The program compiles and runs fine.","T6"));

        set.add(new Questions("The extension name of a Java source code file is",".java",".obj",".class",".exe",".java","T7"));
        set.add(new Questions("________  provides an integrated development environment (IDE) for rapidly developing Java programs. Editing, compiling, building, debugging, and online help are integrated in one graphical user interface. ","Java language specification","Java API","Java JDK",".exe","Java IDE","T7"));
        set.add(new Questions("Every statement in Java ends with ________.","a semicolon (;)"," a comma (,)","a period (.)","an asterisk (*)","a semicolon (;)","T7"));
        set.add(new Questions(" ________  is a technical definition of the language that includes the syntax and semantics of the Java programming language.","Java language specification","Java API","Java JDK","Java IDE","Java language specification","T7"));
        set.add(new Questions("________ contains predefined classes and interfaces for developing Java programs."," Java language specification","Java API","Java JDK","Java IDE","Java API","T7"));
        set.add(new Questions("Which of the following statements is correct?","Every line in a program must end with a semicolon.","Every statement in a program must end with a semicolon.","Every comment line must end with a semicolon.","Every method must end with a semicolon.","Every statement in a program must end with a semicolon.","T7"));
        set.add(new Questions("Which JDK command is correct to run a Java application in ByteCode.class?","java ByteCode","java ByteCode.class","javac ByteCode.java","javac ByteCode","java ByteCode","T7"));
        set.add(new Questions("Java compiler translates Java source code into _________.","Java bytecode","machine code","assembly code","another high-level language code","Java bytecode","T7"));
        set.add(new Questions("A block is enclosed inside __________.","parentheses","braces","brackets","quotes",".braces","T7"));
        set.add(new Questions("If a program compiles fine, but it produces incorrect result, then the program suffers  __________.","a compilation error","a runtime error","a logic error","none of the above","a logic error","T7"));

        set.add(new Questions("The 'less than or equal to' comparison operator in Java is __________","<","<=","=<","<<","<=","T8"));
        set.add(new Questions("In Java, the word true is ________.","a Java keyword","a Boolean literal ","same as value 1","same as value 0","a Boolean literal","T8"));
        set.add(new Questions("Suppose income is 4001, what is the output of the following code:\n" + "\n" + "if (income > 3000) {\n" + "  System.out.println(\"Income is greater than 3000\");\n" + "}\n" + "else if (income > 4000) {\n" + "  System.out.println(\"Income is greater than 4000\");\n","no output","Income is greater than 3000 ","Income is greater than 3000 followed by Income is greater than 4000","Income is greater than 4000","Income is greater than 3000 ","T8"));
        set.add(new Questions("What is the output from System.out.println((int)Math.random() * 4)?","0","1","2","3","0","T8"));
        set.add(new Questions("The __________ method immediately terminates the program.","System.terminate(0);","System.halt(0);","System.exit(0);","System.quit(0);","System.exit(0);","T8"));
        set.add(new Questions("Suppose isPrime is a boolean variable, which of the following is the correct and best statement for testing if isPrime is true. ","if (isPrime = true) ","if (isPrime == true) ","if (isPrime)","if (!isPrime = false) ","if (isPrime)","T8"));
        set.add(new Questions("Analyze the following program fragment:\n" + "\n" + "int x;\n" + "double d = 1.5;\n" + "\n" + "switch (d) {\n" + "  case 1.0: x = 1;\n" + "  case 1.5: x = 2;\n" + "  case 2.0: x = 3;\n" + "}\n","The program has a compile error because the required break statement is missing in the switch statement.","The program has a compile error because the required default case is missing in the switch statement.","The switch control variable cannot be double.","No errors.","The switch control variable cannot be double.","T8"));
        set.add(new Questions("The following code displays ___________.\n" + "\n" + "double temperature = 50;\n" + "\n" + "if (temperature >= 100)\n" + "  System.out.println(\"too hot\");\n" + "else if (temperature <= 40)\n" + "  System.out.println(\"too cold\");\n" + "else\n" + "  System.out.println(\"just right\");\n","too hot","too cold",".just right","too hot too cold just right","just right","T8"));
        set.add(new Questions("Which of the following is the correct expression that evaluates to true if the number x is between 1 and 100 or the number is negative? ","1 < x < 100 && x < 0","((x < 100) && (x > 1)) || (x < 0)","((x < 100) && (x > 1)) && (x < 0)","(1 > x >  100) || (x < 0)","((x < 100) && (x > 1)) || (x < 0)","T8"));
        set.add(new Questions("Assume x = 4 and y = 5, Which of the following is true?","x < 5 && y < 5","x < 5 || y < 5","x > 5 && y > 5","x > 5 || y > 5","x < 5 || y < 5","T8"));

        set.add(new Questions("How many times will the following code print \"Welcome to Java\"?\n" + "\n" + "int count = 0;\n" + "while (count < 10) {\n" + "  System.out.println(\"Welcome to Java\");\n" + "  count++;\n" + "}\n","8","9","10","11","10","T9"));
        set.add(new Questions("What the output of the following code:\n" + "\n" + "for ( ; ; ) \n" + "  System.out.println(\"Welcome to Java\");\n","does not print anything.","prints out Welcome to Java one time.","prints out Welcome to Java two times.","prints out Welcome to Java forever.","prints out Welcome to Java forever.","T9"));
        set.add(new Questions("Which of the loop statements always have their body executed at least once.","The while loop","The do-while loop","The for loop"," ","The do-while loop","T9"));
        set.add(new Questions("Which of the following is the correct expression that evaluates to true if the number x is between 1 and 100 or the number is negative? ","1 < x < 100 && x < 0","((x < 100) && (x > 1)) || (x < 0)","((x < 100) && (x > 1)) && (x < 0)","(1 > x >  100) || (x < 0)","((x < 100) && (x > 1)) || (x < 0)","T9"));
        set.add(new Questions("Assume x = 4 and y = 5, Which of the following is true?","x < 5 && y < 5","x < 5 || y < 5","x > 5 && y > 5","x > 5 || y > 5","x < 5 || y < 5","T9"));
        set.add(new Questions("The expression 4 + 20 / (3 - 1) * 2 is evaluated to","4","20","24","9","24","T9"));
        set.add(new Questions("Suppose x is 1. What is x after x += 2?","0","1","2","3","3","T9"));
        set.add(new Questions("Java compiler translates Java source code into _________.","Java bytecode","machine code","assembly code","another high-level language code","Java bytecode","T9"));
        set.add(new Questions("A block is enclosed inside __________.","parentheses","braces","brackets","quotes",".braces","T9"));
        set.add(new Questions("Analyze the following statement:\n" + "\n" + "double sum = 0;\n" + "for (double d = 0; d < 10;) {\n" + "  d += 0.1;\n" + "  sum += sum + d;\n" + "}\n","The program has a compile error because the adjustment is missing in the for loop.","The program has a compile error because the control variable in the for loop cannot be of the double type.","The program runs in an infinite loop because d&lt;10 would always be true.","The program compiles and runs fine.","The program compiles and runs fine.","T9"));

        set.add(new Questions("The extension name of a Java source code file is",".java",".obj",".class",".exe",".java","T10"));
        set.add(new Questions("________  provides an integrated development environment (IDE) for rapidly developing Java programs. Editing, compiling, building, debugging, and online help are integrated in one graphical user interface. ","Java language specification","Java API","Java JDK",".exe","Java IDE","T10"));
        set.add(new Questions("Every statement in Java ends with ________.","a semicolon (;)"," a comma (,)","a period (.)","an asterisk (*)","a semicolon (;)","T10"));
        set.add(new Questions(" ________  is a technical definition of the language that includes the syntax and semantics of the Java programming language.","Java language specification","Java API","Java JDK","Java IDE","Java language specification","T10"));
        set.add(new Questions("________ contains predefined classes and interfaces for developing Java programs."," Java language specification","Java API","Java JDK","Java IDE","Java API","T10"));
        set.add(new Questions("Which of the following statements is correct?","Every line in a program must end with a semicolon.","Every statement in a program must end with a semicolon.","Every comment line must end with a semicolon.","Every method must end with a semicolon.","Every statement in a program must end with a semicolon.","T10"));
        set.add(new Questions("Which JDK command is correct to run a Java application in ByteCode.class?","java ByteCode","java ByteCode.class","javac ByteCode.java","javac ByteCode","java ByteCode","T10"));
        set.add(new Questions("Java compiler translates Java source code into _________.","Java bytecode","machine code","assembly code","another high-level language code","Java bytecode","T10"));
        set.add(new Questions("A block is enclosed inside __________.","parentheses","braces","brackets","quotes",".braces","T10"));
        set.add(new Questions("If a program compiles fine, but it produces incorrect result, then the program suffers  __________.","a compilation error","a runtime error","a logic error","none of the above","a logic error","T10"));

        return set;
    }
}

