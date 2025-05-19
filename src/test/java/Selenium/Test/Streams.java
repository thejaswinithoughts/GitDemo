package Selenium.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;


public class Streams {
	//count the names start with "A" using java pgm
	//@Test
		public void regular()
		{
			ArrayList<String> names = new ArrayList<String>();
			names.add("Abijeeth");
			names.add("Adam");
			names.add("Don");
			names.add("Rama");
			names.add("Alekhya");
			int Count = 0;
		
	for(int i=0;i<names.size();i++)
		{
			String actual = names.get(i);
				if(actual.startsWith("A")) {
			
		Count++;
		
		}}
		
			System.out.println(Count);
		}
		
		
	//count the names start with "A" using stream
     //@Test
	public void Stream1()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abijeeth");
		names.add("Adam");
		names.add("Don");
		names.add("Rama");
		names.add("Alekhya");

		//long c = names.stream().filter(s->s.startsWith("A")).count();
		//System.out.println(c);
		
		
		//print all the names of arraylist letter >4
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//print only 1 result(names)using "LIMIT"
		//names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		//print names which have last letter as "A" with uppercase
		//names.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print letter in sorting with uppercase and start with "A"
		//names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//List<Integer> values = List<Integer> Arrays.asList(3,5,7,4,3,8);
		//values.stream().distinct().forEach(s->System.out.println(s));
			
		
	}
     
	
	//@Test
	public void Stream2()
	{
		//write arraylist using streams
				long d=Stream.of("Abijeeth","Adam","Rama","Alekhya").filter(s->
				{
					s.startsWith("A");
				
				return true;
				}).count();
				System.out.println(d);
	}
	
	@Test
	public void streamCancat()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abijeeth");
		names.add("Adam");
		names.add("Don");
		names.add("Rama");
		
	
		ArrayList<String> names1 = new ArrayList<String>();
		names.add("women");
		names.add("men");
		names.add("alen");
		
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	
	}

