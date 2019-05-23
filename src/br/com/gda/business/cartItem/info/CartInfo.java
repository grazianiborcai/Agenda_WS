package br.com.gda.business.cartItem.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public final class CartInfo extends InfoRecord implements Cloneable, Comparable<CartInfo> {
	public long codOwner;	
	public long codCustomer;
	public long codUser;
	public long codPerson;
	public int itemNumber;
	public char codItemCateg;
	public String txtItemCateg;
	public char codFeeCateg;
	public String txtFeeCateg;
	public long codStore;
	public String nameStore;
	public long codEmployee;
	public String nameEmployee;
	public long codMat;
	public String txtMat;
	public double price;
	public int priceUnit;
	public int quantity;
	public String codCurr;
	public String txtCurr;
	public String codUnit;
	public String txtUnit;	
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codTimezone;	
	public String codLanguage;
	public LocalDateTime lastChanged;
	public String username;
	
	
	
	public CartInfo() {
		codOwner = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		codPerson = DefaultValue.number();
		codUser = DefaultValue.number();
		itemNumber = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		price = DefaultValue.number();
		priceUnit = DefaultValue.number();
		quantity = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codLanguage = DefaultValue.language();	
		codItemCateg = DefaultValue.character();
		codFeeCateg = DefaultValue.character();
	}
	
	
	
	public static CartInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartInfo.class);
	}
	
	
	
	public static List<CartInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CartInfo deepCopy = (CartInfo) super.clone();
		
		if (date != null)
			deepCopy.date = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
		
		if (beginTime != null)
			deepCopy.beginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute());
		
		if (endTime != null)
			deepCopy.endTime = LocalTime.of(endTime.getHour(), endTime.getMinute());
		
		if (lastChanged != null)
			deepCopy.lastChanged = lastChanged;
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codUser 	  ^ (codUser 	 >>> 32));
		result = result * 31 + (int) (codPerson   ^ (codPerson   >>> 32));
		result = result * 31 + (int) (itemNumber  ^ (itemNumber  >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CartInfo))
			return false;
		
		
		CartInfo obj = (CartInfo) o;		
		return (codOwner    == obj.codOwner    && 
				codCustomer == obj.codCustomer &&
				codPerson   == obj.codPerson   &&
				codUser     == obj.codUser     &&
				itemNumber  == obj.itemNumber);
	}


	
	@Override public int compareTo(CartInfo arg0) {
		if (arg0 == null) {
			logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}

		
		if (itemNumber < arg0.itemNumber)
			return -1;
		
		if (itemNumber > arg0.itemNumber)
			return 1;
		
		if (equals(arg0))
			return 0;
		
		
		logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
