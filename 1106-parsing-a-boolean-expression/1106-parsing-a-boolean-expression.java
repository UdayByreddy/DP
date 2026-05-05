class Solution {
    int i=0;
    public boolean parseBoolExpr(String expression) {
        return parse(expression);        
    }
    public boolean parse(String exe){
        if(exe.charAt(i)=='t'){ i++; return true;}
        if(exe.charAt(i)=='f') { i++; return false;}
        char op = exe.charAt(i);
        i+=2;
        if(op=='!'){
            boolean res = !parse(exe);
            i++;
            return res;
        }
        boolean res = op=='&'?true:false;
        while(true){
            boolean val = parse(exe);
            if(op=='&'){
                res = res&val;
            }
            else{
                res = res|val;
            }
            if(exe.charAt(i)==')') {
                i++;
                break;
            }
            i++;
        }
        return res;
    }
}