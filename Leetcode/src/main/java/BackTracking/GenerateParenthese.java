package BackTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        add("(",1,0,res,n);
        return res;
    }

    private void add(String s, int left, int right, List<String> res, int n) {
        if (s.length()==2*n){
            res.add(s);
            return;
        }
        if (left<n){
            add(s+"(",left+1,right,res,n);
        }
        if (right<left){
            add(s+")",left,right+1,res,n);
        }
    }
    @Test
    public void test(){
        GenerateParenthese ge = new GenerateParenthese();
        List<String> strings = ge.generateParenthesis(5);
        System.out.println(strings);
    }
}
