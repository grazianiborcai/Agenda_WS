package br.com.gda.business.storeList.info;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class StolisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codSnapshot;
	public long codCompany;
	public String codCurr;
	public String txtCurr;
	public String codTimezone;
	public String txtTimezone;
	public String codLanguage;
	public List<AddressInfo> addresses;
	public List<PhoneInfo> phones;
	public CompInfo companyData;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;

	
	
	public StolisInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codCompany = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
		companyData = DefaultValue.object();
		addresses = DefaultValue.list();
		phones = DefaultValue.list();
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static StolisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StolisInfo.class);
	}
	
	
	
	public static List<StolisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StolisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StolisInfo deepCopy = (StolisInfo) super.clone();
		
		deepCopy.addresses = cloneAddresses(deepCopy.addresses);
		deepCopy.phones = clonePhones(deepCopy.phones);
		deepCopy.companyData = cloneCompany(deepCopy.companyData);
		
		return deepCopy;
	}
	
	
	
	private List<AddressInfo> cloneAddresses(List<AddressInfo> addressesToClone) throws CloneNotSupportedException {
		if (addressesToClone == null)
			return null;
		
		List<AddressInfo> deepAddresses = new ArrayList<>();
		
		for (AddressInfo eachAddress : addressesToClone) {
			AddressInfo clonedAddress = (AddressInfo) eachAddress.clone();
			deepAddresses.add(clonedAddress);
		}
		
		return deepAddresses;
	}
	
	
	
	private List<PhoneInfo> clonePhones(List<PhoneInfo> phonesToClone) throws CloneNotSupportedException {
		if (phonesToClone == null)
			return null;
		
		List<PhoneInfo> deepPhones = new ArrayList<>();
		
		for (PhoneInfo eachPhone : phonesToClone) {
			PhoneInfo clonedPhone = (PhoneInfo) eachPhone.clone();
			deepPhones.add(clonedPhone);
		}
		
		return deepPhones;
	}
	
	
	
	private CompInfo cloneCompany(CompInfo companyToClone) throws CloneNotSupportedException {
		if (companyToClone == null)
			return null;
		
		return (CompInfo) companyToClone.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StolisInfo))
			return false;
		
		
		StolisInfo obj = (StolisInfo) o;		
		return (codOwner == obj.codOwner && codStore == obj.codStore);
	}
}
