package Convex_hall;
import java.util.*;

public class GiftWrapping {
	public int direction(Coordinate p, Coordinate q, Coordinate r ) {
		int area=(q.x - p.x)*(r.y - q.y)-(q.y - p.y)*(r.x-q.x);
				return 0;
	}
	
	public void convexHall(Coordinate point[]) {
		Stack<Coordinate> stack= new Stack <Coordinate>();
		int left=0;
		int n=point.length;
		for(int i=1; i<n;i++) { 
			if(point[i].x < point[left].x) {
				left=i;
			}
		}
		
		int p=left;
		System.out.println("Leftmost=(" +point[p].x+ ","+point[p].y+")");
		do {
			stack.add(point[p]);
			int q=(p+1)%n;
			for(int r=0; r<n; r++) {
				if(direction(point[p],point[q], point[r])>0) {
					q=r;
				}
				
			}
			p=q;
		}while(p!=left);
		
		for(Coordinate i: stack) {
			System.out.println("Convex hall point=(" + i.x +"," + i.y + ")");
			
		}
		
	}

}
