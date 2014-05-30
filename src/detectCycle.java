import java.util.*;

enum Color {
	Green, Red, white
}
class Graphnode<T> {
	// *** fields ***
	public T data;
	public List<Graphnode<T>> successors = new ArrayList<Graphnode<T>>();
	// *** methods ***
	Color temp = Color.white;
}
public class detectCycle {
	public static void main (String [] args)
	{
		Graphnode<Integer> node1 = new Graphnode<Integer>();
		Graphnode<Integer> node2 = new Graphnode<Integer>();
		Graphnode<Integer> node3 = new Graphnode<Integer>();
		Graphnode<Integer> node4 = new Graphnode<Integer>();
		Graphnode<Integer> node5 = new Graphnode<Integer>();
		Graphnode<Integer> node6 = new Graphnode<Integer>();
		Graphnode<Integer> node7 = new Graphnode<Integer>();
		Graphnode<Integer> node8 = new Graphnode<Integer>();
		Stack<Graphnode<Integer>> ourBucket = new Stack<Graphnode<Integer>>();
		node1.successors.add(node2);
		node1.successors.add(node3);
		node2.successors.add(node4);
		node4.successors.add(node3);
		node4.successors.add(node5);
		node5.successors.add(node6);
		node7.successors.add(node6);
		node7.successors.add(node5);

		ourBucket.push(node1);

		if(detectCycle(ourBucket))
		{
			System.out.println("cycle detected");
		}
		else
		{
			System.out.println("no cycle detectecd");
		}

	}




	public static boolean detectCycle(Stack<Graphnode<Integer>> bucket )
	{
		while (!bucket.isEmpty())
		{

			Graphnode<Integer> popOut =  bucket.peek() ; 
			if(popOut.temp==Color.white)
			{
				popOut.temp = Color.Green;
				for(Graphnode<Integer> succ :popOut.successors )
				{
					if(succ.temp== Color.Green)
					{

						return true;
					}
					if(succ.temp!=Color.Red)
						bucket.push(succ);
				}
			}
			else if(popOut.temp == Color.Green)
			{
				popOut.temp = Color.Red;
				bucket.pop();
			}
		}
		return false;


	}

}
