package br.com.mind5.business.cartItem.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

public final class CartemInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codCustomer;
	public long codUser;
	public boolean isDeleted;
	public boolean isAged;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public double price;
	public String codCurr;
	public int quantity;
	public double totitem;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;	
	public LocalDateTime createdOn;
	public String username;
	public StolisInfo stolisData;
	public EmplresInfo emplresData;
	public MatlisInfo matlisData;
	public SymsgInfo symsgData;
	
	
	public CartemInfo() {
		super();
		
		codOwner = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		isDeleted = DefaultValue.boole();
		isAged = DefaultValue.boole();
		codUser = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		price = DefaultValue.number();
		quantity = DefaultValue.number();
		totitem = DefaultValue.number();
		codWeekday = DefaultValue.number();		
		stolisData = DefaultValue.object();
		emplresData = DefaultValue.object();
		matlisData = DefaultValue.object();
		symsgData = DefaultValue.object();
	}
	
	
	
	public static CartemInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartemInfo.class);
	}
	
	
	
	public static List<CartemInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartemInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CartemInfo deepCopy = (CartemInfo) super.clone();
		
		deepCopy.date = date;
		deepCopy.beginTime = beginTime;
		deepCopy.endTime = endTime;
		deepCopy.createdOn = createdOn;
		deepCopy.stolisData = CloneUtil.cloneRecord(stolisData, this.getClass());
		deepCopy.emplresData = CloneUtil.cloneRecord(emplresData, this.getClass());
		deepCopy.matlisData = CloneUtil.cloneRecord(matlisData, this.getClass());
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
		
		
		if (!(o instanceof CartemInfo))
			return false;
		
		
		CartemInfo obj = (CartemInfo) o;		
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
