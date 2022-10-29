import javax.xml.transform.Result;
import java.util.Scanner;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static boolean itIsQuote(String s) throws scannerExept {//проверка на кавычки с двух сторон
        char []ch = s.toCharArray();
        if((ch[0]=='\"')&&(ch[ch.length-1] =='\"')){
            return true;
        } else throw new scannerExept("что то  должно быть в кавычках с двух сторон");
    }



    public static void main(String[] args)throws scannerExept {
        Scanner console = new Scanner(System.in);
        String myString = new String(console.nextLine());
        char simvol;
        String[]slova;
        if(myString.contains(" + ")){// определяю знак и запомниаю его
            slova = myString.split(" \\+ ");
            simvol = '+';
        }else
            if(myString.contains(" - ")){
            slova = myString.split(" - ");
            simvol = '-';
        }else
            if (myString.contains(" * ")){
                slova = myString.split(" \\* ");
                simvol = '*';
            }else if (myString.contains(" / ")){
                slova = myString.split(" / ");
                simvol = '/';
            }else throw new scannerExept("странный знак");
        if (simvol == '*' || simvol == '/') {// определил знак, решаю по нему
            if (slova[1].contains("\"")) throw new scannerExept("умножение и деление только строки на число без кавычек");
            if (itIsQuote(slova[0])==true);
            if ((Integer.parseInt(slova[1]) <1) && (Integer.parseInt(slova[1]) > 10)) throw new scannerExept("Числа от 1 до 10");
            for (int i=0;i<slova.length;i++){
                slova[i] = slova[i].replaceAll("\"","");//удаляю кавычки
            }
            IntString pop = new IntString(slova[0],Integer.parseInt(slova[1]));//создаю объект своего класса
            if (simvol == '*') {
                System.out.print("\"" + pop.mult() + "\"");// вывод должен бытьв кавычках
            }
            else {
                System.out.print("\""+pop.del()+"\"");
            }
            }
        if (simvol == '-' || simvol == '+'){// определил знак, решаю по нему
            if (itIsQuote(slova[0])==true && itIsQuote(slova[1])==true);
            for (int i=0;i<slova.length;i++){
                slova[i] = slova[i].replaceAll("\"","");
            }
            ForString kop = new ForString(slova[0],slova[1]);//создаю объекст своего класса
            if (simvol=='+')
                System.out.print("\""+kop.plus()+"\"");
            else
                System.out.print("\""+kop.minus()+"\"");
        }
    }
}




     class ForString {//для работы со строками
        String a;
        String b;


        public ForString(String x, String z) {
            this.a = x;
            this.b = z;
        }

        public String plus() {
            String Result = new String();
            Result = this.a + this.b;
            if (Result.length()>40){//ограничиваю по кол-ву знаков
            Result = Result.substring(0,40);
            Result+="...";// добавляю .. на выходе
            }
            return Result ;
        }

        public String minus() {
            String Result = new String();
            Result = this.a.replaceAll(this.b,"");
            if (Result.length()>40){
                Result = Result.substring(0,40);
                Result+="...";
            }
            return Result;
        }

    }





     class IntString {// если есть число
        String a;
        int b;

        public IntString(String x, int z) {
            this.a = x;
            this.b = z;
        }
        public String mult() {
            String Result = new String();
            Result = this.a.repeat(this.b);
            if (Result.length()>40){
                Result = Result.substring(0,40);
                Result+="...";
            }
            return Result;
        }
        public String del() {
            String Result = new String();
            char[] slovo = this.a.toCharArray();
            int x = slovo.length / this.b;
            for(int i = 0; i <x;i++)
            Result += slovo[i];
            if (Result.length()>40){
                Result = Result.substring(0,40);
                Result+="...";
            }
            return Result;
        }
    }
