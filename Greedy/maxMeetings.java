import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
class Meeting implements Comparable<Meeting> {
	int startTime;
	int endTime;

	public Meeting(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Meeting o) {

		return this.endTime - o.endTime;
	}

}

public class maxMeetings {
    public static int solve(int[] start, int[] end, int n){
        ArrayList<Meeting> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new Meeting(start[i], end[i]));
		}
		
		Collections.sort(list);
	
		int meetCount = 1;
		int previousMeetEndTime = list.get(0).endTime;
		for (int i = 1; i < n; i++) {
			if (list.get(i).startTime > previousMeetEndTime) {
				meetCount++;
				previousMeetEndTime = list.get(i).endTime;
			}
		}
		return meetCount;
    }
    public static void main(String[] args) {
        int[] a = {1,3,8,0,8,5};
        int[] b = {2,4,6,7,9,9};
        int n = 6;
        System.out.println(solve(a, b, n));
    }
}
