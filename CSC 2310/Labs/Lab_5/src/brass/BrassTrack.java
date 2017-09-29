package brass;

public class BrassTrack
{
	private float x_offset;
	private float y_offset;
	
	private int x_start;
	private int y_start;
	
	public BrassTrack(BrassXML brass_xml)
	{
		int[] starting_loc = brass_xml.getTrackStartingLocation();
		x_start = starting_loc[0];
		y_start = starting_loc[1];
		
		float[] offsets = brass_xml.getTrackOffsets();
		x_offset = offsets[0];
		y_offset = offsets[1];
	}
	
	public int getXPixel(int index)
	{
		float x_pixel = x_start;
		
		if (index > 98)
		{
			x_pixel = x_pixel + (x_offset*(index - 98));
		}
		
		if (index > 93)
		{
			if (index > 96) index = 96;
			x_pixel = x_pixel - (x_offset*(index - 93));
		}
		
		if (index > 88)
		{
			if (index > 91) index = 91;
			x_pixel = x_pixel + (x_offset*(index - 88));
		}
		
		if (index > 82)
		{
			if (index > 86) index = 86;
			x_pixel = x_pixel - (x_offset*(index - 82));
		}
		
		if (index > 76)
		{
			if (index > 80) index = 80;
			x_pixel = x_pixel + (x_offset*(index - 76));
		}
		
		if (index > 70)
		{
			if (index > 74) index = 74;
			x_pixel = x_pixel - (x_offset*(index - 70));
		}
		
		if (index > 64)
		{
			if (index > 68) index = 68;
			x_pixel = x_pixel + (x_offset*(index - 64));
		}
		
		if (index > 55)
		{
			if (index > 62) index = 62;
			x_pixel = x_pixel - (x_offset*(index - 55));
		}
		
		if (index > 46)
		{
			if (index > 53) index = 53;
			x_pixel = x_pixel + (x_offset*(index - 46));
		}
		
		if (index > 32)
		{
			if (index > 44) index = 44;
			x_pixel = x_pixel - (x_offset*(index - 32));
		}
		
		if (index > 18)
		{
			if (index > 30) index = 30;
			x_pixel = x_pixel + (x_offset*(index - 18));
		}
		
		if (index > 16) index = 16;
		x_pixel = x_pixel - (x_offset*(index - 0));
		
		return (int) (x_pixel + 0.5);
	}
	
	public int getYPixel(int index)
	{
		float y_pixel = y_start;
		
		if (index > 96)
		{
			if (index > 98) index = 98;
			y_pixel = y_pixel - (y_offset*(index - 96));
		}
		
		if (index > 91)
		{
			if (index > 93) index = 93;
			y_pixel = y_pixel - (y_offset*(index - 91));
		}
		
		if (index > 86)
		{
			if (index > 88) index = 88;
			y_pixel = y_pixel - (y_offset*(index - 86));
		}
		
		if (index > 80)
		{
			if (index > 82) index = 82;
			y_pixel = y_pixel - (y_offset*(index - 80));
		}
		
		if (index > 74)
		{
			if (index > 76) index = 76;
			y_pixel = y_pixel - (y_offset*(index - 74));
		}
		
		if (index > 68)
		{
			if (index > 70) index = 70;
			y_pixel = y_pixel - (y_offset*(index - 68));
		}
		
		if (index > 62)
		{
			if (index > 64) index = 64;
			y_pixel = y_pixel - (y_offset*(index - 62));
		}
		
		if (index > 53)
		{
			if (index > 55) index = 55;
			y_pixel = y_pixel - (y_offset*(index - 53));
		}
		
		if (index > 44)
		{
			if (index > 46) index = 46;
			y_pixel = y_pixel - (y_offset*(index - 44));
		}
		
		if (index > 30)
		{
			if (index > 32) index = 32;
			y_pixel = y_pixel - (y_offset*(index - 30));
		}
		
		if (index > 16)
		{
			if (index > 18) index = 18;
			y_pixel = y_pixel - (y_offset*(index - 16));
		}
		
		return (int) (y_pixel + 0.5);
	}
	
	public static int getIncomeAmount(int income_index)
	{
		//DO THIS
		int income = 0; 
		
		
		if(income_index >= 100)
		{
			return 0;
		}
		
		if(income_index > 60)
		{
			income = (income + ((income_index-61)/4)+1);
			income_index = 58; 
		}
		if(income_index > 30)
		{
			income = (income +((income_index-31)/3)+1);
			income_index = 11; 
		}
		if(income_index > 10)
		{
			income = (income +((income_index-11)/2)+1);
			income_index = 0;
		}
		
		income = (income + (income_index - 10));

		
		
		// Return the player's income
		return income;
	}
	
	public static int takeLoan(int income_index, int loan_size)
	{
		//DO THIS
		
		
		// Gives current income level
		int income_level = getIncomeAmount(income_index);
		
		// Gives our new income level that we want the
		// income_index to be.
		int new_level = (income_level - (loan_size/10));
		
		// We need to know the income level and return
		// that. 
		
		while(income_level != new_level)
		{
			income_index--;
			
			income_level = getIncomeAmount(income_index);
		}
		
		return income_index;
	}
	
	public static int getVictoryPoints(int victory_index)
	{
		return victory_index;
	}
}
