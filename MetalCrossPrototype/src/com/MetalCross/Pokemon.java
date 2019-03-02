package com.MetalCross;

public class Pokemon {
	
	public int AppID;
	public int PokedexID;
	
	public String Name;
	public String Type1;
	public String Type2;
	
	public double[] TypeMatchup;
	public int abilityFlag;//flag for if a pokemon has at least one ability that will affect its type matchups
	
	public int isAlternateFormeFlag;
	public int isMegaEvolutionFlag;//0 if not, 1 if yes, 2 if its MegaRay, big if true
	public int isRegionalVariantFlag;
	
	public void setAppID(int AppID)
	{
		this.AppID = AppID;
	}
	
	public int getAppId()
	{
		return AppID;
	}
	
	public void setPokedexId(int PokedexID)
	{
		this.PokedexID = PokedexID;
	}
	
	public int getPokedexId()
	{
		return PokedexID;
	}
	
	public void setName(String Name)
	{
		this.Name = Name;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public void setType1(String Type1)
	{
		this.Type1 = Type1;
	}
	
	public String getType1()
	{
		return Type1;
	}
	
	public void setType2(String Type2)
	{
		this.Type2 = Type2;
	}
	
	public String getType2()
	{
		return Type2;
	}
	
	public void setTypeMatchup(double[] TypeMatchup)
	{
		this.TypeMatchup = TypeMatchup;
	}
	
	public double[] getTypeMatchup()
	{
		return TypeMatchup;
	}
	
	public void setAbilityFlag(int abilityFlag)
	{
		this.abilityFlag = abilityFlag;
	}
	
	public int getAbilityFlag()
	{
		return abilityFlag;
	}
	
	public void setAlternateFormeFlag(int isAlternateFormeFlag)
	{
		this.isAlternateFormeFlag = isAlternateFormeFlag;
	}
	
	public int getAlternateFormeFlag()
	{
		return isAlternateFormeFlag;
	}
	
	public void setMegaEvolutionFlag(int isMegaEvolutionFlag)
	{
		this.isMegaEvolutionFlag = isMegaEvolutionFlag;
	}
	
	public int getMegaEvolutionFlag()
	{
		return isMegaEvolutionFlag;
	}
	
	public void setRegionalVariantFlag(int isRegionalVariantFlag)
	{
		this.isRegionalVariantFlag = isRegionalVariantFlag;
	}
	
	public int getRegionalVariantFlag()
	{
		return isRegionalVariantFlag;
	}
	
	
	public Pokemon()
	{
		
	}

}
