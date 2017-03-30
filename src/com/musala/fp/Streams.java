package com.musala.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
	
	static void mapExample() {
		
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("George", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		
		List<String> names = players.stream().map(player -> player.getName()).collect(Collectors.toList());
		
		names.forEach(name -> System.out.println(name)); //You can also provide a static function!
	}
	
	static void filterExample() {
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("George", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		
		List<Player> positivePoints = 
				players.stream().filter(player -> player.getPoints() > 0).collect(Collectors.toList());
		
		positivePoints.forEach(player -> System.out.println(player.getPoints()));
	}
	
	static void reduceExample() {
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("George", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		
		int sum = players.stream()
				.reduce(new Player(), (p1, p2) -> new Player("", p1.getPoints() + p2.getPoints()))
				.getPoints();
		
		System.out.println("Sum is: " + sum);
	}
	
	static void sumInJava7() {
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("George", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		
		int sumOfPositivePoints = 0;
		for(Player p : players) {
			
			if (p.getPoints() > 0) {				
				sumOfPositivePoints += p.getPoints();
			}
		}
		
		System.out.println(sumOfPositivePoints);
	}
	
	static void sumOfAllPlayersWithPositiveScores() {
		List<Player> players = new ArrayList<Player>();
		
		players.add(new Player("George", 14));
		players.add(new Player("Michael", 0));
		players.add(new Player("Ian", 7));
		players.add(new Player("Seth", -1));
		players.add(new Player("Miro", 14));
		
		int sum = players.stream()
		.map(player -> player.getPoints())
		.filter(points -> points > 0)
		.distinct()
		.reduce(0, (x, y) -> x + y); //What if we wanted the biggest score?
		
		System.out.println("Sum is: " + sum);
	}
	
	static void infiniteStreamsExample() {
		Random r = new Random();
		IntStream ints = r.ints(0, 100);
		
		ints.limit(10).forEach(x -> System.out.println(x));
	}
	
	public static void main(String[] args) {
//		mapExample();
//		filterExample();
//		reduceExample();
//		sumOfAllPlayersWithPositiveScores();
//		infiniteStreamsExample();
	}
}

class Player {
	
	private int points;
	private String name;
	
	public Player() {
		points = 0;
		name = "";
	}
	
	public Player(String name, int points) {
		this.points = points;
		this.name = name;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}