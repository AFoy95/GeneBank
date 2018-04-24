import java.io.IOException;
import java.io.RandomAccessFile;


public class BTreeNode {
	long key[];
	long fileOffset;
	long children [];
	long freq[];
	long numkey;
	boolean isLeaf;
	long degree;

	public BTreeNode(long k){
	key=new long[2*(int)k];	
	children=new long[(2*(int)k)-1];
	freq=new long[(2*(int)k)-1];
	degree=k;
	numkey=0;
	isLeaf=true;
	}
	public void writeNode(RandomAccessFile file) throws IOException{
	fileOffset=file.length();
	file.seek(fileOffset);
	file.writeLong(fileOffset);
	for(int i=0;i<children.length;i++)
	{
		file.writeLong(children[i]);
	}

	}
	public void readNode(RandomAccessFile file) throws IOException{
		file.seek(fileOffset);
		long afo=file.readLong();
		for(int i=0;i<children.length;i++)
		{
			children[i]=file.readLong();
		}
	}
}
