import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* cheking the light does SOMETHING
        System.out.println("i exist");
        Light testlys = new Light();
        System.out.println(testlys.onOff);
        testlys.click();
        System.out.println(testlys.onOff);
         */

        /* chekking Light's functionalety
        Light first = new Light(true);
        Light second = new Light(false);
        Light third = new Light(false);
        Light forth = new Light(false);
        Light fifth = new Light(true);


        first.setLeft(fifth);
        first.setRight(second);

        second.setLeft(first);
        second.setRight(third);

        third.setLeft(second);
        third.setRight(forth);

        forth.setLeft(third);
        forth.setRight(fifth);

        fifth.setLeft(forth);
        fifth.setRight(first);

        System.out.println(first.onOff + " " + second.onOff + " " + third.onOff + " " + forth.onOff + " " + fifth.onOff);

        third.flip();

        System.out.println(first.onOff + " " + second.onOff + " " + third.onOff + " " + forth.onOff + " " + fifth.onOff);

         */

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
        /*      testing that neibors are propperly asigned
        int i = 0;
        System.out.println("array spot nr " + lyslenke[i].getArrayposition() + "  is "+  lyslenke[i].onOff + " its neibors are " + lyslenke[i].left.arrayposition +
                " on the left, and " + lyslenke[i].right.arrayposition + " on the right");
        i = 3;
        System.out.println("array spot nr " + lyslenke[i].getArrayposition() + "  is "+  lyslenke[i].onOff + " its neibors are " + lyslenke[i].left.arrayposition +
                " on the left, and " + lyslenke[i].right.arrayposition + " on the right");

        i = 5;
        System.out.println("array spot nr " + lyslenke[i].getArrayposition() + "  is "+  lyslenke[i].onOff + " its neibors are " + lyslenke[i].left.arrayposition +
                " on the left, and " + lyslenke[i].right.arrayposition + " on the right");

        i = 7;
        System.out.println("array spot nr " + lyslenke[i].getArrayposition() + "  is "+  lyslenke[i].onOff + " its neibors are " + lyslenke[i].left.arrayposition +
                " on the left, and " + lyslenke[i].right.arrayposition + " on the right");

 */

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

                    if (lyslenke[i].onOff){
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
            if (chain[i].onOff == false){
                output = false;
            }
        }
        return output;
    }
}
