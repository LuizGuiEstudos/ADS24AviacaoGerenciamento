package main;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Aviao;

public class Main {
	
	private static ArrayList<Aviao> aviaos = new ArrayList<Aviao>();
	
	private static Scanner scan = new Scanner(System.in);
	
	private static String SYMBOL_SCAN_IN = "<";

	
	
	private static void pesquisaAviao() 
	{
		System.out.println( "#### PESQUISAR AVIÃO ####" );
		System.out.println();
		System.out.println( "-Digite o registro do avião a ser encontrado: " );
		String entrada = scan.next();
		Aviao avEncontrado = encontraAviao(entrada);
		
		if( avEncontrado == null ) 
		{
			System.out.println( ">registro de avião pesquisado não encontrado!" );
			return;
		}
		System.out.println( ">informações do avião pesquisado:" );
		printAviao(avEncontrado);
		
		
	}
	
	private static Aviao encontraAviao( String registro ) {
		Aviao iAv;
		
		for( int i=0; i<aviaos.size(); i++ ) 
		{
			iAv = aviaos.get(i);
			if( iAv.getRegistro().equals(registro) ) {
				return iAv;
			}
		}
		
		return null;
	}
	
	private static boolean removerAviao() {
		System.out.println( "#### REMOVER AVIÃO ####" );
		System.out.println();
		System.out.println( "-Digite o registro do avião a ser removido:" );
		String reg = scan.next();
		Aviao iAv;
		iAv = encontraAviao(reg);
		
		if( iAv == null ) {
			System.out.println( ">registro de avião não encontrado!" );
			return false;
		}
		
		if( confirmaRemoverAviao(iAv) ) 
		{
			aviaos.remove(iAv);
			System.out.println( ">avião removido - OK" );
			return true;
		}
		//confirmacao negada
		System.out.println( ">remoção de avião NEGADA" );
		return false;
		
	}
	private static boolean confirmaRemoverAviao( Aviao aviao ) {
		System.out.println( " O seguinte avião está a ser removido: " );
		printAviao(aviao);
		System.out.println( "-deseja mesmo remove-lo?(A-aceitar/X-negar)" );
		String entrada = scan.next().toLowerCase();
		boolean confirma;
		
		boolean isCharsValido = entrada.equals("a") || entrada.equals("x");
		//LOOP - valor invalido
		while( !isCharsValido ) 
		{
			System.out.println( ">valor inválido! " );
			System.out.println( "-Redigite a confirmação(A-aceitar/X-negar):" );
			entrada = scan.next();
			isCharsValido = entrada.equals("a") || entrada.equals("x");
		}
		
		if( entrada.equals("a") ) 
		{
			confirma = true;
		} else 
		{
			confirma = false;
		}
		
		return confirma;
	}
	
	private static void registraAviao(  ) {
		System.out.println( "#### REGISTRAR NOVO AVIÃO ####" );
		System.out.println();
		
		Aviao av;
		av = entradaAviao();
		System.out.println( ">o seguinte avião foi registrado:" );
		printAviao(av);
		//add
		aviaos.add(av);
		
	}
	private static Aviao entradaAviao() {
		System.out.println( "-Digite as seguintes informações sobre o avião. " );
		System.out.println( ">Registro:" );
		System.out.print( SYMBOL_SCAN_IN );
		String avReg = scan.next();
		System.out.println( ">Modelo:" );
		System.out.print( SYMBOL_SCAN_IN );
		String avModel = scan.next();
		
		System.out.println( ">Capacidade:" );
		System.out.print( SYMBOL_SCAN_IN );
		int avCap = scan.nextInt();
		Aviao av = new Aviao(avReg, avModel, avCap);
		
		return av;
	}
	
	
	private static void printAviaos() {
		System.out.println( "---- PRINTANDO LISTA DE AVIÕES ----" );
		
		//VERIFICA VAZIO
		if( aviaos.size() == 0 ) {
			System.out.println( ">Não há aviões registrados" );
			return;
		}
		
		System.out.println();
		for( int i = 0; i<aviaos.size(); i++ ) 
		{
			Aviao aviao = aviaos.get(i);
			System.out.println( i + " > " );
			printAviao(aviao);
		}
	}
	private static void printAviao( Aviao av ) {
		System.out.println( "	REGISTRO	: " + av.getRegistro() );
		System.out.println( "	Modelo	: " + av.getModelo() );
		System.out.println( "	Capacidade	: " + av.getCapacidade() );
	}
	
	public static void main(String[] args) //MAIN
	{
		
		Scanner scan = new Scanner( System.in );
		
		String cmdQuit = "0";
		String cmd = "";
		
		System.out.println( "~~~~ GESTOR DE AVIAÇÃO ~~~~" );

		while( !cmd.equals(cmdQuit) ) 
		{
			System.out.println( "-Digite a ação desejada: 1-Registrar Avião, 2-Listar Aviões \n" + 
					" 3-Pesquisar aeronave, 4-Remover aeronave \n"
					+ " 0-quit" );
			
			cmd = scan.next();
			
			switch( cmd ) {
			case "1": registraAviao(); break;
			case "2": printAviaos(); break;
			case "3": pesquisaAviao(); break;
			case "4": removerAviao(); break;
			case "0": System.out.println( ">saindo..." );
			default: System.out.println( ">Valor inválido!!!" );
			}
		}
		
		
		scan.close();
		System.out.println( " XXX PROGRAMA FECHADO XXX " );
	}
	
	

}
