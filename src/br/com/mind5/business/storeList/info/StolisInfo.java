package br.com.mind5.business.storeList.info;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoRecord;

public final class StolisInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codSnapshot;
	public long codCompany;
	public String codCurr;
	public String txtCurr;
	public String codTimezone;
	public String txtTimezone;
	public boolean isLocked;
	public StoracInfo storacData;
	public StorextInfo storextData;
	public AddressInfo addressData;
	public List<PhoneInfo> phones;
	public ComplisInfo complisData;
	public FimecoInfo fimecoData;
	public String username;
	public String recordMode;
	
	
	public StolisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codCompany = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		isLocked = DefaultValue.boole();
		storacData = DefaultValue.object();
		storextData = DefaultValue.object();
		complisData = DefaultValue.object();
		addressData = DefaultValue.object();
		phones = DefaultValue.list();
		fimecoData = DefaultValue.object();
	}
	
	
	
	public static StolisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StolisInfo.class);
	}
	
	
	
	public static List<StolisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StolisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StolisInfo deepCopy = (StolisInfo) super.clone();		
		
		deepCopy.storextData = CloneUtil.cloneRecord(storextData, this.getClass());
		deepCopy.fimecoData = CloneUtil.cloneRecord(fimecoData, this.getClass());
		deepCopy.addressData = CloneUtil.cloneRecord(addressData, this.getClass());
		deepCopy.phones = CloneUtil.cloneRecords(phones, this.getClass());
		deepCopy.complisData = CloneUtil.cloneRecord(complisData, this.getClass());
		deepCopy.storacData = CloneUtil.cloneRecord(storacData, this.getClass());
		
		return deepCopy;
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
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore	);
	}
}
