package src.output;

public class Prompt {
    public static void addedExistedSysMed() {
        System.out.println("Ooops!! this drug is already in the store \nadditional quantity will be added.");
    }

    public static void printDashline() {
        String dashLine =  "--------------------------------------------------------------------";
        System.out.println(dashLine);
    }
    public static void showTitle(String title){
        System.out.println("====================================================================");
        System.out.println("                           "+title+"                                ");
        System.out.println("====================================================================");
    }
    public static void askToInput(String toInput){
        System.out.println("Please,Enter "+toInput+" : ");
    }
}
