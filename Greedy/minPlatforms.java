import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class Platforms implements Comparable<Platforms> {
    int starttime;
    int endTime;

    public Platforms(int starttime, int endTime) {
        super();
        this.starttime = starttime;
        this.endTime = endTime;

    }

    @Override
    public int compareTo(Platforms o) {
        return this.starttime - o.starttime;
    }
}

public class minPlatforms {
    public static int solve(int[] arr, int[] dep, int n){
        ArrayList<Platforms> list = new ArrayList<>();
        for (int i = 0; i < dep.length; i++) {
            list.add(new Platforms(arr[i], dep[i]));
        }
        Collections.sort(list);
        for (Platforms platform : list) {
            System.out.println("Arrival time: " + platform.starttime + ", Departure time: " + platform.endTime);
        }
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, list.get(0).endTime);
        mpp.get
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < mpp.size(); j++) {
                if(list.get(i).starttime > mpp.get(j)){
                    mpp.put(j, list.get(i).endTime);
                }else{
                    mpp.put(j+1, list.get(i).endTime);
                }
            }
        }
        return mpp.size();
    }
    public static void main(String[] args) {
        int[] arr = {950, 1100, 1500, 1800,940,900};
        int[] dep = {1120, 1130, 1900, 2000,1200,910};
        System.out.println(solve(arr, dep, 6));
    }
}
