package Classes;
//28. Выбрать из текста все слова, в которых встречаются, как русские, так и
//        латинские буквы. Словом считается непрерывная последовательность символов (строчных и
//        прописных) А-Я, A-Z и цифр.


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


import static javax.swing.UIManager.getString;

public class MainLogic {
/*
Заранее придумать не менее 5 различных тестов, охватывающих как типичные, так и
все возможные граничные (наиболее невероятные и показательные) ситуации.
Как обычно, решение должно быть оформлено в виде отдельной функции /
функций или класса.
Если в задаче используются регулярные выражения, то вы должны очень хорошо
понимать, что это, и все особенности применительно к вашей задаче!
Если в вашем решении используется многократная конкатенация строк (не один-два-три раза, а именно многократная),
то для эффективности использовать StringBuilder.
В задачах, где необходимо выбрать что-то без повторений, удобным (и эффективным в
плане быстродействия) будет использовать Set<String> (HashSet<String> или
TreeSet<String>) для хранения уже выбранных элементов. В задачах, где необходимо строке
сопоставить какое-то значение, можно воспользоваться Map<String, Integer>
(HashMap<String, Integer> или TreeMap<String, Integer>).

11 таск варик [9]
Дан текст, состоящий из предложений. Концом предложения считаются символы точка,
'!' и '?'. Началом предложения – любой символ, отличный от данных трех и пробела,
первый после конца предыдущего предложения (или вообще первый в тексте). Выбрать
(в виде списка) из текста все вопросительные предложения
 */




        /*
            public static String readStringFromFile(String filename) throws FileNotFoundException {
                Scanner scanner = new Scanner(new File(filename));
                String s = scanner.nextLine();
                scanner.close();
                return s;
            }
            */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list = listOfAllInterrogativeSentences("В лингвистике термин «текст» используется в широком значении, включая и образцы устной речи. Восприятие текста изучается в рамках лингвистики текста и психолингвистики. Так, например, И. Р. Гальперин определяет текст следующим образом: «Это письменное сообщение, объективированное в виде письменного документа, состоящее из ряда высказываний, объединённых разными типами лексической, грамматической и");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> listOfAllInterrogativeSentences(String str) { //возвращяет лист вопросов
        List<String> list = new ArrayList<>();
        for (String s : list) {
            list = List.of(s.split("[.!?]"));// .of вместо задачи new и  add те сократили
            // в [] мы сунули сразу несколько разделителей
        }

        //list = List.of(str.split("!")); // \\ нужны для того, чтобы джава не думала что мы команду какуе-то прописать хотим а просто символ
        return list;
    }

    //    .\input.txt .\output.txt
    public static void readAndWriteMethod(InputArgs inputArgs) throws IOException {
        String str = ClassesForInAndOut.readFile(inputArgs.getInputFile());
        String answer = MainLogic.getAnswer(str);
        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(), answer);
    }

    public static void printSuccessMessage(int num) {
        if (num == 0) {
            System.out.println("Основная программа выполнена.");
        } else {
            System.out.println("Тест " + num + " выполнен успешно.");
        }
        System.out.println();
    }

    public static String getAnswer(String str) {
        String str2;
        int kolReshotochek = 0;
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i=0; i <= str.length()-1; i++){
            if (str.charAt(i) =='?'){
                stringBuilder.insert(i+4*kolReshotochek,"####");//заменяем символ I (все ?) на ####?
                kolReshotochek++;
            }
        }
        list = List.of(String.valueOf(stringBuilder).split("[.!?]"));// .of вместо задачи new и  add те сократили
        //добавить сивол полсе ? лучше

            // в [] мы сунули сразу несколько разделителей
        List<String> list2 = new ArrayList<>();
        for (String s : list) {
            if (s.length()>=4) {
                if (s.charAt(s.length() - 1) == '#' && s.charAt(s.length() - 2) == '#' && s.charAt(s.length() - 3) == '#' && s.charAt(s.length() - 4) == '#') {
                     stringBuilder = new StringBuilder(s);
                    stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length());
                    stringBuilder.insert(stringBuilder.length(), "?");
                    list2.add(String.valueOf(stringBuilder));
                }//регулярные выражения
            }
        }

        return ClassesForInAndOut.getString(list2);


    }

}



    /* public static String getAnswer(String str){
        String string = " ";
        Pattern pattern1 = Pattern.compile("[a-zA-Zа-яА-Я]*[0-9]*[a-zA-Z]+[а-яА-Я]+[a-zA-Zа-яА-Я]*");
        Pattern pattern2 = Pattern.compile("[a-zA-Zа-яА-Я]*[a-zA-Z]+[а-яА-Я]+[0-9]*[a-zA-Zа-яА-Я]*");
        Pattern pattern3 = Pattern.compile("[a-zA-Zа-яА-Я]*[а-яА-Я]+[0-9]*[a-zA-Z]+[a-zA-Zа-яА-Я]*");
        Pattern pattern4 = Pattern.compile("[a-zA-Zа-яА-Я]*[0-9]*[а-яА-Я]+[a-zA-Z]+[a-zA-Zа-яА-Я]*");
        Pattern pattern5 = Pattern.compile("[a-zA-Zа-яА-Я]*[a-zA-Z]+[0-9]*[а-яА-Я]+[a-zA-Zа-яА-Я]*");
        Pattern pattern6 = Pattern.compile("[a-zA-Zа-яА-Я]*[а-яА-Я]+[a-zA-Z]+[0-9]*[a-zA-Zа-яА-Я]*");
        String[] parts = str.split("[,.;:!?()\\s]+");
        for (String p : parts){
            if ((pattern1.matcher(p).matches() | pattern2.matcher(p).matches() | pattern3.matcher(p).matches() | pattern4.matcher(p).matches() | pattern5.matcher(p).matches() | pattern6.matcher(p).matches())){
                string += "[" + p + "] ";
//            }else{
//                string += "kek ";
            }
        }
        return string.trim().replace(" ", ", ");
    }



     */
