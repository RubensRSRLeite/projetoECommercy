package br.com.loja.rn;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class converterDataDeEnParaCalendar {

	public Calendar executa(String data) {
		
		String[] dataSplit = data.split("-"); // divizor de ano - mês - dia
		
		Integer ano = Integer.parseInt(dataSplit[0]); //converteu as datas para int
		Integer	mes = Integer.parseInt(dataSplit[1]);
		Integer dia = Integer.parseInt(dataSplit[2]);
		
		Calendar calendar = new GregorianCalendar(ano, (mes-1), dia); //instanciar
		
		return calendar;
	}
}
