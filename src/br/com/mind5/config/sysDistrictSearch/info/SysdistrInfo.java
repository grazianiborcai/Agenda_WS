package br.com.mind5.config.sysDistrictSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SysdistrInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String districtSearchDefault;
	
	
	public SysdistrInfo() {
		super();
		
		codOwner = DefaultValue.number();
	}
	
	
	
	public static SysdistrInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SysdistrInfo.class);
	}
	
	
	
	public static List<SysdistrInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SysdistrInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
		if (districtSearchDefault != null)
			result = result * 31 + districtSearchDefault.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SysdistrInfo))
			return false;
		
		
		SysdistrInfo obj = (SysdistrInfo) o;		
		return (codOwner == obj.codOwner 	&&
				isStringEqual(districtSearchDefault, obj.districtSearchDefault));
	}
}
