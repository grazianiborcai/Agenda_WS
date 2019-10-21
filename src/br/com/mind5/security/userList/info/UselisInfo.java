package br.com.mind5.security.userList.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class UselisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codSnapshot;
	public String username;
	public char codUserCategory;
	public String codAuthGroup;
	public long codPerson;
	public PersolisInfo personData;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;

	
	public UselisInfo() {
		super(UselisInfo.class);
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		codPerson = DefaultValue.number();
		personData = DefaultValue.object();	
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
		
		deepCopy.personData = clonePersolis(deepCopy.personData);
		
		return deepCopy;
	}
	
	
	
	private PersolisInfo clonePersolis(PersolisInfo recordInfo) throws CloneNotSupportedException {
		if (recordInfo == null)
			return null;
		
		return (PersolisInfo) recordInfo.clone();
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
