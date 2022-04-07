package project2;

import java.util.Scanner;

public class DataAnalyze {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//getting samples
		System.out.print("Please enter the sample size: ");
		int sampleSize = input.nextInt();
		int[][] trials = new int[sampleSize][4];
		for(int r = 0; r < 4; r++)
		{
			System.out.println("Enter number for Trial " + r);
			for(int c = 0; c < sampleSize; c++)
			{
				System.out.print("Enter sample #" + c + ": ");
				trials[c][r] = input.nextInt();
				if ( c + 1 == sampleSize)
					System.out.println("");
			}
		}

		//printing samples
		System.out.println("\tSample  # \tTrial 1\tTrial 2\tTrial 3\tTrial 4"); //Table header line
		for(int r = 0; r < sampleSize; r++)
		{
			System.out.print("\t\t" + r);
			for(int c = 0; c < 4; c++)
				System.out.print("\t" + trials[r][c]);
			System.out.println("");    
		} 

		System.out.println("\t-----------------------------------------------");

		//calculate averages 
		int[] averages = new int[4];
		for(int r = 0; r < 4; r++)
		{
			averages[r] = 0;
			for(int c = 0; c < sampleSize; c++)
				averages[r] += trials[c][r];
			averages[r] /= sampleSize;    
		} 
		System.out.print("Average:\t"); 
		for(int r = 0; r < 4; r++)
			System.out.print("\t" + averages[r]);
		System.out.println("");
		int minAvg = averages[0]; 
		int maxAvg = averages[0];
		for(int r = 1; r < 4; r++)    
		{
			if(averages[r] < minAvg)
				minAvg = averages[r];
			if(averages[r] > maxAvg)
				maxAvg = averages[r];    
		}

		//printing averages
		System.out.println("");
		System.out.println("Min Average: " + minAvg);
		System.out.println("Max Average: " + maxAvg);
		System.out.println("");
		if(minAvg == maxAvg)
			System.out.println("The trials match EXACTLY!"); //min and max match
		else if(maxAvg < 2 * minAvg)
			System.out.println("The trials concur with each other!"); //max is less than twice of min
		else
			System.out.println("The trials do not concur!"); //max is more than twice of min

		input.close();
	}

}
