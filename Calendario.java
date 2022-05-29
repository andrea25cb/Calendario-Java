package trabajos_programacion_def;

import java.util.Scanner;

public class Calendario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);

		System.out.print("Enter full year (ex_ 2001): ");
		int year = teclado.nextInt();

		System.out.print("Enter month in number between 1 and 12: ");
		int month = teclado.nextInt();

		System.out.println(printCalendar(year, month));

	}

//Print the calendar for a month in a year//
	public static String printCalendar(int year, int month) {
		// Print the headings of the calendar//
		String head;
		String body;

		head = printHead(year, month);
		body = monthBody(year, month);

		return head + body;

	}

	public static String printHead(int year, int month) {
		return ("			" + getMonthName(month) + " " + year
				+ "\n-----------------------------------------------------------------\n \tLun\tMar\tMier\tJue\tVie\tSab\tDom\n");

	}

	public static String monthBody(int year, int month) {

		final int START_DAY_FOR_JAN_1_1700 = 5;
		int totalDays = daysUntilYear(year) + remainderDays(year, month);
		int firstDay = ((totalDays + 5) % 7);

		int days = 0;

		int firstdayofmonth = daysUntilYear(year);
		int totalOfMonth = daysOfMonth(year, month);

		String espacio = "";
		while (days < firstDay) {
			System.out.println(days + "  " + firstDay);
			espacio += "\t";
			days++;
		}

		for (days = 1; days <= totalOfMonth; days++) {
			
			espacio = espacio + days + "\t";// es lo mismo que: espacio +=days
			if ((days + firstDay - 1) % 7 == 0)
				espacio += "\n\t";
		}
		return espacio;
	}

	public static int remainderDays(int year, int month) { // para calcular los días restantes
		int total = 0;
		for (int m = 1; m < month; m++)
			total += daysOfMonth(m, year);
		return total;

	}

	public static int daysUntilYear(int year) {
		int totalDays = 0;
		int y;

		for (y = 1700; y < year; y++)
			if (isLeapYear(y))
				totalDays += 366;
			else
				totalDays += 365;

		return totalDays;
	}

	public static String getMonthName(int month) {
		String monthName = "";
		switch (month) {
		case 1:
			monthName = "Enero";
			break;
		case 2:
			monthName = "Febrero";
			break;
		case 3:
			monthName = "Marzo";
			break;
		case 4:
			monthName = "Abril";
			break;
		case 5:
			monthName = "Mayo";
			break;
		case 6:
			monthName = "Junio";
			break;
		case 7:
			monthName = "Julio";
			break;
		case 8:
			monthName = "Agosto";
			break;
		case 9:
			monthName = "Septiembre";
			break;
		case 10:
			monthName = "Octubre";
			break;
		case 11:
			monthName = "Noviembre";
			break;
		case 12:
			monthName = "Diciembre";
		}
		return monthName;
	}

	public static int daysOfMonth(int year, int month) {
		if (month == 2)
			if (isLeapYear(year))
				return 29;
			else
				return 28;
		else if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		else
			return 31;

	}

	public static boolean isLeapYear(int year) {

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		return false;

	}
}