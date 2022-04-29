import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> sortedArray;
    public SortedList(){
        sortedArray = new ArrayList<String>();
    }

    public void add(String newElement){
        if(sortedArray.isEmpty()){
            sortedArray.add(newElement);
        }
        else{
            int sortIdx = search(newElement, 0, sortedArray.size()-1);
            if(sortIdx>=sortedArray.size()){
                sortedArray.add(newElement);
            }
            else{
                sortedArray.add(sortIdx, newElement);
            }
        }
    }

    public ArrayList<String> getSortedArray(){
        return sortedArray;
    }

    public int findIdx(String newElement, int low, int high){
        if(low <= high){
            int mid = (high + low) / 2;

            if(newElement.compareToIgnoreCase(sortedArray.get(mid)) == 0){
                return mid;
            }
            else if(newElement.compareToIgnoreCase(sortedArray.get(mid)) > 0){
                return search(newElement, mid+1, high);
            }
            else{
                return search(newElement, low, mid-1);
            }
        }
        else{
            return  low;
        }
    }

    private int search(String newElement, int low, int high){
        if(low <= high){
            int mid = (high + low) / 2;

            if(newElement.compareToIgnoreCase(sortedArray.get(mid)) == 0){
                return mid;
            }
            else if(newElement.compareToIgnoreCase(sortedArray.get(mid)) > 0){
                return search(newElement, mid+1, high);
            }
            else{
                return search(newElement, low, mid-1);
            }
        }
        else{
            return  low;
        }
    }
}
