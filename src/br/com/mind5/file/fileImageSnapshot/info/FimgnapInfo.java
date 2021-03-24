package br.com.mind5.file.fileImageSnapshot.info;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class FimgnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
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
	public long codPerson;
	public long codEmployee;
	public long codCustomer;
	public long codUser;
	public long codMat;
	public long codStore;
	public long codOwnerRef;
	public int codGroup;
	public LocalDateTime createdOn;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public long createdBy;
	public String recordMode;
	public String username;
	
	
	public FimgnapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codFileImg = DefaultValue.number();	
		isCover = DefaultValue.boole();
		codPerson = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codUser = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();		
		codOwnerRef = DefaultValue.number();
		codGroup = DefaultValue.number();
		createdOn = DefaultValue.object();
		lastChanged = DefaultValue.object();
		lastChangedBy = DefaultValue.number();	
		createdBy = DefaultValue.number();	
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static FimgnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FimgnapInfo.class);
	}
	
	
	
	public static List<FimgnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FimgnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codSnapshot ^ (codSnapshot >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FimgnapInfo))
			return false;
		
		
		FimgnapInfo obj = (FimgnapInfo) o;		
		return (codOwner    == obj.codOwner    	&& 
				codSnapshot == obj.codSnapshot);
	}	
}
