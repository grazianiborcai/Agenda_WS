package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StorbyInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codAddress;
	public long codStore;
	public String districtSearch;
	public float longitude;
	public float latitude;
	public String geoHash03;
	public String geoHash04;	
	public String geoHash05;
	public String geoHash12;
	public String recordMode;
	public String username;
	
	
	public StorbyInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codAddress = DefaultValue.number();
		codStore = DefaultValue.number();
		longitude = DefaultValue.geo();
		latitude = DefaultValue.geo();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StorbyInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorbyInfo.class);
	}
	
	
	
	public static List<StorbyInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorbyInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner 	 	^ (codOwner   	>>> 32));
		result = result * 31 + (int) (codAddress 	^ (codAddress 	>>> 32));	
		result = result * 31 + (int) (codStore 		^ (codStore 	>>> 32));
		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StorbyInfo))
			return false;
		
		
		StorbyInfo obj = (StorbyInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codAddress 	== obj.codAddress	&&
				codStore	== obj.codStore			);
	}	
}
