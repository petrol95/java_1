class HomeWork1 {
    byte b = 1;
    short s = 1;
    int i = 5;
    long l = 5;
    double d = 1.1;
    float f = 1.1f;
    char c = 'a';
    boolean bol = true;
        
    public static float calculate(float a, float b, float c, float d) {
        return a * (b + c / d);
    }
    
    public static boolean checkSum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }
    
    public static void printNumberSign(int i) {
        System.out.println((i < 0) ? "negative" : "positive");
    }
    
    public static boolean checkNegative(int i) {
        return i < 0;
    }
    
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }
    
    public static void isLeap(int year) {
        String s = "not ";
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            s = "";
        System.out.println("The year " + year + " is " + s + "leap");
    }

    public static void main(String[] args) {
        System.out.println(calculate(2.1f, 3.2f, 4.1f, 5.2f));
        System.out.println(checkSum(5, 15));
        printNumberSign(-30);
        System.out.println(checkNegative(-15));
        greet("Olga");
        isLeap(1900);
        }
}
