import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Light lyslenke[] = new Light[8];
        int moves = 0;
        Light first = new Light();
        Light nekst = new Light();
        Light last = new Light();
        first.setLeft(last);
        first.setRight(nekst);
        nekst.setLeft(first);

        for (int i=0; i<lyslenke.length; i++){
            lyslenke[i] = nekst;
            nekst = new Light();
            nekst.setLeft(lyslenke[i]);
            lyslenke[i].setRight(nekst);

            //testing value
            lyslenke[i].setArrayposition(i);

            //System.out.println("light " + i + " is " + lyslenke[i].onOff);
        }
        last.setRight(first);
        lyslenke[0].setLeft(lyslenke[(lyslenke.length-1)]);

        // lag en while loop som leser input, skriver ut det nåværende resultat og når alle Lamp i arrayet er true avslutter
        while (chainOfLightsOn(lyslenke) == false){
            Scanner input = new Scanner(System.in);
            int target = (input.nextInt()-1);


            if (target > (lyslenke.length-1) || target < 0){
                System.out.println("Invalid value, please try again");
            }else{
                lyslenke[target].flip();

                String display = "Lamp numbers: ";
                String output =  "Lamp light:   ";
                // gå igjennom hele listen, bygg Stringene display og output ettervært som du går igjennom
                for (int i=0; i<lyslenke.length; i++){


                    display = display + " " + (i + 1);

                    if (lyslenke[i].getOnOff()){
                        output = output + " 1";
                    }else {
                        output = output + " 0";
                    }
                }
                System.out.println(display);
                System.out.println(output);
                moves++;
            }

        }
        System.out.println("You finished the game in " + moves + " moves.");
        System.out.println("You winn!");


    }

    // metode som tar inn et array med Light og sjekker om de alle er på
    public static boolean chainOfLightsOn(Light[] chain){
        boolean output = true;
        for (int i=0; i<chain.length; i++){
            if (chain[i].getOnOff() == false){
                output = false;
            }
        }
        return output;
    }
}
