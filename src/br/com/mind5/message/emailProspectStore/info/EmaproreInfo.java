package br.com.mind5.message.emailProspectStore.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmaproreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String recipientAddr;
	public String password;	
	public String username;		
	public EmabodyInfo bodyData;
	
	
	public EmaproreInfo() {
		super();
		
		codOwner = DefaultValue.number();
		bodyData = DefaultValue.object();
	}
	
	
	
	public static EmaproreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmaproreInfo.class);
	}
	
	
	
	public static List<EmaproreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmaproreInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		EmaproreInfo deepCopy = (EmaproreInfo) super.clone();
		
		deepCopy.bodyData = CloneUtil.cloneRecord(bodyData, this.getClass());
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		
		if (username != null)
			result = result * 31 + username.hashCode();
		
		if (password != null)
			result = result * 31 + password.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmaproreInfo))
			return false;
		
		
		EmaproreInfo obj = (EmaproreInfo) o;		
		return (codOwner == obj.codOwner					&&
				super.isStringEqual(username, obj.username)	&&	
				super.isStringEqual(password, obj.password));
	}	
}
