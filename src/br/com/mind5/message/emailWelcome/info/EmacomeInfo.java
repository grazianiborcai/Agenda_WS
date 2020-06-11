package br.com.mind5.message.emailWelcome.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmacomeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String recipientAddr;
	public String password;	
	public String username;		
	public EmabodyInfo bodyData;
	public PersolisInfo persolisData;
	public OwnelisInfo ownelisData;
	
	
	public EmacomeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		bodyData = DefaultValue.object();
		persolisData = DefaultValue.object();
		ownelisData = DefaultValue.object();
	}
	
	
	
	public static EmacomeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmacomeInfo.class);
	}
	
	
	
	public static List<EmacomeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmacomeInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		EmacomeInfo deepCopy = (EmacomeInfo) super.clone();
		
		deepCopy.bodyData = CloneUtil.cloneRecord(bodyData, this.getClass());
		deepCopy.persolisData = CloneUtil.cloneRecord(deepCopy.persolisData, this.getClass());
		deepCopy.ownelisData = CloneUtil.cloneRecord(deepCopy.ownelisData, this.getClass());
		
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
		
		
		if (!(o instanceof EmacomeInfo))
			return false;
		
		
		EmacomeInfo obj = (EmacomeInfo) o;		
		return (codOwner == obj.codOwner					&&
				super.isStringEqual(username, obj.username)	&&	
				super.isStringEqual(password, obj.password));
	}	
}
