package br.com.gda.file.fileWrite.info;

import java.io.InputStream;
import java.util.List;

import br.com.gda.info.InfoRecord;

public final class FriteInfo extends InfoRecord implements Cloneable {
	public String fileUri;
	public InputStream fileData;
	
	
	public FriteInfo() {
		super(FriteInfo.class);
	}
	
	
	
	public static FriteInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FriteInfo.class);
	}
	
	
	
	public static List<FriteInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FriteInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (fileUri != null)
			result = result * 31 + fileUri.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FriteInfo))
			return false;
		
		
		FriteInfo obj = (FriteInfo) o;		
		return (super.isStringEqual(fileUri, obj.fileUri));
	}	
}
