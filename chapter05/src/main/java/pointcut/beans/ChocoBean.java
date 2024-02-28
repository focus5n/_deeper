package pointcut.beans;

public class ChocoBean implements SimpleBean {

    public void choco(int x) {
        System.out.println("Invoked choco() with : " + x);
    }

    public void milk() {
        System.out.println("Invoked milk()");
    }

    public String drinkMilk() {
        return "milk!";
    }
}
