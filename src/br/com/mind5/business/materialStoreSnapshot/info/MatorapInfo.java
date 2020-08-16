package br.com.mind5.business.materialStoreSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatorapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codStore;	
	public long codMat;
	public double matPrice;
	public double matPrice1;
	public double matPrice2;
	public double matPrice3;
	public double matPrice4;
	public double matPrice5;
	public double matPrice6;
	public double matPrice7;
	public int quantityStock;
	public MatlisInfo matlisData;
	public StolisInfo stolisData;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	public String recordMode;
	
	
	public MatorapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codStore = DefaultValue.number();	
		codMat = DefaultValue.number();
		matPrice = DefaultValue.number();
		matPrice1 = DefaultValue.number();
		matPrice2 = DefaultValue.number();
		matPrice3 = DefaultValue.number();
		matPrice4 = DefaultValue.number();
		matPrice5 = DefaultValue.number();
		matPrice6 = DefaultValue.number();
		matPrice7 = DefaultValue.number();
		quantityStock = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		matlisData = DefaultValue.object();
		stolisData = DefaultValue.object();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static MatorapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatorapInfo.class);
	}
	
	
	
	public static List<MatorapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatorapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		MatorapInfo deepCopy = (MatorapInfo) super.clone();
		
		deepCopy.matlisData = CloneUtil.cloneRecord(deepCopy.matlisData, this.getClass());
		deepCopy.stolisData = CloneUtil.cloneRecord(deepCopy.stolisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore	 >>> 32));
		result = result * 31 + (int) (codMat 	^ (codMat	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatorapInfo))
			return false;
		
		
		MatorapInfo obj = (MatorapInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codMat   == obj.codMat);
	}
}
