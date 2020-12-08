package br.com.mind5.discount.discountCalculatorItem.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.info.InfoRecord;

public final class DisalcemInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codUser;
	public long codCustomer;
	public CartemInfo cartemData;
	public List<DisoreInfo> disores;
	public DisoupemInfo disoupemData;
	public String username;
	
	
	public DisalcemInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codUser = DefaultValue.number();
		codCustomer = DefaultValue.number();
		cartemData = DefaultValue.object();
		disores = DefaultValue.list();
	}
	
	
	
	public static DisalcemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DisalcemInfo.class);
	}
	
	
	
	public static List<DisalcemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DisalcemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		DisalcemInfo deepCopy = (DisalcemInfo) super.clone();
		
		deepCopy.disoupemData = CloneUtil.cloneRecord(disoupemData, this.getClass());
		deepCopy.cartemData = CloneUtil.cloneRecord(cartemData, this.getClass());
		deepCopy.disores = CloneUtil.cloneRecords(disores, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    	^ (codOwner    	>>> 32));		
		result = result * 31 + (int) (codStore    	^ (codStore    	>>> 32));
		result = result * 31 + (int) (codUser 		^ (codUser    	>>> 32));
		result = result * 31 + (int) (codCustomer 	^ (codCustomer 	>>> 32));
		
		if (cartemData != null)
			result = result * 31 + cartemData.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DisalcemInfo))
			return false;
		
		
		DisalcemInfo obj = (DisalcemInfo) o;		
		return (codOwner    == obj.codOwner 		&& 
				codStore    == obj.codStore 		&&
				codUser 	== obj.codUser			&&
				codCustomer == obj.codCustomer		&&
				super.isRecordEqual(cartemData, obj.cartemData));
	}
}
