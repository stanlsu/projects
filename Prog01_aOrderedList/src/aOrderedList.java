import java.util.Arrays;
public class aOrderedList {
	final int SIZEINCREMENTS = 20;
    private Comparable[] oList;
    private int listSize;
    private int numObjects;
    private int curr;


    public aOrderedList(){
        this.numObjects = numObjects = 0;
        listSize = SIZEINCREMENTS;
        oList = new Comparable[SIZEINCREMENTS];
    }

    void add(Comparable NewCar) {
        oList[numObjects] = NewCar;
        numObjects++;
        if (numObjects >= oList.length) {
            Comparable[] cartempList = Arrays.copyOf(oList, 2 * oList.length);
            oList = cartempList;
        }
        sortList();
    }

    public String toString(){
        if (oList.length > 0) {
            for (int i = 0; i < oList.length; i++) {
                return "[" + oList[i].toString() + "]";
            }
        }
        return "[]";
    }

    int size (){
        return numObjects;
    }

    Comparable get(int index){
        return oList[index];
    }
    boolean isEmpty(){
        if(numObjects == 0)
            return true;
        else
            return false;
    }
    void remove(int index){
        if (index <= numObjects) {
            for (int i = index; i < numObjects; i++) {
                oList[i] = oList[i + 1];
            }
            oList[numObjects] = null;
            numObjects--;
        }
    }

    public void sortList() {
        for (int i = 0; i < oList.length - 1; i++) {
            for (int j = i + 1; j < oList.length; j++) {
                if (oList[i].compareTo(oList[j]) > 1) {
                    Comparable tempCar = oList[i];
                    oList[i] = oList[j];
                    oList[j] = tempCar;
                }
            }
        }
    }

    void reset() {
        curr = 0;
    }

    Comparable next(){
        curr++;
        return oList[curr];
    }

    boolean hasNext(){
        if (curr < oList.length) return true;
        else if (curr == null) return false;
        else return false;
    }


    void remove(){
        for (int i = curr; i < numObjects - 1; i++) {
            oList[i] = oList[i + 1];
        }
        oList[numObjects - 1] = null;
        numObjects--;
        curr = -1;
    }
}