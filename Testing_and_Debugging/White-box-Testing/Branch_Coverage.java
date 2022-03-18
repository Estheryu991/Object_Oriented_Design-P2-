public boolean parenMatch() {
    for (int i=0; i<line.length(); i++) { (1)
      char c = line.charAt(i); (2)
      if (isLeftParen(c)) { (3)
        stack.push(matchingRightParen(c)); (4)
}
      else if (isRightParen(c)) { (5)
        if (stack.isEmpty()) { (6)
          return false; (7)
}
        if (stack.top().equals(c)) { (8)
          stack.pop(); (9)
        } else { return false; } (10)
}
      } return stack.isEmpty(); (11)
}
