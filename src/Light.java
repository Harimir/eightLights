public class Light {
    boolean onOff;
    Light right;
    Light left;

    // arrayposition and its methods are not nessesary but are kept so as to make sense of out-comented testing code in Main
    public int getArrayposition() {
        return arrayposition;
    }

    public void setArrayposition(int arrayposition) {
        this.arrayposition = arrayposition;
    }

    int arrayposition;

    public void click(){
        if (onOff == false){
            this.onOff = true;
        } else if (onOff == true) {
            this.onOff = false;
        }
    }

    public void flip(){
        this.click();
        right.click();
        left.click();
    }

    Light(){
        this.onOff = false;
    }

    Light(boolean onOff){
        this.onOff = onOff;
    }

    Light(boolean onOff, Light right, Light left){
        this.onOff = onOff;
        this.right = right;
        this.left = left;
    }

    public void setRight(Light right) {
        this.right = right;
    }

    public void setLeft(Light left) {
        this.left = left;
    }

    public boolean getOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
}
