package br.com.mind5.masterData.materialGroupOwner.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.info.InfoRecord;

public class MatoupowInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public int codGroup;
	public String txtGroup;
	public int codBusiness;
	public String txtBusiness;
	public FimgysInfo fimgysData;
	public String username;
	
	
	public MatoupowInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codGroup = DefaultValue.number();
		codBusiness = DefaultValue.number();
	}
	
	
	
	public static MatoupowInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatoupowInfo.class);
	}
	
	
	
	public static List<MatoupowInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatoupowInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		MatoupowInfo deepCopy = (MatoupowInfo) super.clone();
		
		deepCopy.fimgysData = CloneUtil.cloneRecord(fimgysData, this.getClass());
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + codGroup;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatoupowInfo))
			return false;
		
		
		MatoupowInfo obj = (MatoupowInfo) o;		
		return (codOwner == obj.codOwner &&
				codGroup == obj.codGroup);
	}
}
