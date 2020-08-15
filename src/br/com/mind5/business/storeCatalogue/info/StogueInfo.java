package br.com.mind5.business.storeCatalogue.info;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

public final class StogueInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String districtSearch;
	public String nameSearch;
	public float longitude;
	public float latitude;
	public int codBusiness;
	public String txtBusiness; 
	public String username;
	public List<StorbyInfo> storbys;
	public List<MatoupInfo> matoups;
	
	
	public StogueInfo() {
		super();
		
		codOwner = DefaultValue.number();
		longitude = DefaultValue.geo();
		latitude = DefaultValue.geo();
		codBusiness = DefaultValue.number();
		storbys = DefaultValue.list();
		matoups = DefaultValue.list();
	}
	
	
	
	public static StogueInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StogueInfo.class);
	}
	
	
	
	public static List<StogueInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StogueInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StogueInfo deepCopy = (StogueInfo) super.clone();
		
		deepCopy.storbys = CloneUtil.cloneRecords(storbys, this.getClass());
		deepCopy.matoups = CloneUtil.cloneRecords(matoups, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		if (nameSearch != null)
			result = result * 31 + nameSearch.hashCode();
		
		if (districtSearch != null)
			result = result * 31 + districtSearch.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StogueInfo))
			return false;
		
		
		StogueInfo obj = (StogueInfo) o;		
		return (codOwner == obj.codOwner && 
				super.isStringEqual(nameSearch, obj.nameSearch) &&
				super.isStringEqual(districtSearch, obj.districtSearch));
	}	
}
