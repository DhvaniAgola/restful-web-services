import java.util.LinkedList;

public class GraphLearning1 {

	static class createVertex{
		int val;
		LinkedList<Integer> lnkdlst[];
		createVertex(int val)
		{
			this.val=val;
			lnkdlst=new LinkedList[this.val];
			for(int i=0;i<lnkdlst.length;i++)
			{
				lnkdlst[i]=new LinkedList<>();
			}
		}
	}
	 public static void addEdge(createVertex cv, int source, int destination)
	{
		cv.lnkdlst[source].add(destination);
		cv.lnkdlst[destination].add(source);
	}
	 public static void printGraph(createVertex cv)
	 {
		 for(int v = 0; v < cv.val; v++) 
	        { 
	            System.out.println("Adjacency list of vertex "+ v); 
	            System.out.print("head"); 
	            for(Integer pCrawl: cv.lnkdlst[v]){ 
	                System.out.print(" -> "+pCrawl); 
	            } 
	            System.out.println("\n"); 
	        }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intval=5;
		createVertex graph=new createVertex(intval);
		addEdge(graph, 0, 1);
		 addEdge(graph, 0, 4); 
	        addEdge(graph, 1, 2); 
	        addEdge(graph, 1, 3); 
	        addEdge(graph, 1, 4); 
	        addEdge(graph, 2, 3); 
	        addEdge(graph, 3, 4); 
	        printGraph(graph);
	}

}
