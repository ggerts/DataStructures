//Gregory Gertsen 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class Population
{
	
	Random randote = new Random();
	Genome mostFit;
	int genomeCount;
	int dayCount;
	
	ArrayList<Genome> populationList;

	public Population(Integer n​umGenomes, Double m​utationRate)
	{
		populationList = new ArrayList<Genome>();
		genomeCount = n​umGenomes;
		for(int i=0;i< n​umGenomes;i++)
			{
				Genome g = new Genome(m​utationRate);
				populationList.add(g);

			}

		mostFit = populationList.get(0);
		
	}
	
	void day()
	{

		dayCount +=1;
		int half = populationList.size()/2;
		populationList.subList(half, populationList.size()).clear();

		
		while(populationList.size()!= genomeCount) 
			{
				
				if(randote.nextInt(2)==0) 
					{
						Genome g = new Genome(populationList.get(randote.nextInt(populationList.size())));
						g.mutate();
						populationList.add(g);					
						
					}
				
				else
					{
						Genome g = new Genome(populationList.get(randote.nextInt(populationList.size())));
						g.crossover(populationList.get(randote.nextInt(populationList.size())));
						g.mutate();
						populationList.add(g);
					}
			}
		
		Collections.sort(populationList);
		mostFit = populationList.get(0);


	}

public static void main(String[]args) {
	
	
	Population p = new Population(10,.753);
	p.day();

	
	System.out.println(p.populationList);
}

}

