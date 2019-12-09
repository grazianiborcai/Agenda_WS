package br.com.mind5.business.materialStore.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
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
	public String username;
	public String recordMode;
	
	
	public MatoreInfo() {
		super(MatoreInfo.class);
		
		codOwner = DefaultValue.number();
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
	}
	
	
	
	public static MatoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatoreInfo.class);
	}
	
	
	
	public static List<MatoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatoreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		MatoreInfo deepCopy = (MatoreInfo) super.clone();
		
		deepCopy.matlisData = cloneMatlis(deepCopy.matlisData);
		deepCopy.stolisData = cloneStolis(deepCopy.stolisData);
		
		return deepCopy;
	}
	
	
	
	private MatlisInfo cloneMatlis(MatlisInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (MatlisInfo) recordInfo.clone();
	}	
	
	
	
	private StolisInfo cloneStolis(StolisInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (StolisInfo) recordInfo.clone();
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
		
		
		if (!(o instanceof MatoreInfo))
			return false;
		
		
		MatoreInfo obj = (MatoreInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codMat   == obj.codMat);
	}
}
