
class EditDistance {
  public int minEditOps(String s1, String s2, int s1i, int s2j)
  {
    if (s1.length() == s1i && s2.length() == s2j) return 0;
    if (s1i == s1.length()) return s2.length() - s2j;
    if (s2j == s2.length()) return s1.length() - s1i;
    
    if (s1.charAt(s1i) == s2.charAt(s2j)) {
		return minEditOps(s1, s2, s1i+1, s2j+1);
    }
    int delete = 1 + minEditOps(s1, s2, s1i+1, s2j);
    int insert = 1 + minEditOps(s1, s2, s1i, s2j+1);
    int replace = 1 + minEditOps(s1, s2, s1i+1, s2j+1);
    return Math.min(delete, Math.min(insert, replace));
  }
  
  public static void main(String[] args) {
    EditDistance ed = new EditDistance();
    String s1 = "passpot";
    String s2 = "ppsspqrt";
    int minSteps = ed.minEditOps(s1, s2, 0, 0);
    System.out.println(minSteps);
  }
}
