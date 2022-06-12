class Hannoi {
    public static int calculation(int n, char x, char y, char z){
        int ans = 1;
        if(n == 1){
            System.out.println("move 1 from "+ x +" to "+ z);
            return ans;
        }else {
            ans += calculation(n-1, x, z, y);
            System.out.println("move "+ n +" from " + x + " to "+z );
            ans += calculation(n-1,y, x, z);
            return ans;
        }

    }
    public static void main(String[] args) {
        System.out.println(calculation(3,'x','y','z'));
    }
}