@Test
public void unbalancedBalanced() {
  IStack stack = new LinkStack<Character>();
  pm = new ParenMatch("(", stack);
  assertFalse(pm.parenMatch());
  pm = new ParenMatch("()", stack);
  assertTrue(pm.parenMatch());
  /**parenthesis ist nicht falsch
  */
  
}
