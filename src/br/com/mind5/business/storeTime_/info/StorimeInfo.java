package br.com.mind5.business.storeTime_.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StorimeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public String username;
	public List<StowotmInfo> stowotms;
	
	
	public StorimeInfo() {
		super(StorimeInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		stowotms = DefaultValue.list();
	}
	
	
	
	public static StorimeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StorimeInfo.class);
	}
	
	
	
	public static List<StorimeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StorimeInfo.class);
	}



	@Override public Object clone() throws CloneNotSupportedException {  
		StorimeInfo deepCopy = (StorimeInfo) super.clone();  
		
		deepCopy.stowotms =  cloneStowotms(deepCopy.stowotms);
				
		return deepCopy;	
	} 
	
	
	
	private List<StowotmInfo> cloneStowotms(List<StowotmInfo> records) throws CloneNotSupportedException {
		if (records == null)
			return null;
		
		List<StowotmInfo> results = new ArrayList<>();
		
		for (StowotmInfo eachRecord : records) {
			StowotmInfo clonedRecord = (StowotmInfo) eachRecord.clone();
			results.add(clonedRecord);
		}
		
		return results;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StorimeInfo))
			return false;
		
		
		StorimeInfo obj = (StorimeInfo) o;		
		return ( codOwner == obj.codOwner && codStore == obj.codStore );
	}	
}

