package br.com.mind5.file.fileRead.info;

import java.io.InputStream;
import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class FreadInfo extends InfoRecord implements Cloneable {
	public String fileUri;
	public InputStream fileData;
	
	
	public FreadInfo() {
		super();
	}
	
	
	
	public static FreadInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FreadInfo.class);
	}
	
	
	
	public static List<FreadInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FreadInfo.class);
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
		
		
		if (!(o instanceof FreadInfo))
			return false;
		
		
		FreadInfo obj = (FreadInfo) o;		
		return (super.isStringEqual(fileUri, obj.fileUri));
	}	
}
