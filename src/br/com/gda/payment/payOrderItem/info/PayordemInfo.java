package br.com.gda.payment.payOrderItem.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public final class PayordemInfo extends InfoRecord implements Cloneable, Comparable<PayordemInfo> {
	public long codOwner;
	public long codPayOrder;
	public int codPayOrderItem;
	public char codFeeCateg;
	public long codOrder;
	public int codOrderItem;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public double price;
	public int quantity;
	public double totitem;
	public String codCurr;
	public LocalDate date;
	public LocalTime beginTime;
	public String ownId;
	public String idOrderPartner;
	public String statusOrderPartner;	
	public String idPaymentPartner;	
	public String statusPaymentPartner;
	public String idRefundPartner;
	public String statusRefundPartner;
	public int codPayPartner;
	public String itemReceiver;
	public boolean isSystemReceiver;
	public LocalDateTime lastChanged;
	public String username;
	public StolisInfo stolisData;
	public EmplisInfo emplisData;
	public MatInfo matData;	
	public String codLanguage;
	
	
	public PayordemInfo() {
		super(PayordemInfo.class);
		
		codOwner = DefaultValue.number();	
		codPayOrderItem = DefaultValue.number();	
		codOrder = DefaultValue.number();	
		codOrderItem = DefaultValue.number();
		codFeeCateg = DefaultValue.character();
		codPayOrder = DefaultValue.number();
		codPayPartner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		price = DefaultValue.number();
		quantity = DefaultValue.number();
		totitem = DefaultValue.number();
		isSystemReceiver = DefaultValue.boole();
		stolisData = DefaultValue.object();
		emplisData = DefaultValue.object();
		matData = DefaultValue.object();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static PayordemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordemInfo.class);
	}
	
	
	
	public static List<PayordemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PayordemInfo deepCopy = (PayordemInfo) super.clone();
		
		deepCopy.date = date;
		deepCopy.beginTime = beginTime;
		deepCopy.stolisData = cloneStolis(stolisData);
		deepCopy.emplisData = cloneEmplis(emplisData);
		deepCopy.matData = cloneMat(matData);
		
		return deepCopy;
	}
	
	
	
	private MatInfo cloneMat(MatInfo recordInfo) throws CloneNotSupportedException {
		MatInfo result = null;
		
		if (recordInfo != null)
			result = (MatInfo) recordInfo.clone();
		
		return result;
	}
	
	
	
	private StolisInfo cloneStolis(StolisInfo recordInfo) throws CloneNotSupportedException {
		StolisInfo result = null;
		
		if (recordInfo != null)
			result = (StolisInfo) recordInfo.clone();
		
		return result;
	}
	
	
	
	private EmplisInfo cloneEmplis(EmplisInfo recordInfo) throws CloneNotSupportedException {
		EmplisInfo result = null;
		
		if (recordInfo != null)
			result = (EmplisInfo) recordInfo.clone();
		
		return result;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codPayOrder ^ (codPayOrder >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + (int) (codPayOrderItem 	  ^ (codPayOrderItem 	 >>> 32));
		
		if (date != null)
			result = result * 31 + (int) date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + (int) beginTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PayordemInfo))
			return false;
		
		
		PayordemInfo obj = (PayordemInfo) o;		
		return (codOwner    == obj.codOwner    		&& 
				codPayOrder == obj.codPayOrder		&&
				codStore    == obj.codStore			&&
				codEmployee == obj.codEmployee		&&
				codMat    	== obj.codMat			&&
				codPayOrderItem    	== obj.codPayOrderItem			&&
				super.isDateEqual(date, obj.date)	&&
				super.isTimeEqual(beginTime, obj.beginTime));
	}


	
	@Override public int compareTo(PayordemInfo arg0) {
		if (arg0 == null) {
			super.logException(new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("arg0" + SystemMessage.NULL_ARGUMENT);	
		}

		
		if (codPayOrderItem < arg0.codPayOrderItem)
			return -1;
		
		if (codPayOrderItem > arg0.codPayOrderItem)
			return 1;
		
		if (equals(arg0))
			return 0;
		
		
		super.logException(new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE));
		throw new IllegalArgumentException(SystemMessage.COMPARE_NOT_POSSIBLE);
	}
}
