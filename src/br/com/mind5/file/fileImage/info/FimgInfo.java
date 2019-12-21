package br.com.mind5.file.fileImage.info;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FimgInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codFileImg;
	public String fileImgUri;
	public String fileImgName;
	public String fileImgExtension;
	public String fileImgPath;
	public transient InputStream fileImgData;
	public boolean isCover;
	public long codPerson;
	public long codEmployee;
	public long codCustomer;
	public long codMat;
	public long codStore;
	public long codOwnerRef;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public long createdBy;
	public String recordMode;
	public String username;
	
	
	public FimgInfo() {
		super(FimgInfo.class);
		
		codOwner = DefaultValue.number();
		codFileImg = DefaultValue.number();	
		isCover = DefaultValue.boole();
		codPerson = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();		
		codOwnerRef = DefaultValue.number();	
		createdOn = DefaultValue.object();
		lastChanged = DefaultValue.object();
		lastChangedBy = DefaultValue.number();	
		createdBy = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static FimgInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FimgInfo.class);
	}
	
	
	
	public static List<FimgInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FimgInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner   ^ (codOwner   >>> 32));
		result = result * 31 + (int) (codFileImg ^ (codFileImg >>> 32));
		
		if (fileImgName != null)
			result = result * 31 + fileImgName.hashCode();
		
		if (fileImgExtension != null)
			result = result * 31 + fileImgExtension.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FimgInfo))
			return false;
		
		
		FimgInfo obj = (FimgInfo) o;		
		return (codOwner    == obj.codOwner   && 
				codFileImg 	== obj.codFileImg &&
				super.isStringEqual(fileImgName, obj.fileImgName) &&
				super.isStringEqual(fileImgExtension, obj.fileImgExtension));
	}	
}
