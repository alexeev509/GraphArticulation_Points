package com.company;

import java.io.InputStream;
import java.util.*;

public class Main {

    private static Random r=new Random();

    private static  Map<Integer,List<Integer>> mapOfEdges;
    private static  Map<Integer,Boolean> mapOfNodes;
    private static int V;
    private static int E;
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {


        generateRandomGraph(scanner);

        printGraph();

        DFS(0);

    }


    public static void DFS(int currentNodeNumber){
        Stack<Integer> stackOfV=new Stack<>();
        stackOfV.push(currentNodeNumber);
        while (!stackOfV.isEmpty()){
            List<Integer> edges = mapOfEdges.get(currentNodeNumber);
            boolean lastElementOfdfs=true;
                for (int i = 0; i < edges.size(); i++) {
                    //Добавляем только те, до которых еще не доходили
                    if(mapOfNodes.get(edges.get(i))==false && !stackOfV.contains(edges.get(i))) {
                        stackOfV.push(edges.get(i));
                        currentNodeNumber=stackOfV.peek();
                        lastElementOfdfs=false;
                        break;
                    }
                }
                if(lastElementOfdfs==true){
                    Integer currentV = stackOfV.pop();
                    //Заменяем узел на посещенный
                    mapOfNodes.replace(currentV,true);
                }
            }
        }

    public static void generateRandomGraph(Scanner scanner){

        System.out.println("Enter number of nodes");
        V =scanner.nextInt();
        System.out.println("Enter number of edges; it must be <=|V|*(|V|-1)");
        E =scanner.nextInt();
        mapOfEdges= new HashMap<>(V);
        mapOfNodes=new HashMap<>(V);

        //Add nodes in maps
        for (int i=0; i<V+1;i++){
            //False is meaning that we didn't visit this node
            mapOfNodes.put(i,false);
            mapOfEdges.put(i,new ArrayList<>());
        }
        //Add edges in graph
        for(int i=0; i<E;i++){
            int startOfEdge=scanner.nextInt();
            int endOfEdge=scanner.nextInt();
            //I mustn't add element in mapOfEdges if startOfEdge==endOfEdge, for example 1-1 or 2-2
            //
            if(startOfEdge!=endOfEdge &&
                    !mapOfEdges.get(startOfEdge).contains(endOfEdge))
                mapOfEdges.get(startOfEdge).add(endOfEdge);
            if(startOfEdge!=endOfEdge &&
                    !mapOfEdges.get(endOfEdge).contains(startOfEdge))
                mapOfEdges.get(endOfEdge).add(startOfEdge);
        }
    }

    public static void printGraph(){
        for (Map.Entry entry:mapOfEdges.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static Map<Integer, Boolean> getMapOfNodes() {
        return mapOfNodes;
    }
}

