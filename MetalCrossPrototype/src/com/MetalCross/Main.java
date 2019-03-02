package com.MetalCross;

//OpenCSV imports
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//import java.util.logging.Logger;
//import java.util.logging.FileHandler;

public class Main {
	private static final String CSVPath = "./src/resources/MetalCrossPokedexTest1.csv";
	private static final String CSVOutput = "./src/resources/MetalCrossPerfectPokedex.csv";

	public static void main(String[] args) throws IOException{
		int i = 1;
		
//		Logger logger = Logger.getLogger(Main.class.getName());
//		FileHandler fh;
		
		//Attempts to read in CSV file in order to populate Pokedex 
		//Array List and print out a better CSV input file.
		try (
				Reader reader = Files.newBufferedReader(Paths.get(CSVPath));
				CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
				Writer writer = Files.newBufferedWriter(Paths.get(CSVOutput));
				CSVWriter csvWriter = new CSVWriter(writer);
			){
			List<String[]> records = csvReader.readAll();
			String[] headerRecord = {"AppID", "ID", "Name", "Type 1", "Type 2", "ABILITY_FLAG", 
					"IS_ALTERNATE_FORME", "IS_MEGA_EVOLUTION", "IS_REGIONAL_VARIANT"};
			csvWriter.writeNext(headerRecord);
			
			List<Pokemon> Pokedex = new ArrayList<Pokemon>();
			
			for(String[] record : records) {
				Pokemon pkmn = new Pokemon();
				
//				System.out.println("App ID: " + i);
				pkmn.setAppID(i);
				
//				System.out.println("Pokedex Number: " + record[0]);
				pkmn.setPokedexId(Integer.parseInt(record[0].replaceAll(" ", "")));
//				System.out.println(pkmn.getPokedexId());
				
//				System.out.println("Pokemon:" + record[1]);
				pkmn.setName(record[1].replaceAll(" ", ""));
				
//				System.out.println("Type 1:" + record[2]);
				pkmn.setType1(record[2].replaceAll(" ", ""));
				
//				System.out.println("Type 2:" + record[3]);
				pkmn.setType2(record[3].replaceAll(" ", ""));
				
				TypeConstructor TC = new TypeConstructor();
				pkmn.setTypeMatchup(TC.TypeMatchup(pkmn.getType1(), pkmn.getType2()));
				
//				System.out.println("Ability Flag:" + record[4]);
				pkmn.setAbilityFlag(Integer.parseInt(record[4].replaceAll(" ", "")));
				
//				System.out.println("Alternate Forme:" + record[4]);
				pkmn.setAlternateFormeFlag(Integer.parseInt(record[5].replaceAll(" ", "")));
//				System.out.println(pkmn.getAlternateFormeFlag());
				
//				System.out.println("Mega Evolution: " + Integer.parseInt(record[5].replaceAll(" ", "")));
				pkmn.setMegaEvolutionFlag(Integer.parseInt(record[6].replaceAll(" ", "")));
//				System.out.println(pkmn.getMegaEvolutionFlag());
					
//				if(record[5].equals(" 1"))
//					System.out.println("This Mega Evolution requires the Pokemon to be holding the "
//							+ "matching mega stone.");
//				else if(record[5].equals(" 2"))
//				{
//					System.out.println("This Mega Evolution does not require the Pokemon to be holding"
//							+ "a mega stone.");
//					System.out.println("Instead, the Pokemon needs to known the move Dragon Ascent.");
//				}
//					
//				System.out.println("Regional Variant" + record[6]);
				pkmn.setRegionalVariantFlag(Integer.parseInt(record[7].replaceAll(" ", "")));
//				System.out.println(pkmn.getRegionalVariantFlag());
				
				Pokedex.add(pkmn);
//				System.out.println();
				
				csvWriter.writeNext(new String[] {Integer.toString(i), record[0].replace(" ", ""), 
						record[1].replace(" ", ""), record[2].replace(" ", ""), 
						record[3].replace(" ", ""), record[4].replace(" ", ""),
						record[5].replace(" ", ""), record[6].replace(" ", ""),
						record[7].replace(" ", "")});
				i++;
			}
			
			Pokemon[] Team = new Pokemon[6];
			int kbInput = 0;
			String nameKBInput;
			Scanner sc = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			
			while(true)
			{
				System.out.println("Welcome to Metal Cross v0.1!");
				System.out.println("This is teambuilding application for the Pokemon video games.");
				
				System.out.println();
				System.out.println("Please select one of the options below:");
				System.out.println();
				System.out.println("1. View Pokedex");
				System.out.println("2. View team");
				System.out.println("3. Add to team");
				System.out.println("4. View team's type matchups");
				System.out.println("5. Exit application");
				System.out.println();
				System.out.print("Value: ");
				
				kbInput = sc.nextInt();
				switch(kbInput)
				{
					case 1:
					{
						for(Pokemon output : Pokedex)
						{
//							System.out.println("AppID: " + output.getAppId());
							System.out.print("# " + output.getPokedexId() + ": ");
							System.out.println(output.getName());
							System.out.println("Type(s): " + output.getType1()+ "/" + output.getType2());
//							Double[] temp = output.getTypeMatchup();
//							System.out.println(temp.length);
							
							//for-loop to print out type Matchups
//							for(int x = 0; x < temp.length; x++)
//							{
//								double d = temp[x];
//								System.out.println(d);
//							}
							
							if(output.getAbilityFlag() == 1)
							{
								System.out.println("This Pokemon has an ability that may change its type matchup.");
								System.out.print("Some moves and abilities can ignore this ability though,");
								System.out.println(" so the type matchup chart won't change.");
							}
							
							System.out.println();
//							
//							System.out.println("AF Flag: " + output.getAlternateFormeFlag());
//							System.out.println("ME Flag: " + output.getMegaEvolutionFlag());
//							System.out.println("RV Flag: " + output.getRegionalVariantFlag());
							
							if(output.getAlternateFormeFlag() == 1)
								System.out.println("This is an alternate forme of an existing Pokemon!");
							
							if(output.getMegaEvolutionFlag() == 1) {
								System.out.println("This Mega Evolution does require the Pokemon to be holding"
										+ " a mega stone.");
							}
							else if(output.getMegaEvolutionFlag() == 2)
							{
								System.out.println("This Mega Evolution does not require the Pokemon to be holding"
										+ "a mega stone.");
								System.out.println("Instead, the Pokemon needs to known the move Dragon Ascent.");
							}

							if(output.getRegionalVariantFlag() == 1)
								System.out.println("This is a regional variant native to the Alola region!");
							System.out.println();
						}
						
						break;
					}
					
					case 2:
					{
						if(Team[0] == null)
						{
							System.out.println("There are no Pokemon on this team.");
							System.out.println("Please add a Pokemon to this team first before viewing your team.");
						}
						
						else
						{
							for(int x = 0; x < Team.length; x++)
							{
								System.out.println(Team[x].getPokedexId());
								System.out.println(Team[x].getName());
								if(Team[x].getMegaEvolutionFlag() > 0) {
									System.out.println("CAUTION!");
									System.out.println("This is a Mega Evolution form of an existing Pokemon.");
									System.out.println("When this Pokemon is first sent out to battle, "
											+ "it will appear in it's  regular form before it can Mega Evolve.");
								}
								
								System.out.println("Type: " +Team[x].getType1() + "/" + Team[x].getType2() + "\n");
							}
						}
						
						break;
					}
					
					case 3:
					{
						System.out.println("Creating a new team:");
						System.out.println();
						
						for(int x = 0; x < Team.length; x++)
						{
							System.out.print("Enter Pokemon #" + (x + 1) + ": ");
							nameKBInput = sc2.nextLine();
							for(int y = 0; y < Pokedex.size(); y++)
							{
								if(nameKBInput.equals(Pokedex.get(y).getName()))
								{
									System.out.println("Adding Pokemon to your team...");
									Team[x] = Pokedex.get(y);
									System.out.println("Pokemon added!");
									break;
								}
							}
							
							System.out.println();
						}
						
						break;
					}
					
					case 4:
					{
						if(Team[0] == null)
						{
							System.out.println("There are no Pokemon on this team.");
							System.out.println("Please add a Pokemon to this team first before viewing your team.");
							break;
						}
						
						System.out.println("Calculating team effectiveness...");
						TeamMatchup.TeamTypeMatchup(Team);
						break;
					}
					
					case 5:
					{
						System.out.println("Goodbye...");
						break;
					}
					
					default:
					{
						System.out.println("INVALID INPUT!!!");
						break;
					}
				}
				
				System.out.println();
				
				if(kbInput == 5)
				{
					break;
				}
			}
			
			sc.close();
			sc2.close();
		}

	}

}
