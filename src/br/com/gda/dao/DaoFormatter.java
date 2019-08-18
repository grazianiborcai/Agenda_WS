package br.com.gda.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;

public final class DaoFormatter {
	public static String numberToString(long number) {
		if (number < 0)
			return null;
		
		return Long.toString(number);
	}
	
	
	
	public static String numberToString(int number) {
		if (number < 0)
			return null;
		
		return Integer.toString(number);
	}
	
	
	
	public static Time localToSqlTime(LocalTime localTime) {
		Time resultTime = null;
		
		if (localTime != null) 
			resultTime = Time.valueOf(localTime);		
		
		return resultTime;
	}
	
	
	
	public static Date localToSqlDate(LocalDate localDate) {
		Date resultDate = null;
		
		if (localDate != null) 
			resultDate = Date.valueOf(localDate);		
		
		return resultDate;
	}
	
	
	
	public static Timestamp localToSqlTimestamp(LocalDateTime localDateTime) {
		Timestamp resultDate = null;
		
		if (localDateTime != null) 
			resultDate = Timestamp.valueOf(localDateTime);		
		
		return resultDate;
	}
	
	
	
	public static String dateToString(LocalDate localDate) {		
		if (localDate == null)
			return null;
		
		return localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
	}
	
	
	
	public static String timeToString(LocalTime localTime) {	
		if (localTime == null)
			return null;
		
		return localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
	}
	
	
	
	public static String charToString(char c) {	
		if (c == Character.MIN_VALUE)
			return null;
		
		return Character.toString(c);
	}
	
	
	
	public static char stringToChar(String str) {	
		if (str == null)
			return Character.MIN_VALUE;
		
		return str.charAt(0);
	}	
	
	
	
	public static String dateTimeToString(LocalDateTime localDateTime) {	
		if (localDateTime == null)
			return null;
		
		return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}
	
	
	
	public static Integer boxNumber(int number) {
		if (number < 0)
			return null;
		
		return number;
	}
	
	
	
	public static Long boxNumber(long number) {
		if (number < 0)
			return null;
		
		return number;
	}
	
	
	public static Float boxNumber(float number) {
		if (number < 0)
			return null;
		
		return number;
	}
	
	
	
	public static Double boxNumber(double number) {
		if (number < 0)
			return null;
		
		return number;
	}	
	
	
	
	public static float longToDecimal(long number) {
		float result = number;
		result = result / 100;
		return result;
	}
	
	
	
	public static long decimalToLong(float number) {
		float result = number * 100;
		return (long) result;
	}
	
	
	
	public static String booleanToString(boolean boole) {
		if (boole == false)
			return "0";
		
		return "1";
	}
	
	
	
	public static String booleanTrueToString(boolean boole) {
		if (boole == false)
			return null;
		
		return "1";
	}
	
	
	
	public static PreparedStatement numberToStmt(PreparedStatement stmt, int index, long number) throws SQLException {
		checkArgument(stmt, index);		
		
		if (number >= 0) {
			stmt.setLong(index, number);
			return stmt;
		}
		
		stmt.setNull(index, Types.INTEGER);
		return stmt;
	}
	
	
	
	public static PreparedStatement localDateTimeToStmt(PreparedStatement stmt, int index, LocalDateTime localDateTime) throws SQLException {
		checkArgument(stmt, index, localDateTime);			
		
		Timestamp sqlTimestamp = localToSqlTimestamp(localDateTime);		
		stmt.setTimestamp(index, sqlTimestamp);		
		
		return stmt;
	}
	
	
	
	public static PreparedStatement localDateToStmt(PreparedStatement stmt, int index, LocalDate localDate) throws SQLException {
		checkArgument(stmt, index, localDate);			
		
		Date sqlDate = localToSqlDate(localDate);		
		stmt.setDate(index, sqlDate);		
		
		return stmt;
	}
	
	
	
	public static PreparedStatement charToStmt(PreparedStatement stmt, int index, char character) throws SQLException {
		checkArgument(stmt, index);				
		
		if (character == DefaultValue.character()) {
			stmt.setNull(index, Types.VARCHAR);
			return stmt;
		}
		
		stmt.setString(index, Character.toString(character));
		return stmt;
	}
	
	
	
	public static long sqlToLong(ResultSet sqlResultset, String colunmName) throws SQLException {
		checkArgument(sqlResultset, colunmName);		
		
		sqlResultset.getLong(colunmName);
		
		if (sqlResultset.wasNull())
			return DefaultValue.number();
			
		return sqlResultset.getLong(colunmName);	
	}
	
	
	
	public static int sqlToInt(ResultSet sqlResultset, String colunmName) throws SQLException {
		checkArgument(sqlResultset, colunmName);		
		
		sqlResultset.getInt(colunmName);
		
		if (sqlResultset.wasNull())
			return DefaultValue.number();
			
		return sqlResultset.getInt(colunmName);	
	}
	
	
	
	public static char sqlToChar(ResultSet sqlResultset, String colunmName) throws SQLException {
		checkArgument(sqlResultset, colunmName);		
		
		sqlResultset.getString(colunmName);
		
		if (sqlResultset.wasNull())
			return DefaultValue.character();
			
		return sqlResultset.getString(colunmName).charAt(0);	
	}
	
	
	
	public static LocalDateTime sqlToLocalDateTime(ResultSet sqlResultset, String colunmName) throws SQLException {
		checkArgument(sqlResultset, colunmName);		
		
		Timestamp result = sqlResultset.getTimestamp(colunmName);
		
		if (result == null)
			return null;
			
		return result.toLocalDateTime();	
	}
	
	
	
	public static LocalTime sqlToLocalTime(ResultSet sqlResultset, String colunmName) throws SQLException {
		checkArgument(sqlResultset, colunmName);		
		
		Time result = sqlResultset.getTime(colunmName);
		
		if (result == null)
			return null;
			
		return result.toLocalTime();	
	}
	
	
	
	public static LocalDate sqlToLocalDate(ResultSet sqlResultset, String colunmName) throws SQLException {
		checkArgument(sqlResultset, colunmName);		
		
		Date result = sqlResultset.getDate(colunmName);
		
		if (result == null)
			return null;
			
		return result.toLocalDate();	
	}
	
	
	
	private static void checkArgument(PreparedStatement stmt, int index, LocalDateTime localDateTime) {
		if (localDateTime == null)
			throw new NullPointerException("localDateTime" + SystemMessage.NULL_ARGUMENT);
		
		checkArgument(stmt, index);
	}
	
	
	
	private static void checkArgument(PreparedStatement stmt, int index, LocalDate localDate) {
		if (localDate == null)
			throw new NullPointerException("localDate" + SystemMessage.NULL_ARGUMENT);
		
		checkArgument(stmt, index);
	}
	
	
	
	private static void checkArgument(PreparedStatement stmt, int index) {
		if (stmt == null)
			throw new NullPointerException("stmt" + SystemMessage.NULL_ARGUMENT);
		
		if (index <= 0)
			throw new IllegalArgumentException("index" + SystemMessage.POSITIVE_NUM_EXPECTED);
	}
	
	
	
	private static void checkArgument(ResultSet sqlResultset, String colunmName) {
		if (sqlResultset == null)
			throw new NullPointerException("sqlResultset" + SystemMessage.NULL_ARGUMENT);
		
		if (colunmName == null)
			throw new NullPointerException("colunmName" + SystemMessage.NULL_ARGUMENT);
	}
}
