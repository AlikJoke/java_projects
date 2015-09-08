package BinaryTree;

public class BinaryTree {

	int data;
	BinaryTree left, right;
	int key;
	
	public BinaryTree(int key, int data) {
		
		left = right = null;
		this.data = data;
		this.key = key;
	}
	
	public void add(BinaryTree root, int key, int data) {
		
		if(root == null) {
			
			root = new BinaryTree(key, data);
		}	else if(root.data < data) {
			
				if(root.right == null) {
					
					root.right = new BinaryTree(key, data);
				}	else {
				
					add(root.right, key, data);
				}
			}	else if(root.data > data) {
				
				if(root.left == null) {
					
					root.left = new BinaryTree(key, data);
				} else {
					
					add(root.left, key, data);
					}
				}
	}
	
	public void search(BinaryTree root, int key) {
		
		if(root == null) {
			
			return;
		}
		
		if(key == root.key) {
			
			System.out.println(root.data);
		}	else if(key > root.key) {
			
			search(root.right, key);
		}	else if(key < root.key) {
			
			search(root.left, data);
		}
	}
	
	public void traverce() {
		
		if(left != null) {
			
			left.traverce();
		}
		
		if(right != null) {
			
			right.traverce();
		}
		
		System.out.println(data);
	}
	/*
	private int rightmost(BinaryTree root) {
		
		while(root.right != null) {
			
			root = root.right;
		}
		
		return root.key;
	}
	
	public BinaryTree remove(BinaryTree root, int key) {
		
		if(root == null) {
			
			return null;
		}
		if(root.key == key) {
			
			if(root.right == null && root.left == null) {
				
				return null;
			}
			
			if(root.right == null && root.left != null) {
				
				BinaryTree node = root.left;
				return node;
			}
			
			if(root.left == null && root.right != null) {
				
				BinaryTree node = root.right;
				return node;
			}
			
			root.key = rightmost(root.left);
			root.left = remove(root.left, key);
			return root;
		}else
		if(key < root.key) {
			
			root.left = remove(root.left, key);
			return root;
		}else
		if(key > root.key) {
			
			root.right = remove(root.right, key);
			return root;
		}
		
		return root;
	}*/
	
	
	public BinaryTree remove(int key, BinaryTree root) {
		
		if(root == null) {
			
			return null;
		}
		
		if(key > root.key) {
			
			root.right = remove(key, root.right);
		}
		else if(key < root.key) {
			
			root.left = remove(key, root.left);
		}
		else if(root.left != null && root.right != null) {
				
			root.key = findMin(root.right).key;
			root.right = removeMin(root.right);
		}
		else {
			
			root = (root.left != null) ? root.left : root.right;
		}
		
		return root;
	}
	
	protected BinaryTree removeMin(BinaryTree root) {
		
		if(root == null) {
			
			return null;
		}
		else if(root.left != null) {
			
			root.left = removeMin(root.left);
			return root;
		}
		else {
			
			return root.right;
		}
	}
	
	protected BinaryTree findMin(BinaryTree root) {
		
		if(root != null) {
			
			while(root.left != null) {
				
				root = root.left;
			}
		}
		
		return root;
	}
	
	
	public static void main(String[] args) {
		
		
	}
}
