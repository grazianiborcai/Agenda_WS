package br.com.mind5.security.otp.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class OtpInfo extends InfoRecord implements Cloneable {
	public String password;
	public byte[] hash;
	public byte[] salt;
	public byte[] hashToMatch;
	public int hashLength;
	
	
	public OtpInfo() {
		super();
	}
	
	
	
	public static OtpInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OtpInfo.class);
	}
	
	
	
	public static List<OtpInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OtpInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (password != null)
			result = result * 31 + password.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof OtpInfo))
			return false;
		
		
		OtpInfo obj = (OtpInfo) o;		
		return (super.isStringEqual(password, obj.password));
	}
}
