import java.util.*;

class NumberCombination {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> answers = new ArrayList();
        Arrays.sort(candidates);
        dfs(answers, new ArrayList(), candidates, target, 0);
        return answers;
    }

    public void dfs(List<List<Integer>> answers, List<Integer> temp, int[] candidates, int target, int index) {
        if(target < 0) return;

        if(target == 0) {
            answers.add(new ArrayList(temp));
            return;
        }

        for(int i=index; i< candidates.length; i++) {
            if(i>index && candidates[i]==candidates[i-1]) continue;
            temp.add(candidates[i]);
            dfs(answers, temp, candidates, target-candidates[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}
