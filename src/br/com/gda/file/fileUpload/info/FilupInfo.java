package br.com.gda.file.fileUpload.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class FilupInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codFileImg;
	public String fileImgFullName;
	public String fileImgName;
	public String fileImgExtension;
	public String fileImgPath;
	public long codPerson;
	public long codMat;
	public long codCompany;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public long createdBy;
	public String recordMode;
	public String username;
	public String codLanguage;
	
	
	public FilupInfo() {
		codOwner = DefaultValue.number();
		codFileImg = DefaultValue.number();		
		codPerson = DefaultValue.number();
		codMat = DefaultValue.number();
		codCompany = DefaultValue.number();		
		createdOn = DefaultValue.object();
		lastChanged = DefaultValue.object();
		codLanguage = DefaultValue.language();
		lastChangedBy = DefaultValue.number();	
		createdBy = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static FilupInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FilupInfo.class);
	}
	
	
	
	public static List<FilupInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FilupInfo.class);
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
		
		
		if (!(o instanceof FilupInfo))
			return false;
		
		
		FilupInfo obj = (FilupInfo) o;		
		return (codOwner    == obj.codOwner   && 
				codFileImg 	== obj.codFileImg &&
				super.isStringEqual(fileImgName, obj.fileImgName) &&
				super.isStringEqual(fileImgExtension, obj.fileImgExtension));
	}	
}
