package sarveshchavan777.inrerface2.Activity;


public class FreeHint {

    //Question id for which random no's are generated (i.e qid of free hint used)
    private int freeHintUsedId ;

    //This are the random numbers generated
    private int randomNoOne ;
    private int randomNoTwo ;
    private int randomNoThree ;
    private int randomNoFour ;
    private int randomNoFive ;

    public FreeHint(){
        freeHintUsedId = 0;
        randomNoOne = 0 ;
        randomNoTwo = 0;
        randomNoThree = 0;
        randomNoFour = 0;
        randomNoFive = 0;
    }

    public FreeHint(int freeHintUsedId , int randomNoOne , int randomNoTwo, int randomNoThree, int randomNoFour, int randomNoFive){
        this.freeHintUsedId = freeHintUsedId;
        this.randomNoOne = randomNoOne;
        this.randomNoTwo = randomNoTwo;
        this.randomNoThree = randomNoThree;
        this.randomNoFour = randomNoFour;
        this.randomNoFive = randomNoFive;
    }

     public int getFreeHintUsedId(){
        return freeHintUsedId;
    }

    public int getRandomNoOne(){
        return randomNoOne;
    }

    public int getRandomNoTwo(){
        return  randomNoTwo;
    }

    public int getRandomNoThree(){
        return  randomNoThree;
    }

    public int getRandomNoFour(){
        return  randomNoFour;
    }

    public int getRandomNoFive(){
        return  randomNoFive;
    }

    public void setFreeHintUsedId (int freeHintUsedId){
        this.freeHintUsedId = freeHintUsedId;
    }

    public void setRandomNoOne(int randomNoOne){
        this.randomNoOne = randomNoOne;
    }

    public void setRandomNoTwo(int randomNoTwo){
        this.randomNoTwo = randomNoTwo;
    }

    public void setRandomNoThree(int randomNoThree){
        this.randomNoThree = randomNoThree;
    }

    public void setRandomNoFour(int randomNoFour){
        this.randomNoFour = randomNoFour;
    }

    public void setRandomNoFive(int randomNoFive){
        this.randomNoFive = randomNoFive;
    }
}
