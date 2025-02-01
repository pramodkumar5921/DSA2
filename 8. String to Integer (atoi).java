class Solution {
    public int myAtoi(String s) {
        StringBuilder str = new StringBuilder();
        boolean sign = false;
        boolean plus = false;
        for (int i = 0; i < s.length(); i++) {
            if ((str.length()>0 || sign==true || plus==true) && s.charAt(i) == ' ') {
                  break;
            } 
            if (str.length()==0 && s.charAt(i) == ' ') {
                continue;
            } 
            else if ((sign == true || plus == true) && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                break;
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                break;
            } else if (str.length() > 0 && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                break;
            } else if (s.charAt(i) == '.') {
                break;
            } else if (str.length() == 0 && s.charAt(i) == '-') {
                sign = true;
                 continue;
            } else if (plus == false && s.charAt(i) == '+') {
                plus = true;
                 continue;
            }

            else {
                str.append(s.charAt(i));
            }
        }

         System.out.print(str);

        String res = str.toString();
        if (res.length() == 0) {
            return 0;
        }
        long ans = 0;
        for (int i = 0; i < res.length(); i++) {
            int lastDigit = (int) res.charAt(i) - '0';
            ans = ans * 10 + lastDigit;

            if (ans > Integer.MAX_VALUE && sign == true) {
                return Integer.MIN_VALUE;
            }

            if (ans > Integer.MAX_VALUE && sign == false) {
                return Integer.MAX_VALUE;
            }
        }
        int res1 = (int) ans;
        if (sign == true) {
            res1 = res1 * -1;
        }

        return res1;
    }
}
