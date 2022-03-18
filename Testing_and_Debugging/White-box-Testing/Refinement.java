@Test
public void balancedUnbalanced() {
  IStack stack = new LinkStack<Character>();
  pm = new ParenMatch("()", stack);
  assertTrue(pm.parenMatch());
  pm = new ParenMatch(")", stack);
  assertFalse(pm.parenMatch());
}
/**
Testing	Debugging
Testing can be manual or automated.	Debugging is always manual. Debugging can't be automated.
It is based on different testing levels i.e. unit testing, integration testing, system testing etc.	Debugging is based on different types of bugs.
*/
