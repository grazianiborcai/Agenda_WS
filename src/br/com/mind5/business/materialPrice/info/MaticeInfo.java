package br.com.mind5.business.materialPrice.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MaticeInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codStore;
	public long codMat;
	public double price;
	public String codCurr;
	public String txtCurr;
	public LocalDate date;
	public int codWeekday;
	public String username;
	
	
	public MaticeInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codStore = DefaultValue.number();
		codMat = DefaultValue.number();
		price = DefaultValue.number();
		codWeekday = DefaultValue.number();	
	}
	
	
	
	public static MaticeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MaticeInfo.class);
	}
	
	
	
	public static List<MaticeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MaticeInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MaticeInfo))
			return false;
		
		
		MaticeInfo obj = (MaticeInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codStore    == obj.codStore		&&
				codMat    	== obj.codMat		&&
				super.isDateEqual(date, obj.date));
	}
}
