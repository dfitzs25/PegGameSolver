package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PegGame {
    //create the  display

    private ArrayList<Integer> emptyPegs = new ArrayList<>();
    private ArrayList<String> movesMade = new ArrayList<>();

    public PegGame(int startingLocation){
        emptyPegs.add(startingLocation);
    }

    public PegGame(ArrayList<Integer> emptyPegs, ArrayList<String> movesMade){
        this.movesMade = movesMade;
        this.emptyPegs = emptyPegs;
    }
    
    public HashMap<Integer, Integer> movesAvailable(){

        ArrayList<Peg> availableMoves = new ArrayList<>();

        //going from starting to end
        HashMap<Integer, Integer> orderedMoves = new HashMap<>();

        for(int current: emptyPegs){
            Peg peg = new Peg(current);
            ArrayList<Integer> moves = peg.getPossibleMoves();
            for (int move: moves){
                if (validMove(current, move)){
                    availableMoves.add(peg);
                    orderedMoves.put(move, current);
                }
            }
        }

        return orderedMoves;
    }

    public PegGame(PegGame pegGame){
        ArrayList<Integer> originalPegs = pegGame.getEmptyPegs();
        ArrayList<String> originalMade = pegGame.getMovesMade();

        for (int i: originalPegs){
            emptyPegs.add(i);
        }

        for(String s: originalMade){
            movesMade.add(s);
        }
    }
    /**
     * @param start - the peg jumping over 
     * @param end - the empty peg to be moved to 
     */
    public void makeMove(int start, int end){
        int mid = findMiddle(start, end);

        if (mid != 0){
            String move = "from: " +start + " to: " + end;
            movesMade.add(move);
            remvoeItem(end);
            emptyPegs.add(start);
            emptyPegs.add(mid);
        }
    }

    public void remvoeItem(int removed){
        for(int i = 0; i< emptyPegs.size();i ++){
            if (emptyPegs.get(i) == removed){
                emptyPegs.remove(i);
                break;
            }
        }
    }

    private boolean validMove(int end, int start){
        //generate the pegs related to the current and desired move 
        int middle = findMiddle(end, start);

        if (middle != 0 && !emptyPegs.contains(middle) && !emptyPegs.contains(start))
            return true;

        return false;
    }

    private int findMiddle(int current, int end){
        Peg curr = new Peg(current);
        Peg desired = new Peg(end);


        ArrayList<Integer> currMids = curr.getMids();
        ArrayList<Integer> desMids = desired.getMids();

        for (int cM: currMids){
            for(int dM: desMids){
                if (cM == dM){
                    return cM;
                }
            }
        }
        return 0;
    }

    public boolean isDone(){
        if(emptyPegs.size() == 14){
            return true;
        } else if (this.movesAvailable().size() == 0){
            return true;
        }

        return false;
    }

    public ArrayList<Integer> getEmptyPegs(){
        return emptyPegs;
    }

    public ArrayList<String> getMovesMade(){
        return movesMade;
    }

    @Override
    public String toString(){
        ArrayList<Integer> allPegs = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));

        String display = "";

        for (int spot: allPegs){
            
            if (spot == 1){ 
                display += "       ";
            } else if (spot == 2){
                display += "      ";
            }else if (spot == 4){
                display += "    ";
            } else if (spot == 7){
                display += "  ";
            }

            if (emptyPegs.contains(spot)){
                display += " X ";
            } else {
                display += " " + spot+ " ";
            }

            if (spot == 1 || spot == 3 || spot == 6 || spot == 10){
                display += "\n\n";
            }
        }

        return display;

        // return "Empty Pegs size: " + emptyPegs.size();
    }

    public void completeDisplay(){
        System.out.println(this.toString() + "\n" + this.movesMade);
    }

    public void printMoves(){
        System.out.println(this.movesMade);
        System.out.println("\n");
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first removed Peg ");

        String starting = in.nextLine();
        int start = Integer.parseInt(starting);

        PegGame game = new PegGame(start);

        System.out.println(game);

        PegGame copy = new PegGame(game);

        for(int i = 0 ; i < 3;i++){
            System.out.print("Moves available: ");
            System.out.println(game.movesAvailable());
            
            System.out.println("From: ");
            start = Integer.parseInt(in.nextLine());
            
            System.out.println("In: ");
            int end = Integer.parseInt(in.nextLine());
            game.makeMove(start, end);
    
            System.out.println(game);
            System.out.println(game.getMovesMade());
        }

        copy.completeDisplay();
        in.close();
    }
}

