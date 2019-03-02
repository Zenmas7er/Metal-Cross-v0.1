package com.MetalCross;

public class TeamMatchup {
	
	enum Types
	{
		BUG, DARK, DRAGON, ELEC, FAIRY, FIGHT, FIRE, FLYING, GHOST, 
		GRASS, GROUND, ICE, NORMAL, POISON, PSYCH, ROCK, STEEL, WATER
	}
	
	private static Types[] t1 = Types.values();
	
	public static void TeamTypeMatchup(Pokemon[] Team)
	{
		int[][] teamTypeMatchup = new int[18][6];
		double[] soloTypeMatchup = new double[18];
		
		for(int i = 0; i < Team.length; i++)
		{
			for(int j = 0; j < Team[i].getTypeMatchup().length; j++)
			{
				soloTypeMatchup = Team[i].getTypeMatchup();
				
				if(soloTypeMatchup[j] < 1)
				{					
					if(soloTypeMatchup[j] == 0.0)
					{
						teamTypeMatchup[j][0] += 1;
					}
					
					else if(soloTypeMatchup[j] == 0.25)
					{
						teamTypeMatchup[j][1] += 1;
					}
					else if(soloTypeMatchup[j] == 0.5)
					{
						teamTypeMatchup[j][2] += 1;
					}
				}
				else if(soloTypeMatchup[j] > 1)
				{
					// Adds 1 or 2 based on weaknesses
					// Adds 1 if the Pokemon has a 2.0 weakness
					// Adds 2 if the Pokemon has a 4.0 weakness
					
					if(soloTypeMatchup[j] == 2)
					{
						teamTypeMatchup[j][4] += 1;
					}
					
					else if(soloTypeMatchup[j] == 4)
					{
						teamTypeMatchup[j][5] += 1;
					}
				}
				else
				{
					teamTypeMatchup[j][3] += 1;
				}
			}
		}
		
		for(int i = 0; i < t1.length; i++)
		{
			System.out.print(t1[i] + ":\t");
			
			for(int j = 0; j < teamTypeMatchup[i].length; j++)
			{
				System.out.print(teamTypeMatchup[i][j] + "\t");
			}
			
			System.out.println();
		}
	}

}
