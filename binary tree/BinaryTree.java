import java.util.Arrays;

public class BinaryTree {

	private TreeNode root;
	private Integer size;

	public void BinaryTree() {

		this.root = new TreeNode();
		this.size = 0;

	}

	public void BinaryTree( Integer inputData ) {

		this.root = new TreeNode( inputData );
		this.size = 1;

	}

	public void BinaryTree( Integer[] inputData ) {

		this.root = new TreeNode( inputData[0] );
		this.size = 1;
		this.add( Arrays.copyOfRange( inputData, 1, inputData.length - 1 ) );

	}

	public void add( Integer inputData ) {

		// check if the root node is null
		if ( root.getData() == null ) {
			this.root = new TreeNode( inputData );
			return;
		} else {

			TreeNode current = this.root;

			TreeNode newNode = new TreeNode( inputData );

			while ( true ) {

				// reject duplicates
				if ( current.getData().equals( inputData ) ) {
					return;
				} 

				if ( inputData < current.getData() ) {
					if ( current.getLeft() == null ) {
						current.setLeft( newNode );
						newNode.setParent( current );
						this.size++;
						return;
					} else {
						current = current.getLeft();
					}
				} else {
					if ( current.getRight() == null ) {
						current.setRight( newNode );
						newNode.setParent( current );
						this.size++;
						return;
					} else {
						current = current.getRight();
					}

				}

			}

		}

	}

	public void add( Integer[] inputData ) {

		for ( Integer i : inputData ) {
			this.add( i );
		}

	}
	
	private class TreeNode {

		private Integer data;
		private TreeNode left;
		private TreeNode right;
		private TreeNode parent;

		public TreeNode() {

			this.data = null;
			this.left = null;
			this.right = null;
			this.parent = null;

		}

		public TreeNode( Integer inputData ) {

			this.data = inputData;
			this.left = null;
			this.right = null;
			this.parent = null;

		}

		public Integer getData() {
			return data;
		}

		public void setData( Integer inputData ) {
			this.data = inputData;
		}

		public TreeNode getLeft() {
			return left;
		} 

		public void setLeft( TreeNode inputNode ) {
			this.left = inputNode;
		}

		public TreeNode getRight() {
			return right;
		} 

		public void setRight( TreeNode inputNode ) {
			this.right = inputNode;
		}

		public TreeNode getParent() {
			return parent;
		} 

		public void setParent( TreeNode inputNode ) {
			this.parent = inputNode;
		}

	}

}