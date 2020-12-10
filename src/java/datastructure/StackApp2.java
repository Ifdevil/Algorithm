package datastructure;

/**
 * 中缀表达式转后缀表达式
 * 后缀表达式求值(适合多位数)
 */
public class StackApp2 {

    private Stack theStack;
    private Stack exStack;
    private String output = "";


    public static void main(String[] args) {
        StackApp2 app = new StackApp2();
        String ex = "1+2*4/2+15/3";
//        app.doTrans(ex);
        app.expEvaluation(app.doTrans(ex));

    }

    /**
     * 中缀表达式转换为后缀表达式
     * @param str
     * @return
     */
    public String doTrans(String str) {
        char[] chars = str.toCharArray();
        theStack = new Stack(chars.length);
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    while (i<chars.length && chars[i]>'0' && chars[i]<'9'){
                        output = output+ chars[i] ;
                        i++;
                    }
                    output = output+ '#' ;
                    i--;
                    break;
            }
        }
        while (!theStack.isEmpty()){
            output = output + theStack.pop();
        }
        System.out.println(output);
        return output;
    }

    /**
     * 根据优先级，计算栈顶的两个数
     * @param opThis
     * @param prec1
     */
    public void gotOper(char opThis, int prec1) {
        while (!theStack.isEmpty()){
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            }
            else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if(prec2 < prec1){
                    theStack.push(opTop);
                    break;
                }else{
                    output = output + opTop;
                }
            }
        }
        theStack.push(opThis);
    }

    public void gotParen(char ch){
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(')
                break;
            else
                output = output + chx;
        }
    }

    /**
     * 计算后缀表达式的值
     * @param ex
     * @return
     */
    public int expEvaluation(String ex){
        int num = 0;
        exStack = new Stack(ex.length());
        for (int i = 0; i < ex.length(); i++) {
            char ch = ex.charAt(i);
            switch (ch){
                case '+':
                case '-':
                case '*':
                case '/':
                    if(!exStack.isEmpty()){
                        int n = (int)(exStack.pop()-'0');
                        int m = (int)(exStack.pop()-'0');

                        if(ch == '+') num = m+n;
                        if(ch == '-') num = m-n;
                        if(ch == '*') num = m*n;
                        if(ch == '/') num = m/n;
                        exStack.push((char) (num +'0'));
                        break;
                    }
                case '#':
                    continue;
                default:
                    int temp = 0;
                    while (ex.charAt(i)>'0'&& ex.charAt(i)<'9'){
                        temp = temp *10 + (int)(ex.charAt(i) - '0');
                        i++;
                    }
                    exStack.push((char)(temp+'0'));
                    break;

            }
        }
        System.out.println(num);
        return num;
    }
}

class Stack{

    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }
    public char pop() {
        return stackArray[top--];
    }
    public char peek() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
}