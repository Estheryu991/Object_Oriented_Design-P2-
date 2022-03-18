@Test
public void unbalancedBalanced() {
  IStack stack = new LinkStack<Character>();
  pm = new ParenMatch("(", stack);
  assertFalse(pm.parenMatch());
  pm = new ParenMatch("()", stack);
  /**Indeed, the closing bracket “)” to be
expected by the previous call to
parenMatch() is still on our stack.*/
  assertTrue(pm.parenMatch());
}
