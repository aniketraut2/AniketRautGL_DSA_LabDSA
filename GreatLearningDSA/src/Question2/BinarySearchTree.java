package Question2;

//Java code to find a pair with given sum
//in a Balanced BST
import java.util.ArrayList;
import java.util.Scanner;

//A binary tree node
class Node {

	int data;
	Node leftNode, rightNode;

	Node(int nodeData) {
		data = nodeData;
		leftNode = rightNode = null;
	}
}

public class BinarySearchTree {

	// Root of BST
	Node root;

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// Inorder traversal of the tree
	public void inorder() {
		inorderUtil(this.root);
	}

	// Utility function for inorder traversal of the tree
	public void inorderUtil(Node node) {
		if (node == null)
			return;

		inorderUtil(node.leftNode);
		System.out.print(node.data + " ");
		inorderUtil(node.rightNode);
	}

	// This method mainly calls insertRec()
	public void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	public Node insertRec(Node root, int data) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(data);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (data < root.data)
			root.leftNode = insertRec(root.leftNode, data);
		else if (data > root.data)
			root.rightNode = insertRec(root.rightNode, data);

		return root;
	}

	// Method that adds values of given BST into ArrayList
	// and hence returns the ArrayList
	ArrayList<Integer> treeToList(Node node, ArrayList<Integer> list) {
		// Base Case
		if (node == null)
			return list;

		treeToList(node.leftNode, list);
		list.add(node.data);
		treeToList(node.rightNode, list);

		return list;
	}

	// method that checks if there is a pair present
	public boolean isPairPresent(Node node, int target) {

		// This list a1 is passed as an argument
		// in treeToList method
		// which is later on filled by the values of BST
		ArrayList<Integer> a1 = new ArrayList<>();

		// a2 list contains all the values of BST
		// returned by treeToList method
		ArrayList<Integer> a2 = treeToList(node, a1);

		int start = 0; // Starting index of a2

		int end = a2.size() - 1; // Ending index of a2

		while (start < end) {

			if (a2.get(start) + a2.get(end) == target) // Target Found!
			{
				System.out.println("Pair Found : " + a2.get(start) + " + " + a2.get(end) + " " + "= " + target);
				System.out.println("Pair is (" + a2.get(start) +", " + a2.get(end) + ")");
				return true;
			}

			if (a2.get(start) + a2.get(end) > target) // decrements end
			{
				end--;
			}

			if (a2.get(start) + a2.get(end) < target) // increments start
			{
				start++;
			}
		}

		System.out.println("Nodes are not found.");
		return false;
	}

	// Driver function
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Sum : ");
			int sum = sc.nextInt();
			BinarySearchTree findSum = new BinarySearchTree();

			findSum.insert(40);
			findSum.insert(20);
			findSum.insert(60);
			findSum.insert(10);
			findSum.insert(30);
			findSum.insert(50);
			findSum.insert(70);

			findSum.isPairPresent(findSum.root, sum);
		}
	}
}
