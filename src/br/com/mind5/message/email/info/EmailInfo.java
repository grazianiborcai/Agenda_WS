package br.com.mind5.message.email.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmailInfo extends InfoRecord implements Cloneable {
	public String smtpHostname;
	public int smtpPort;
	public String senderAddr;
	public String senderPass;
	public String recipientAddr;
	public EmabodyInfo bodyData;
	public String username;
	
	
	public EmailInfo() {
		super();
		
		smtpPort = DefaultValue.number();
		bodyData = DefaultValue.object();
	}
	
	
	
	public static EmailInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmailInfo.class);
	}
	
	
	
	public static List<EmailInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmailInfo.class);
	}	
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		EmailInfo deepCopy = (EmailInfo) super.clone();
		
		deepCopy.bodyData = CloneUtil.cloneRecord(bodyData, this.getClass());		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (bodyData != null)
			result = result * 31 + bodyData.hashCode();
		
		if (recipientAddr != null)
			result = result * 31 + recipientAddr.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmailInfo))
			return false;
		
		
		EmailInfo obj = (EmailInfo) o;		
		return (super.isRecordEqual(bodyData, obj.bodyData)	&&	
				super.isStringEqual(recipientAddr, obj.recipientAddr));
	}	
}
