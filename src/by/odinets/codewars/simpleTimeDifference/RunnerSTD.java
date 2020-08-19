package by.odinets.codewars.simpleTimeDifference;

public class RunnerSTD {

	public static void main(String[] args) {
		String[] arr = {"14.51"};
		String[] arr1 = {"23:00", "04:22", "18:05", "06:24"};
		String example1 = Solution.solve(arr);
		String example2 = Solution.solve(arr1);
		System.out.println(" example1 :: " + example1);
		System.out.println(" example2 :: " + example2);
		
		String[] arr2 = {"21:14", "15:34", "14:51", "06:25", "15:30"};
		String example3 = Solution.solve(arr2);
		System.out.println(" example3 :: " + example3);
	}
}
