package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Finder {
    //create backtracker to test for peggame solution, using backtracking, creating a branching amount of sets to find the desired solution.
    //needs a configuratoin, successors, a goal and to tell when its invalid (isDone).

    private HashMap<Integer,ArrayList<PegGame>> configs = new HashMap<>();

    private int current = 1;

    public Finder(int empty){

        PegGame game = new PegGame(empty);

        configs.put(game.getEmptyPegs().size(), new ArrayList<PegGame>(Arrays.asList(game)));

    }

    public Finder(){
        Scanner in = new Scanner(System.in);
        System.out.print("Pick the starting peg (1-15): ");
        int start = Integer.parseInt(in.nextLine());

        PegGame game = new PegGame(start);

        configs.put(game.getEmptyPegs().size(), new ArrayList<PegGame>(Arrays.asList(game)));

        in.close();
    }

    private int countTotal(){
        Set<Integer> keyset = configs.keySet();

        int total = 0;

        for(int key: keyset){
           total+= configs.get(key).size();
        }

        return total;
    }

    private void backtracker(){
        if(current == 15){
            //done
        } else if (configs.containsKey(14)){
            System.out.println("\n\n\nCOMPLETE SOLUTIONS");
            for(PegGame solution: configs.get(14)){
                // solution.completeDisplay();
                solution.completeDisplay();
            }
            int correctComb = configs.get(14).size();
            System.out.println("Total Combinations: " + countTotal());
            System.out.println("Total Complete Combinations: " + correctComb);
        } else {
            ArrayList<PegGame> combs = configs.get(current);
            for(PegGame game: combs){
                makeAllMoves(game);
            }
            current++;
            backtracker();
        }
    }

    private void makeAllMoves(PegGame game){
        //CLONE game
        //make all possible moves in that game. 
        //add that new game to the collection under appropriate key
        //get all possible moves from the original game
        HashMap<Integer, Integer> movesFromOriginal = game.movesAvailable();
        Set<Integer> originalKeySet = movesFromOriginal.keySet();
        //go through all mvoes 
        for(int start: originalKeySet){
            PegGame clone = new PegGame(game);
            clone.makeMove(start, movesFromOriginal.get(start));
            //add the clone to the config
            int key = clone.getEmptyPegs().size();

            System.out.println(clone);
            System.out.println(clone.getEmptyPegs().size());
            if(configs.containsKey(key)){
                configs.get(key).add(clone);
            } else {
                ArrayList<PegGame> gameList = new ArrayList<>();
                gameList.add(clone);
                configs.put(key, gameList);
            }
        }
    }


    public static void main(String[] args){
        Finder finder = new Finder();
        finder.backtracker();
    }
}
