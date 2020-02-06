package br.com.mind5.business.orderListAuth.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OrdistauInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codOrder;	
	public String codOrderExt;	
	public long codCustomer;
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
	
	
	public OrdistauInfo() {
		super(OrdistauInfo.class);
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();				
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();		
		itemTotal = DefaultValue.number();
		feeService = DefaultValue.number();
		grandTotal = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		postingYear = DefaultValue.number();
		postingYearMonth = DefaultValue.number();
	}
	
	
	
	public static OrdistauInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdistauInfo.class);
	}
	
	
	
	public static List<OrdistauInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdistauInfo.class);
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
		
		
		if (!(o instanceof OrdistauInfo))
			return false;
		
		
		OrdistauInfo obj = (OrdistauInfo) o;		
		return (codOwner    == obj.codOwner && 
				codOrder 	== obj.codOrder &&
				codUser     == obj.codUser		);
	}
}
