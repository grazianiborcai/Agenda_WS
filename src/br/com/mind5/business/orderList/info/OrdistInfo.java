package br.com.mind5.business.orderList.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OrdistInfo extends InfoRecord implements Cloneable, Comparable<OrdistInfo> {
	public long codOwner;	
	public long codOrder;	
	public String codOrderExt;	
	public long codUser;
	public double itemTotal;
	public double feeService;
	public double grandTotal;	
	public String codCurr;
	public String txtCurr;
	public String codOrderStatus;
	public String txtOrderStatus;
	public long codPayOrder;
	public int postingYear;
	public int postingYearMonth;
	public LocalDate postingDate;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public OrdistInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();				
		codUser = DefaultValue.number();		
		itemTotal = DefaultValue.number();
		feeService = DefaultValue.number();
		grandTotal = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		postingYear = DefaultValue.number();
		postingYearMonth = DefaultValue.number();
	}
	
	
	
	public static OrdistInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdistInfo.class);
	}
	
	
	
	public static List<OrdistInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdistInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codOrder ^ (codOrder >>> 32));
		result = result * 31 + (int) (codUser  ^ (codUser  >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdistInfo))
			return false;
		
		
		OrdistInfo obj = (OrdistInfo) o;		
		return (codOwner    == obj.codOwner && 
				codOrder 	== obj.codOrder &&
				codUser     == obj.codUser		);
	}
	
	
	
	@Override public int compareTo(OrdistInfo arg0) {
		super.checkCompareToArgument(arg0);
		
		int result = compareToCodOwner(arg0);		
		if (result != 0) return result;
		
		result = compareToCodOrder(arg0);		
		if (result != 0) return result;
		
		return 0;
	}
	
	
	
	private int compareToCodOwner(OrdistInfo arg0) {
		if (codOwner > arg0.codOwner) 
			return  1;		
		
		if (codOwner < arg0.codOwner) 
			return -1;
		
		return 0;
	}
	
	
	
	private int compareToCodOrder(OrdistInfo arg0) {
		if (codOrder > arg0.codOrder) 
			return  1;		
		
		if (codOrder < arg0.codOrder) 
			return -1;
		
		return 0;
	}
}
