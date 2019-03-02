package com.MetalCross;

public class TypeConstructor {
	
	enum Types
	{
		BUG, DARK, DRAGON, ELECTRIC, FAIRY, FIGHTING, FIRE, FLYING, GHOST, 
		GRASS, GROUND, ICE, NORMAL, POISON, PSYCHIC, ROCK, STEEL, WATER
	}
	
	private static Types[] t1 = Types.values();
	
	private static double[][] TypeChart = {
		   //Bug, Drk, Dra, Ele, Fry, Fgt, Fir, Fly, Ght, Grs, Grd, Ice, Nrm, Psn, Psy, Rck, Stl, Wtr
			{1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 2.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0},//Bug
			{2.0, 0.5, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0},//Dark
			{1.0, 1.0, 2.0, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5},//Dragon
			{1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0},//Electric
			{0.5, 0.5, 0.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0},//Fairy
			{0.5, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0},//Fighting
			{0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 1.0, 0.5, 2.0, 0.5, 1.0, 1.0, 1.0, 2.0, 0.5, 2.0},//Fire
			{0.5, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 0.5, 0.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0},//Flying
			{0.5, 2.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.0, 0.5, 1.0, 1.0, 1.0, 1.0},//Ghost
			{2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 2.0, 2.0, 1.0, 0.5, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5},//Grass
			{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 1.0, 2.0},//Ground
			{1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0},//Ice
			{1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},//Normal
			{0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0},//Poison
			{2.0, 2.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0},//Psychic
			{1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 2.0, 2.0, 1.0, 0.5, 0.5, 1.0, 1.0, 2.0, 2.0},//Rock
			{0.5, 1.0, 0.5, 1.0, 0.5, 2.0, 2.0, 0.5, 1.0, 0.5, 2.0, 0.5, 0.5, 0.0, 0.5, 0.5, 0.5, 1.0},//Steel
			{1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 0.5}};//Water
	
	public double[] TypeMatchup(String Type1, String Type2)
	{
		double[] Matchup = new double[18]; //Output Array, contains the final 
		int type1Index = 0; //Type matching the input String Type1
		int type2Index = -1; //Type matching the input String Type2
//		int monotypeFlag = 0; //Flag to determine if the pokemon only has one type
		
		//Double for-loop finds indices that correspond to the input Strings
		for(int i = 0; i < t1.length; i++)
		{
			//First if-statement finds the index corresponding to Type1
			if(Type1.equalsIgnoreCase(t1[i].toString()))
			{
				type1Index = i;
				for(int j = 0; j < t1.length; j++)
				{
					//Checks if the pokemon only has one type.
					if(Type2.contains("-"))
					{
//						System.out.println("Pokemon only has one type.");
						break;
					}
					
					//Redundant bug-testing
					else if(Type2.equalsIgnoreCase(t1[j].toString()) && (Type2.equalsIgnoreCase(Type1)))
					{
//						System.out.println("Pokemon can't have the same type twice!");
						break;
					}
					
					//Sets index corresponding to pokemon's second type if it has one
					else if(Type2.equalsIgnoreCase(t1[j].toString()) && !(Type2.equalsIgnoreCase(Type1)))
					{
						type2Index = j;
						break;
					}
				}
				break;
			}
		}
		
		if(type1Index < 0)
		{
			System.out.println("Something has gone terribly wrong...");
			return null;
		}
		
		//sets up output
		//if statement sets output array equal to one of the entries in the TypeChart array
		if(type2Index < 0)
		{
//			type2Index = -1;
			Matchup = TypeChart[type1Index];
//			for(int i = 0; i < Matchup.length; i++)
//			{
//				System.out.println("Monotype " + Matchup[i]);
//			}
		}
		
		//multiplies two different indices of the TypeChart array to get the pokemon's type matchups
		else
		{
			for(int i = 0; i < Matchup.length; i++)
			{
				Matchup[i] = TypeChart[type1Index][i] * TypeChart[type2Index][i];
//				System.out.println("Polytype " + Matchup[i]);
			}
		}
		
		return Matchup;
	}

}
