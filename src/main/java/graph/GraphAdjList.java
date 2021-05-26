package graph;

import a.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphAdjList{
	private int N; // N vertex
    private int M; // M edge
    private List<List<Integer>> adj;
	private List<Node> nodeList = new ArrayList<>();

    public GraphAdjList(int N) {
		this.N = N;
		this.M = 0;
		adj = new ArrayList<List<Integer>>();
		for(int i = 0; i < N; i ++) {
			adj.add(new ArrayList<Integer>());
		}
	}
    
    public int getTotalVertex() {return this.N;}
    public int getTotalSize() {return this.M;}

    public void addEdge(int u, int v){ 	 
    	//if(!adj.get(u-1).contains(v)) {
    		if(u == v) {
    			adj.get(u).add(v);
    		}else {
    			adj.get(u).add(v);
				adj.get(v).add(u);
    		}
    	 this.M++;  
    	//} 
    }

    public GraphAdjList readGraphFromText(GraphAdjList graph, String file) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] neighbor = line.split(" ");
				int src = Integer.parseInt(neighbor[0]);
				int dest = Integer.parseInt(neighbor[1]);
				graph.addEdge(src, dest);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//close BufferedReader
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return graph;
	}

    public List<Integer> Neighbor(int v) {
    	List<Integer> list = adj.get(v);
    	List<Integer> temp = new ArrayList<Integer>();
    	for(int i=0; i<list.size();i++) {
    		if(!temp.contains(list.get(i))) {
    			temp.add(list.get(i));
    		}
    	}
//    	System.out.print("Vertex" + v + "'s neighbor: ");
//		for(int i = 0 ; i<temp.size();i++){
//			//if(temp.get(i)!=v) {
//				System.out.print(temp.get(i)+" ");
//			//}
//		}
//		System.out.println();
		return temp;
    }

    public void prints(){
    	System.out.println(getTotalVertex() +" vertices, "+getTotalSize()+" edges");
    	for(int i=0;i<adj.size();i++) {
			System.out.print(i+": ");
			for(Integer e: adj.get(i)) {	
					System.out.print(e+" ");			
			}
			System.out.println();
		}
    }
    

    public int Degree(int v) {
    	int degree = 0;
		List<Integer> list = adj.get(v);
		for(int i = 0 ; i<list.size(); i++){
			if(list.get(i) == v) { 
				degree += 2;
			}else {
				degree++;
			}
		}
		return degree;	
    }

    public int[] calDegree() {
    	int[] arrDegree = new int[N];
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			arrDegree[i] = this.Degree(i);
			if(arrDegree[i]> max) { max = arrDegree[i];}
			if(arrDegree[i]< min) { min = arrDegree[i];}
			System.out.println("Vertex " + i + "'s degree: " + arrDegree[i]);
		}
		System.out.println("Max degree: "+ max);
		System.out.println("Min degree: "+ min);
		System.out.println("Avg degree: "+ (double)(2*getTotalSize())/getTotalVertex());
		return arrDegree;
    }
}

	
