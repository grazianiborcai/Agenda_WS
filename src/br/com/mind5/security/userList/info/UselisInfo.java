package br.com.mind5.security.userList.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;

public final class UselisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codSnapshot;
	public String username;
	public char codUserCategory;
	public String codAuthGroup;
	public long codPerson;
	public PersolisInfo persolisData;
	public FimistInfo fimistData;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;

	
	public UselisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		codPerson = DefaultValue.number();
		persolisData = DefaultValue.object();
		fimistData = DefaultValue.object();
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static UselisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UselisInfo.class);
	}
	
	
	
	public static List<UselisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UselisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		UselisInfo deepCopy = (UselisInfo) super.clone();
		
		deepCopy.persolisData = CloneUtil.cloneRecord(deepCopy.persolisData, this.getClass());
		deepCopy.fimistData = CloneUtil.cloneRecord(deepCopy.fimistData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser 	^ (codUser 	>>> 32));
		
		if (username != null)
			result = result * 31 + username.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UselisInfo))
			return false;
		
		
		UselisInfo obj = (UselisInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codUser == obj.codUser		&&
				super.isStringEqual(username, obj.username)	);
	}
}
