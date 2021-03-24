package br.com.mind5.file.sysFileImage.info;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FimgysInfo extends InfoRecord implements Cloneable {
	public long codFileImg;
	public long codSnapshot;
	public String fileImgUri;
	public String fileImgUriExternal;
	public String fileImgName;
	public String fileImgExtension;
	public String fileImgPath;
	public String fileImgPathExternal;
	public transient InputStream fileImgData;
	public boolean isCover;
	public int codGroup;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public String recordMode;
	public String username;
	
	
	public FimgysInfo() {
		super();
		
		codFileImg = DefaultValue.number();	
		codSnapshot = DefaultValue.number();
		isCover = DefaultValue.boole();	
		codGroup = DefaultValue.number();
		createdOn = DefaultValue.object();
		lastChanged = DefaultValue.object();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static FimgysInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FimgysInfo.class);
	}
	
	
	
	public static List<FimgysInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FimgysInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codFileImg  ^ (codFileImg  >>> 32));
		result = result * 31 + (int) (codGroup 	  ^ (codGroup    >>> 32));
		
		if (fileImgName != null)
			result = result * 31 + fileImgName.hashCode();
		
		if (fileImgExtension != null)
			result = result * 31 + fileImgExtension.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FimgysInfo))
			return false;
		
		
		FimgysInfo obj = (FimgysInfo) o;		
		return (codFileImg 	== obj.codFileImg  	&&
				codGroup    == obj.codGroup 	&&
				super.isStringEqual(fileImgName, obj.fileImgName) &&
				super.isStringEqual(fileImgExtension, obj.fileImgExtension));
	}	
}
