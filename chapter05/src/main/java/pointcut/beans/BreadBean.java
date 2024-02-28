package pointcut.beans;

import pointcut.annotations.SimpleAnnotationRequired;

public class BreadBean implements EaterBean {

    public void eatChocoBread() {
        System.out.println(":::::: Eat a Choco Bread! ::::::");
    }

    public void eatBerryBread() {
        System.out.println(":::::: I don't like a Berry Bread... ::::::");
    }

    public void eatCheeseBread() {
        System.out.println(":::::: Eat a Cheese Bread! ::::::");
    }

    @SimpleAnnotationRequired
    public void eatBreadWithMilk(ChocoBean chocoBean)  {
        System.out.println("I eat choco with : " + chocoBean.drinkMilk());
    }

    public void sleep() {
        System.out.println("zzZ...");
    }
}
