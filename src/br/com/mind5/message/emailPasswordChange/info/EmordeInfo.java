package br.com.mind5.message.emailPasswordChange.info;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmordeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codUser;
	public String recipientAddr;
	public String username;		
	public EmabodyInfo bodyData;
	public PersolisInfo persolisData;
	
	
	public EmordeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codUser = DefaultValue.number();
		bodyData = DefaultValue.object();
		persolisData = DefaultValue.object();
	}
	
	
	
	public static EmordeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmordeInfo.class);
	}
	
	
	
	public static List<EmordeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmordeInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		EmordeInfo deepCopy = (EmordeInfo) super.clone();
		
		deepCopy.bodyData = CloneUtil.cloneRecord(bodyData, this.getClass());
		deepCopy.persolisData = CloneUtil.cloneRecord(persolisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codUser  ^ (codUser  >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmordeInfo))
			return false;
		
		
		EmordeInfo obj = (EmordeInfo) o;		
		return (codOwner == obj.codOwner &&
				codUser  == obj.codUser);
	}	
}
