import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BTree {
	BTreeNode root;
	RandomAccessFile newFile;
	long degree;

	BTree(long k, String fname) throws IOException {
		newFile = new RandomAccessFile(fname, "rw");
		root = createNode(newFile,k);
	}

	public void BTreeInsert(long k) throws IOException {
		if (root.fileOffset == root.children.length) {
			BTreeNode newNode = createNode(newFile, k);
			newNode.isLeaf = false;
			newNode.numkey = 0;
			newNode.children[0] = root.key[0];
			BTreeInsertNonFull(newNode, k);
		} else {
			BTreeInsertNonFull(root, k);
		}
	}

	public String BTreeFind(File f, long k) {
		return " ";
	}

	public BTreeNode createNode(RandomAccessFile file, long k) throws IOException {
		BTreeNode result = new BTreeNode(k);
		file.setLength(newFile.length());
		result.writeNode(file);
		result.numkey=k;
		return result;
	}

	private void BTreeInsertNonFull(BTreeNode x, long k) {
		long i = x.numkey;
		if (x.isLeaf) {
				x.key[(int) i -1] = x.key[(int) i];
				i--;
				x.key[(int) i + 1] = k;
				x.numkey++;
		} else {
				if (x.children[(int) i] == x.children.length) {

				}
				if (k > x.key[(int) i]) {
					i++;
				}
		}
	}

	private void BTreeSplitChild(BTreeNode x, long k) {
		BTreeNode newNode;
	}
}
