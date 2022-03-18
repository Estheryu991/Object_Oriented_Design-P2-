public boolean parenMatch() {
  for (int i=0; i<line.length(); i++) { 
    char c = line.charAt(i); 
    if (isLeftParen(c)) { 
      stack.push(matchingRightParen(c));
    }
    else if (isRightParen(c)) {
      if (stack.isEmpty()) { 
        return false; 
      }
      if (stack.top().equals(c)) { 
        stack.pop(); 
      } else { return false; } 
      }
     } return stack.isEmpty(); 
}
