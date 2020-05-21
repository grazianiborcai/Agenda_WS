package br.com.mind5.business.bookService.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

public final class BookiceInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codCustomer;
	public long codUser;
	public boolean isAged;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public int quantity;
	public LocalDate date;
	public int codWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;	
	public String username;
	public SymsgInfo symsgData;
	
	
	public BookiceInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		isAged = DefaultValue.boole();
		codUser = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		quantity = DefaultValue.number();
		codWeekday = DefaultValue.number();	
		symsgData = DefaultValue.object();
	}
	
	
	
	public static BookiceInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, BookiceInfo.class);
	}
	
	
	
	public static List<BookiceInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, BookiceInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		BookiceInfo deepCopy = (BookiceInfo) super.clone();
		
		deepCopy.symsgData  = CloneUtil.cloneRecord(symsgData , this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codCustomer ^ (codCustomer >>> 32));
		result = result * 31 + (int) (codUser 	  ^ (codUser 	 >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + (int) beginTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof BookiceInfo))
			return false;
		
		
		BookiceInfo obj = (BookiceInfo) o;		
		return (codOwner    == obj.codOwner    		&& 
				codCustomer == obj.codCustomer 		&&
				codUser     == obj.codUser			&&
				codStore    == obj.codStore			&&
				codMat    	== obj.codMat			&&
				codEmployee == obj.codEmployee		&&
				super.isDateEqual(date, obj.date)	&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}
}
