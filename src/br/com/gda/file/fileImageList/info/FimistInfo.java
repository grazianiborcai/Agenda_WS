package br.com.gda.file.fileImageList.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class FimistInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codFileImg;
	public String fileImgUri;
	public String fileImgExtension;
	public boolean isCover;
	public long codPerson;
	public long codMat;
	public long codStore;
	public long codOwnerRef;
	public String recordMode;
	public String username;
	
	
	public FimistInfo() {
		super(FimistInfo.class);
		
		codOwner = DefaultValue.number();
		codFileImg = DefaultValue.number();
		isCover = DefaultValue.boole();
		codPerson = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();		
		codOwnerRef = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static FimistInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FimistInfo.class);
	}
	
	
	
	public static List<FimistInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FimistInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner   ^ (codOwner   >>> 32));
		result = result * 31 + (int) (codFileImg ^ (codFileImg >>> 32));
		
		if (fileImgExtension != null)
			result = result * 31 + fileImgExtension.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FimistInfo))
			return false;
		
		
		FimistInfo obj = (FimistInfo) o;		
		return (codOwner    == obj.codOwner   && 
				codFileImg 	== obj.codFileImg &&
				super.isStringEqual(fileImgExtension, obj.fileImgExtension));
	}	
}
