package br.com.mind5.file.fileImageList.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FimistInfo extends InfoRecord implements Cloneable, Comparable<FimistInfo> {
	public long codOwner;
	public long codFileImg;
	public String fileImgUriExternal;
	public String fileImgExtension;
	public boolean isCover;
	public long codPerson;
	public long codMat;
	public long codStore;
	public long codEmployee;
	public long codCustomer;
	public long codUser;
	public long codOwnerRef;
	public String recordMode;
	public String username;
	
	
	public FimistInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codFileImg = DefaultValue.number();
		isCover = DefaultValue.boole();
		codPerson = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();	
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
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
	
	
	
	@Override public int compareTo(FimistInfo arg0) {
		super.checkCompareToArgument(arg0);
		
		int result = compareToCodOwner(arg0);		
		if (result != 0) return result;
		
		result = compareToCover(arg0);		
		if (result != 0) return result;
		
		result = compareToCodFileImg(arg0);		
		if (result != 0) return result;
		
		return 0;
	}
	
	
	
	private int compareToCodOwner(FimistInfo arg0) {
		if (codOwner > arg0.codOwner) 
			return  1;		
		
		if (codOwner < arg0.codOwner) 
			return -1;
		
		return 0;
	}
	
	
	
	private int compareToCover(FimistInfo arg0) {
		if (isCover && arg0.isCover)
			return 0;
		
		if (isCover) 
			return  1;		
		
		return -1;
	}
	
	
	
	private int compareToCodFileImg(FimistInfo arg0) {
		if (codFileImg > arg0.codFileImg) 
			return  1;		
		
		if (codFileImg < arg0.codFileImg) 
			return -1;
		
		return 0;
	}
}
