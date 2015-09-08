package Search;

import java.util.Random;

public class Treap {
	
	Random random = new Random();
	
	int key;
	long priority;
	String value;
	Treap left;
	Treap right;
	int count;

	public Treap(int key, String value) {
	  	
	    this.key = key;
	    this.value = value;
	    priority = random.nextLong();
	    count = 1;
	}  

	void update() {
	  	
		count = 1 + getCount(left) + getCount(right);
	}


	static int getCount(Treap root) {
		  
	  return root == null ? 0 : root.count;
	}

	static class TreapPair {
		  
	  Treap left;
	  Treap right;

	  TreapPair(Treap left, Treap right) {
	  	
	    this.left = left;
	    this.right = right;
	  }
	}

	static private TreapPair split(Treap root, int minRight) {
		
	  if (root == null) {
		  
	    return new TreapPair(null, null);
	  }
	  
	  if (root.key >= minRight) {
		  
	    TreapPair leftSplit = split(root.left, minRight);
	    root.left = leftSplit.right;
	    root.update();
	    leftSplit.right = root;
	    return leftSplit;
	  } 
	  else {
		  
	    TreapPair rightSplit = split(root.right, minRight);
	    root.right = rightSplit.left;
	    root.update();
	    rightSplit.left = root;
	    return rightSplit;
	  }
	}

	static private Treap merge(Treap left, Treap right) {
		
	  if (left == null) {
		  
	    return right;
	  }
	  if (right == null) {
		  
	    return left;
	  }
	  if (left.priority > right.priority) {
		  
	    left.right = merge(left.right, right);
	    left.update();
	    return left;
	  } 
	  else {
		  
	    right.left = merge(left, right.left);
	    right.update();
	    return right;
	  }
	}

	static public Treap add(Treap root, Record rec) {
		
		int x = rec.getPhone();
		String value = rec.getName();
		  
		TreapPair t = split(root, x);
		return merge(merge(t.left, new Treap(x, value)), t.right);
	}

	static public String get(Treap root, int key) {
		  
		if(root == null) {
			
			return "";
		}
		if(key == root.key) {
			  
			return root.value;
		}
		else if(key < root.key) {
			  
			return get(root.left, key);
		}
		else {
			  
			return get(root.right, key);
		}  
	}

	
	static public Treap remove(Treap root, int x) {
		
	  if (root == null) {
		 
		  return null;
	  }
	  if (x < root.key) {
		  
		
	    root.left = remove(root.left, x);
	    root.update();
	    return root;
	  } 
	  else if (x > root.key) {
		
	    root.right = remove(root.right, x);
	    root.update();
	    return root;
	  } 
	  else {
		  
	    return merge(root.left, root.right);
	  }
	}
}