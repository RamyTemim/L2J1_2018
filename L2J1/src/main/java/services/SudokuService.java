package services;

import main.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SudokuService {

	int[][] solvedboard = new int[9][9];
	int[][] grid = new int[9][9];
	private final Logger log = LoggerFactory.getLogger(Application.class);
	
	
	public int[][] getSolvedboard() {
		return solvedboard;
	}
	public void setSolvedboard(int[][] solvedboard) {
		this.solvedboard = solvedboard;
	}
	public int[][] getGrid() {
		return grid;
	}
	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	public Logger getLog() {
		return log;
	}
	
	
}
