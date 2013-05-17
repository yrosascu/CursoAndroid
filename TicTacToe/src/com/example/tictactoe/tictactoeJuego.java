package com.example.tictactoe;

import java.util.Random;

public class tictactoeJuego {
	private char board[];
	private final static int BOARD_SIZE = 9;
	private Random rand;
	
	public static final char JUGADOR = 'X';
	public static final char JUGADOR_ANDROID = '0';
	public static final char ESPACIO_BLANCO = ' ';

		
	public static int getBOARD_SIZE(){
		return BOARD_SIZE;
		
	}
	
	public tictactoeJuego(){
		board = new char[BOARD_SIZE];
		
		for (int i = 0; i < BOARD_SIZE; i++ )
			board[i] = ESPACIO_BLANCO;
		
		rand = new Random();
		
	}
	
	public void limpiar_board(){
		for(int i = 0; i < BOARD_SIZE; i++)
			board[i] = ESPACIO_BLANCO;
	}
	
	public void setMovimiento(char jugador, int ubicacion){
		board[ubicacion] = jugador;
	}
	
	public int verificaGanador(){
		for(int i = 0; i < 6; i++){
			if(board[i] == JUGADOR && 
			   board[i+1] == JUGADOR &&
			   board[i+2] == JUGADOR)
				return 2;
			
			if(board[i] == JUGADOR_ANDROID && 
			   board[i+1] == JUGADOR_ANDROID &&
			   board[i+2] == JUGADOR_ANDROID)
						return 2;
		}
		for(int i = 0 ; i <= 2; i++){
			
		}
	}
	
	public int getAndroidMov(){
		int mov;
		for(int i = 0; i < getBOARD_SIZE(); i++){
			if(board[i] != JUGADOR && board[i] != JUGADOR_ANDROID){
				char actual = board[i];
				
				board[i] = JUGADOR_ANDROID;
				if(verficaGanador() == 3){
					setMovimiento(JUGADOR_ANDROID,i);
					return i;
				}
				else
					board[i] = actual;
			}
		}
		
		for(int i = 0; i < getBOARD_SIZE(); i++){
			if(board[i] != JUGADOR && board[i] != JUGADOR_ANDROID){
				char actual = board[i];
				
				board[i] = JUGADOR;
				if(verficaGanador() == 2){
					setMovimiento(JUGADOR_ANDROID,i);
					return i;
				}
				else
					board[i] = actual;
			}
		}
		do{
			mov = rand.nextInt(getBOARD_SIZE());
		}while(board[mov] == JUGADOR || board[mov] == JUGADOR_ANDROID);
		
		setMovimiento(JUGADOR_ANDROID, mov);
		
		return mov;
	}
}
