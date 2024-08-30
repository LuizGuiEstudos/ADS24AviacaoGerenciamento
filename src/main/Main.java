package main;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Aviao;

public class Main {
	
	private static ArrayList<Aviao> aviaos = new ArrayList<Aviao>();
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner( System.in );
		
		Aviao aviao13;
		
		System.out.println( "~~~~ GESTOR DE AVIAÇÃO ~~~~" );
		registraAviao();
		
		printAviaos();
		
		pesquisaAviao();
	
		removerAviao();
	
		
		printAviaos();
		
		
		scan.close();
	}
	
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
		System.out.println( "Digite as seguintes informações sobre o avião. " );
		String avReg = scan.next();
		String avModel = scan.next();
		int avCap = scan.nextInt();
		Aviao av = new Aviao(avReg, avModel, avCap);
		
		return av;
	}
	
	
	private static void printAviaos() {
		System.out.println( "---- PRINTANDO LISTA DE AVIÕES ----" );
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
	
	

}
