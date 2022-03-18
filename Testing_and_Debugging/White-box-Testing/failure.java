@Test
public void multipleLines() {
  IStack stack = new LinkStack<Character>();
  pm = new ParenMatch("(hello) (world)", stack);
  assertTrue(pm.parenMatch());
  pm = new ParenMatch("static public void main(String args[]) {", stack);
  assertFalse(pm.parenMatch());
  pm = new ParenMatch("()", stack);
  assertTrue(pm.parenMatch());
  pm = new ParenMatch("}", stack);
  assertFalse(pm.parenMatch());
}
