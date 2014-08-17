/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 5/1/13
 */


import java.util.Random;


public class MergeSort {

	public static void main(String[] args) {
		
		// Create a new list
		List<Stats> list = new List<Stats>();
		
		
		// And a new random variable
		Random rand = new Random();
		
		for(int i = 0 ; i < 20 ; i++) {
			int shotsFired, shotsHit, kills, deaths;
			shotsFired = rand.nextInt(30)+200;
			shotsHit = rand.nextInt(60)+300;
			kills = rand.nextInt(40) + 100;
			deaths = rand.nextInt(40) + 100;
			String name = "Player "+i;
			Stats stats = new Stats(name, shotsFired, shotsHit, kills, deaths);
			Node<Stats> node = new Node<Stats>(stats);
			System.out.println(node);
			list.push(node);
		}
		
		List<Stats> sorted = mergeSort(list);
		List<Stats> temp = sorted;
		while(temp.getLength() > 0) {
			System.out.println(temp.first());
			temp = temp.rest();
		}

	}
	
	public static List<Stats> mergeSort(List<Stats> list) {
		if(list.getLength() <= 1) return list;
		
		List<Stats> left, right;
		left = new List<Stats>();
		right = new List<Stats>();
		for(int i = 0 ; i < (list.getLength()/2) ; i++) {
			left.push(list.first());
			list = list.rest();
		}
		right = list;
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}
	
	public static List<Stats> merge(List<Stats> left, List<Stats> right) {
		List<Stats> result = new List<Stats>();
		while(left.getLength() > 0 || right.getLength() > 0) {
			if(left.getLength() > 0 && right.getLength() > 0) {
				if(compare(left.first(), right.first())) {
					result.push(left.first());
					left = left.rest();
				} else {
					result.push(right.first());
					right = right.rest();
				}
			} else if(left.getLength() > 0) {
				result.push(left.first());
				left = left.rest();
			} else if(right.getLength() > 0) {
				result.push(right.first());
				right = right.rest();
			}
		}
		return result;
	}
	
	public static boolean compare(Stats left, Stats right) {
		return (left.getKDRatio() > right.getKDRatio());
	}

}
