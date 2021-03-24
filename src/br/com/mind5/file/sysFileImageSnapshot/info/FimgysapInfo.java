package br.com.mind5.file.sysFileImageSnapshot.info;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FimgysapInfo extends InfoRecord implements Cloneable {
	public long codSnapshot;
	public long codFileImg;
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
	
	
	public FimgysapInfo() {
		super();
		

		codSnapshot = DefaultValue.number();
		codFileImg = DefaultValue.number();	
		isCover = DefaultValue.boole();	
		codGroup = DefaultValue.number();
		createdOn = DefaultValue.object();
		lastChanged = DefaultValue.object();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static FimgysapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FimgysapInfo.class);
	}
	
	
	
	public static List<FimgysapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FimgysapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codSnapshot ^ (codSnapshot >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FimgysapInfo))
			return false;
		
		
		FimgysapInfo obj = (FimgysapInfo) o;		
		return (codSnapshot == obj.codSnapshot);
	}	
}
