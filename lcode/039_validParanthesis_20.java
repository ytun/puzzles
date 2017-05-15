import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

  public class Solution {

    public boolean isValid(String s){

      Stack<Character> stack = new Stack<Character>();
      char c='\0';

      for(int i=0; i<s.length(); i++){
        c = s.charAt(i);

        if(c=='{'){
          stack.push('}');
        }
        else if(c=='['){
          stack.push(']');
        }
        else if(c=='('){
          stack.push(')');
        }
        //mismatch
        else if(stack.isEmpty() || stack.pop()!=c){
          return false;
        }
      }
      return stack.isEmpty();
      
    }


    public boolean isValid_melong(String s){

      Stack<Character> stack = new Stack<Character>();

      Set<Character> open = new HashSet<Character>(Arrays.asList(new Character[]{'{', '(', '['}));
      Set<Character> close = new HashSet<Character>(Arrays.asList(new Character[]{'}', ')', ']'}));

      char c='\0';

      for(int i =0; i<s.length(); i++){
        c = s.charAt(i);

        if(open.contains(c)){
          stack.push(c);
        }
        else if(close.contains(c)){ //illegal if mismatch {] 
          //ascii diff for mismatch - 1 or 2
          //already checked if contains in close so can't be other letters
          // {123 - }125
          // (40 - )41
          // [91 - ]93

          if(stack.isEmpty()){
            return false;
          }

          int diff =(int)c - (int)(stack.peek()); 
      
          if(diff==1 | diff==2){
            stack.pop();
          }
          else{
            return false;
          }
        }
      }

      if(stack.isEmpty()){
        return true;
      }
      return false;
    }


    public static void main(String[] args){

      Solution sol = new Solution();
      String[] arr = { "()[]{}", "(]", "", "[(()){}]" , "[", "]" };

      for(String s: arr){
        System.out.println(sol.isValid(s));
      }

    }

}

















