package br.com.mind5.file.filePath.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class FathInfo extends InfoRecord implements Cloneable {
	public String codFilePath;
	public String filePath;
	public String filePathExternal;
	
	
	public FathInfo() {
		super();
	}
	
	
	
	public static FathInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FathInfo.class);
	}
	
	
	
	public static List<FathInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FathInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codFilePath != null)
			result = result * 31 + codFilePath.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FathInfo))
			return false;
		
		
		FathInfo obj = (FathInfo) o;		
		return (super.isStringEqual(codFilePath, obj.codFilePath));
	}	
}
