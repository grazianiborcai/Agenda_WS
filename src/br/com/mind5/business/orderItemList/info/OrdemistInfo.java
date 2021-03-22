package br.com.mind5.business.orderItemList.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class OrdemistInfo extends InfoRecord implements Cloneable, Comparable<OrdemistInfo> {
	public long codOwner;
	public long codOrder;
	public int codOrderItem;	
	public long codSnapshot;
	public String codOrderStatus;
	public String txtOrderStatus;
	public String statusOrderPartner;
	public String statusPaymentPartner;
	public long codPayOrder;
	public int codPayOrderItem;
	public long codCustomer;
	public long codUser;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public double price;
	public int quantity;
	public double totitem;
	public String codCurr;
	public String txtCurr;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public MatlisInfo matlisData;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public OrdemistInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();
		codOrderItem = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPayOrder = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		price = DefaultValue.number();
		quantity = DefaultValue.number();
		totitem = DefaultValue.number();
		codWeekday = DefaultValue.number();
		matlisData = DefaultValue.object();
		lastChangedBy = DefaultValue.number();	
	}
	
	
	
	public static OrdemistInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OrdemistInfo.class);
	}
	
	
	
	public static List<OrdemistInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OrdemistInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		OrdemistInfo deepCopy = (OrdemistInfo) super.clone();
		
		deepCopy.matlisData = CloneUtil.cloneRecord(matlisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    	^ (codOwner    		>>> 32));
		result = result * 31 + (int) (codOrder 	  	^ (codOrder 	 	>>> 32));
		result = result * 31 + (int) (codOrderItem 	^ (codOrderItem 	>>> 32));
		result = result * 31 + (int) (codStore 	  	^ (codStore 	 	>>> 32));
		result = result * 31 + (int) (codEmployee 	^ (codEmployee 		>>> 32));
		result = result * 31 + (int) (codMat 	  	^ (codMat 	 		>>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + (int) beginTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OrdemistInfo))
			return false;
		
		
		OrdemistInfo obj = (OrdemistInfo) o;		
		return (codOwner    	== obj.codOwner    		&& 
				codOrder    	== obj.codOrder			&&
				codOrderItem	== obj.codOrderItem		&&
				codStore    	== obj.codStore			&&
				codEmployee 	== obj.codEmployee		&&
				codMat    		== obj.codMat			&&
				super.isDateEqual(date, obj.date)		&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}


	
	@Override public int compareTo(OrdemistInfo arg0) {
		if (arg0 == null) {
			super.logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}

		
		if (codOrderItem< arg0.codOrderItem)
			return -1;
		
		if (codOrderItem > arg0.codOrderItem)
			return 1;
		
		if (equals(arg0))
			return 0;
		
		
		super.logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);
	}
}
