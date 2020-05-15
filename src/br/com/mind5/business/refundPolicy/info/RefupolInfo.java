package br.com.mind5.business.refundPolicy.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;

public final class RefupolInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codOrder;
	public int codOrderItem;	
	public long codStore;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;
	public long remainingHour;
	public boolean hasPassed;
	public List<RefugritemInfo> refugritemes;
	public String username;
	
	
	public RefupolInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codOrder = DefaultValue.number();
		codOrderItem = DefaultValue.number();
		codStore = DefaultValue.number();
		codMat = DefaultValue.number();
		remainingHour = DefaultValue.number();
		refugritemes = DefaultValue.list();
		hasPassed = true;
	}
	
	
	
	public static RefupolInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefupolInfo.class);
	}
	
	
	
	public static List<RefupolInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefupolInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		RefupolInfo deepCopy = (RefupolInfo) super.clone();
		
		deepCopy.refugritemes = CloneUtil.cloneRecords(refugritemes, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    	^ (codOwner    		>>> 32));
		result = result * 31 + (int) (codOrder 	  	^ (codOrder 	 	>>> 32));
		result = result * 31 + (int) (codOrderItem 	^ (codOrderItem 	>>> 32));
		result = result * 31 + (int) (codStore 	  	^ (codStore 	 	>>> 32));
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
		
		
		if (!(o instanceof RefupolInfo))
			return false;
		
		
		RefupolInfo obj = (RefupolInfo) o;		
		return (codOwner    	== obj.codOwner    		&& 
				codOrder    	== obj.codOrder			&&
				codOrderItem	== obj.codOrderItem		&&
				codStore    	== obj.codStore			&&
				codMat    		== obj.codMat			&&
				super.isDateEqual(date, obj.date)		&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}
}
