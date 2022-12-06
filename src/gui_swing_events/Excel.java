package gui_swing_events;


import java.util.ArrayList;
import java.util.Arrays;  // the class of ArrayList
import java.util.List; // Interface


public class Excel {
    private ArrayList<Double> numbers = new ArrayList<>();

    public Excel(ArrayList<Double> InputList){ // InputList == numericListArr
        this.numbers = InputList;
    }

    public Excel(String strNumbers){ // strNumbers == stringOfNumbers
        String strNumArray[] = strNumbers.split(" ");
        
        List<String> strNumList = Arrays.asList(strNumArray);

        ArrayList<String> strNumArrayList =  new ArrayList<>(strNumList);
        strNumArrayList.forEach(component -> { // component == item
            Double valueDouble = Double.parseDouble(component);
            this.numbers.add(valueDouble);
        });

        for (int i =0;  i<this.numbers.size(); i++){
            System.out.println(this.numbers.get(i));
        }
    }

    // functions to calculate the average, max etc here

    public double findTotal(){
        double sum = 0 ;
        for(int i = 0 ; i < this.numbers.size() ; i++ ){
            sum += this.numbers.get(i);
        }
        System.out.println("somme : "+ sum);
        double result = sum;
        return result;
    }

    public double findAvg(){
        System.out.println("avg choosed");
        double sum = 0 ;
        for(int i = 0 ; i < this.numbers.size() ; i++ ){
        sum += this.numbers.get(i);
        }
        double avg = sum / this.numbers.size() ;
        System.out.println("moyenne : "+ avg);
        double result = avg;
        return result;
    }

    public double findMax(){
        System.out.println("max choosed");
        int j = 1;
        int i = 0;
        double valueI = this.numbers.get(i);
        System.out.println("first time valueI : "+valueI);
        double valueJ =this.numbers.get(j);
        System.out.println("first time valueJ : "+valueJ);
        System.out.println("tab length : "+ this.numbers.size());
        while(j < this.numbers.size()){
            if(valueJ > valueI){
                valueI = valueJ;
                System.out.println("valueI : "+valueI);
                i = j;
            }
            if(j+1 <this.numbers.size()){
                System.out.println("value j : "+ (j+1));
                j++;
                valueJ = this.numbers.get(j);
                System.out.println("new valueI : "+valueI);
                System.out.println("new valueJ : "+valueJ);
            }else{
                return valueI;
            }
        }
        return valueI; 
    }
     

    public double findMin(){
        System.out.println("min choosed");
        int j = 1;
        int i = 0;
        double valueI = this.numbers.get(i);
        System.out.println("first time valueI : "+valueI);
        double valueJ = this.numbers.get(j);
        System.out.println("first time valueJ : "+valueJ);
        System.out.println("tab length : "+this.numbers.size());
        while(j < this.numbers.size()){
            if(valueJ < valueI){
                valueI = valueJ;
                System.out.println("valueI : "+valueI);
                i = j;
            }
            if(j+1 <this.numbers.size()){
                System.out.println("value j : "+ (j+1));
                j++;
                valueJ = this.numbers.get(j);
                System.out.println("new valueI : "+valueI);
                System.out.println("new valueJ : "+valueJ);
            }else{
                return valueI;
            }
        }
        System.out.println("min is : " + valueI);
        return valueI;
    }
}


        

    






