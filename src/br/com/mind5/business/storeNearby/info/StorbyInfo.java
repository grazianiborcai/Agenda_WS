package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StorbyInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String districtSearch;
	public float longitude;
	public float latitude;
	public String geoHash03;
	public String recordMode;
	public String username;
	public StolisInfo stolisData;
	
	
	public StorbyInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		longitude = DefaultValue.geo();
		latitude = DefaultValue.geo();
		recordMode = DefaultValue.recordMode();
		stolisData = DefaultValue.object();
	}
	
	
	
	public static StorbyInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorbyInfo.class);
	}
	
	
	
	public static List<StorbyInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorbyInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StorbyInfo deepCopy = (StorbyInfo) super.clone();
		
		deepCopy.stolisData = CloneUtil.cloneRecord(stolisData, this.getClass());
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		if (geoHash03 != null)
			result = result * 31 + geoHash03.hashCode();
		
		if (districtSearch != null)
			result = result * 31 + districtSearch.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StorbyInfo))
			return false;
		
		
		StorbyInfo obj = (StorbyInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				super.isStringEqual(geoHash03, obj.geoHash03) &&
				super.isStringEqual(districtSearch, obj.districtSearch));
	}	
}
