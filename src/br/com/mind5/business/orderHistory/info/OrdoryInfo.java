package br.com.mind5.business.orderHistory.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OrdoryInfo extends InfoRecord implements Cloneable, Comparable<OrdoryInfo> {
	public long codOwner;	
	public long codOrder;	
	public String codOrderExt;	
	public long codUser;
	public int itemCounter;
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
	public List<OrdemistInfo> ordemists;
	
	
	public OrdoryInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();				
		codUser = DefaultValue.number();		
		itemCounter = DefaultValue.number();
		itemTotal = DefaultValue.number();
		feeService = DefaultValue.number();
		grandTotal = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		postingYear = DefaultValue.number();
		postingYearMonth = DefaultValue.number();
		ordemists = DefaultValue.list();
	}
	
	
	
	public static OrdoryInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdoryInfo.class);
	}
	
	
	
	public static List<OrdoryInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdoryInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrdoryInfo deepCopy = (OrdoryInfo) super.clone();
		
		deepCopy.ordemists = CloneUtil.cloneRecords(ordemists, this.getClass());
		return deepCopy;
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
		
		
		if (!(o instanceof OrdoryInfo))
			return false;
		
		
		OrdoryInfo obj = (OrdoryInfo) o;		
		return (codOwner    == obj.codOwner && 
				codOrder 	== obj.codOrder &&
				codUser     == obj.codUser		);
	}
	
	
	
	@Override public int compareTo(OrdoryInfo arg0) {
		super.checkCompareToArgument(arg0);
		
		int result = compareToCodOwner(arg0);		
		if (result != 0) return result;
		
		result = compareToCodOrder(arg0);		
		if (result != 0) return result;
		
		return 0;
	}
	
	
	
	private int compareToCodOwner(OrdoryInfo arg0) {
		if (codOwner > arg0.codOwner) 
			return  1;		
		
		if (codOwner < arg0.codOwner) 
			return -1;
		
		return 0;
	}
	
	
	
	private int compareToCodOrder(OrdoryInfo arg0) {
		if (codOrder > arg0.codOrder) 
			return  1;		
		
		if (codOrder < arg0.codOrder) 
			return -1;
		
		return 0;
	}
}
