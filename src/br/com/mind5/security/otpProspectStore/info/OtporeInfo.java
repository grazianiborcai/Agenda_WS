package br.com.mind5.security.otpProspectStore.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class OtporeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String prospectEmail;
	public String password;
	public byte[] hash;
	public byte[] salt;
	public byte[] hashToMatch;
	public int hashLength;
	public LocalDateTime validUntil;
	public LocalDateTime lastChanged;

	
	public OtporeInfo() {
		super();
		
		codOwner = DefaultValue.number();
	}
	
	
	
	public static OtporeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OtporeInfo.class);
	}
	
	
	
	public static List<OtporeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OtporeInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner >>> 32));
		
		if (prospectEmail != null)
			result = result * 31 + prospectEmail.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OtporeInfo))
			return false;
		
		
		OtporeInfo obj = (OtporeInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				super.isStringEqual(prospectEmail, obj.prospectEmail));
	}
}
