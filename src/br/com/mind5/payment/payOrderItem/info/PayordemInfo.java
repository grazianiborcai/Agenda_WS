package br.com.mind5.payment.payOrderItem.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public final class PayordemInfo extends InfoRecord implements Cloneable, Comparable<PayordemInfo> {
	public long codOwner;
	public long codPayOrder;
	public int codPayOrderItem;
	public char codFeeCateg;
	public String txtFeeCateg;
	public int codPayPartner;
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
	public String idItemPartner;
	public String idOrderPartner;
	public String statusOrderPartner;	
	public String idPaymentPartner;	
	public String statusPaymentPartner;
	public String idRefundPartner;
	public String statusRefundPartner;
	public String itemReceiver;
	public LocalDateTime lastChanged;
	public String username;
	public StolisInfo stolisData;
	public EmplresInfo emplresData;
	public MatlisInfo matlisData;	
	
	
	public PayordemInfo() {
		super();
		
		price           = DefaultValue.number();
		codMat          = DefaultValue.number();
		totitem         = DefaultValue.number();
		codOwner        = DefaultValue.number();
		quantity        = DefaultValue.number();
		codStore        = DefaultValue.number();
		codOrder        = DefaultValue.number();
		stolisData      = DefaultValue.object();		
		matlisData      = DefaultValue.object();
		codPayOrder     = DefaultValue.number();
		emplresData     = DefaultValue.object();
		codEmployee     = DefaultValue.number();
		codFeeCateg     = DefaultValue.character();
		codOrderItem    = DefaultValue.number();
		codPayPartner   = DefaultValue.number();
		codPayOrderItem = DefaultValue.number();	
	}
	
	
	
	public static PayordemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PayordemInfo.class);
	}
	
	
	
	public static List<PayordemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PayordemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PayordemInfo deepCopy = (PayordemInfo) super.clone();
		
		deepCopy.stolisData = CloneUtil.cloneRecord(stolisData, this.getClass());
		deepCopy.emplresData = CloneUtil.cloneRecord(emplresData, this.getClass());
		deepCopy.matlisData = CloneUtil.cloneRecord(matlisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    		^ (codOwner    		>>> 32));
		result = result * 31 + (int) (codPayOrder 		^ (codPayOrder 		>>> 32));
		result = result * 31 + (int) (codStore 	  		^ (codStore 		>>> 32));
		result = result * 31 + (int) (codEmployee 		^ (codEmployee 		>>> 32));
		result = result * 31 + (int) (codMat 	  		^ (codMat 	 		>>> 32));
		result = result * 31 + (int) (codPayOrderItem 	^ (codPayOrderItem 	>>> 32));
		
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
		return (codOwner    	== obj.codOwner    		&& 
				codPayOrder 	== obj.codPayOrder		&&
				codStore    	== obj.codStore			&&
				codEmployee 	== obj.codEmployee		&&
				codMat    		== obj.codMat			&&
				codPayOrderItem == obj.codPayOrderItem	&&
				super.isDateEqual(date, obj.date)		&&
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
