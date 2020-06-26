package br.com.mind5.security.user.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class UserInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public long codSnapshot;
	public String username;
	public char codUserCategory;
	public String codAuthGroup;
	public long codPerson;
	public PersonInfo personData;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public List<AuthgroleInfo> authgroles;
	public List<CusparInfo> cuspars;
	public FimistInfo fimistData;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	
	
	public UserInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codUserCategory = DefaultValue.character();
		codPerson = DefaultValue.number();
		personData = DefaultValue.object();
		authgroles = DefaultValue.list();
		cuspars = DefaultValue.list();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();	
		fimistData = DefaultValue.object();
		recordMode = DefaultValue.recordMode();		
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static UserInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UserInfo.class);
	}
	
	
	
	public static List<UserInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UserInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		UserInfo deepCopy = (UserInfo) super.clone();
		
		deepCopy.addresses = CloneUtil.cloneRecords(deepCopy.addresses, this.getClass());
		deepCopy.phones = CloneUtil.cloneRecords(deepCopy.phones, this.getClass());
		deepCopy.personData = CloneUtil.cloneRecord(deepCopy.personData, this.getClass());
		deepCopy.authgroles = CloneUtil.cloneRecords(deepCopy.authgroles, this.getClass());
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
		
		
		if (!(o instanceof UserInfo))
			return false;
		
		
		UserInfo obj = (UserInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codUser  == obj.codUser		&&
				super.isStringEqual(username, obj.username)	);
	}
}
