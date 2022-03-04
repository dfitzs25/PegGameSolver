package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Peg {
    //starting Location, possibleMoves

    // the location could be aything from 1 -15 

    private int current;
    private ArrayList<Integer> possibleMoves = new ArrayList<>();
    private ArrayList<Integer> mids = new ArrayList<>();

    public Peg(int current){
        this.current = current;
        this.generateLocations();
        this.generateMids();
    } 

    private void generateMids(){
        if (current == 1){
            mids.add(2);
            mids.add(3);
        } else if (current == 2){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(4,5)));
        } else if (current == 3){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(5,6)));
        } else if (current == 4){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(2,5,8,7)));
        } else if (current == 5){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(8,9)));
        } else if (current == 6){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(3,5,9,10)));
        } else if (current == 7){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(4,8)));
        } else if (current == 8){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(5,9)));
        } else if (current == 9){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(5,8)));
        } else if (current == 10){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(6,9)));
        } else if (current == 11){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(7,12)));
        } else if (current == 12){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(8,13)));
        } else if (current == 13){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(8,9,12,14)));
        } else if (current == 14){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(9, 13)));
        } else if (current == 15){
            mids.addAll(0, new ArrayList<Integer>(Arrays.asList(10, 14)));
        }
    }

    private void generateLocations(){
        if (current == 1){
            possibleMoves.add(6);
            possibleMoves.add(4);
        } else if (current == 2){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(9,7)));
        } else if (current == 3){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(8,10)));
        } else if (current == 4){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(1,6,11,13)));
        } else if (current == 5){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(12,14)));
        } else if (current == 6){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(1,4,13,15)));
        } else if (current == 7){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(2,9)));
        } else if (current == 8){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(3,10)));
        } else if (current == 9){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(2,7)));
        } else if (current == 10){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(3,8)));
        } else if (current == 11){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(4,13)));
        } else if (current == 12){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(5,14)));
        } else if (current == 13){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(4,6,11,15)));
        } else if (current == 14){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(5, 12)));
        } else if (current == 15){
            possibleMoves.addAll(0, new ArrayList<Integer>(Arrays.asList(6,13)));
        }
    }
    
    public ArrayList<Integer> getPossibleMoves(){
        return possibleMoves;
    }
    
    public ArrayList<Integer> getMids(){
        return mids;
    }

    public int getCurrent(){
        return current;
    }

    public static void main(String[] args){
        Peg example = new Peg(3);
        System.out.println("\n\n");

        System.out.println(example.getCurrent());

        System.out.print("Possible Moves");
        System.out.println(example.getPossibleMoves());

        System.out.print("Mids");
        System.out.println(example.getMids());
    }
}
