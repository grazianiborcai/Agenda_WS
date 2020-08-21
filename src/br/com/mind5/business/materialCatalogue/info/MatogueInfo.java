package br.com.mind5.business.materialCatalogue.info;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatogueInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public String username;
	public List<MatoreInfo> matores;
	
	
	public MatogueInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();	
		matores = DefaultValue.list();
	}
	
	
	
	public static MatogueInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatogueInfo.class);
	}
	
	
	
	public static List<MatogueInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatogueInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		MatogueInfo deepCopy = (MatogueInfo) super.clone();
		
		deepCopy.matores = CloneUtil.cloneRecords(deepCopy.matores, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatogueInfo))
			return false;
		
		
		MatogueInfo obj = (MatogueInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore);
	}
}
