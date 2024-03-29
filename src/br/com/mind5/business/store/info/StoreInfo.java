package br.com.mind5.business.store.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoRecord;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;

public final class StoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codSnapshot;	
	public long codUser;
	public long codCompany;
	public long codLegalPerson;
	public String codCurr;
	public String txtCurr;
	public String codTimezone;
	public String txtTimezone;
	public long codBankAccount;
	public boolean isLocked;
	public AddressInfo addressData;
	public List<PhoneInfo> phones;
	public FimecoInfo fimecoData;
	public List<StorextInfo> storextes;
	public CompInfo companyData;
	public PersonInfo userPersonData;
	public PeregInfo peregData;
	public StoracInfo storacData;
	public StefilonInfo stefilonData;
	public BankaccInfo bankaccData;
	public List<StowotmInfo> stowotmes;
	public List<StuntmInfo> stuntmes;
	public List<MatoreInfo> matores;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	
	
	public StoreInfo() {
		super();
		
		phones         = DefaultValue.list();
		codUser 	   = DefaultValue.number();
		matores        = DefaultValue.list();
		stuntmes       = DefaultValue.list();
		isLocked       = DefaultValue.boole();
		codOwner 	   = DefaultValue.number();
		codStore 	   = DefaultValue.number();
		createdBy      = DefaultValue.number();
		stowotmes      = DefaultValue.list();
		peregData 	   = DefaultValue.object();
		storextes 	   = DefaultValue.list();
		recordMode 	   = DefaultValue.recordMode();
		storacData     = DefaultValue.object();
		fimecoData     = DefaultValue.object();
		codCompany 	   = DefaultValue.number();
		codSnapshot    = DefaultValue.number();
		bankaccData    = DefaultValue.object();
		addressData    = DefaultValue.object();
		companyData    = DefaultValue.object();
		stefilonData   = DefaultValue.object();		
		lastChangedBy  = DefaultValue.number();
		codLegalPerson = DefaultValue.number();
		codBankAccount = DefaultValue.number();
		userPersonData = DefaultValue.object();
	}
	
	
	
	public static StoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreInfo.class);
	}
	
	
	
	public static List<StoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		StoreInfo deepCopy = (StoreInfo) super.clone();
		
		deepCopy.storextes      = CloneUtil.cloneRecords(deepCopy.storextes    , this.getClass());
		deepCopy.fimecoData     = CloneUtil.cloneRecord(deepCopy.fimecoData    , this.getClass());
		deepCopy.addressData    = CloneUtil.cloneRecord(deepCopy.addressData   , this.getClass());
		deepCopy.phones         = CloneUtil.cloneRecords(deepCopy.phones       , this.getClass());
		deepCopy.userPersonData = CloneUtil.cloneRecord(deepCopy.userPersonData, this.getClass());
		deepCopy.peregData	    = CloneUtil.cloneRecord(deepCopy.peregData     , this.getClass());
		deepCopy.companyData    = CloneUtil.cloneRecord(deepCopy.companyData   , this.getClass());
		deepCopy.storacData     = CloneUtil.cloneRecord(deepCopy.storacData    , this.getClass());
		deepCopy.stefilonData   = CloneUtil.cloneRecord(deepCopy.stefilonData  , this.getClass());
		deepCopy.bankaccData    = CloneUtil.cloneRecord(deepCopy.bankaccData   , this.getClass());
		deepCopy.stowotmes      = CloneUtil.cloneRecords(deepCopy.stowotmes    , this.getClass());
		deepCopy.stuntmes       = CloneUtil.cloneRecords(deepCopy.stuntmes     , this.getClass());
		deepCopy.matores        = CloneUtil.cloneRecords(deepCopy.matores      , this.getClass());
		
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
		
		
		if (!(o instanceof StoreInfo))
			return false;
		
		
		StoreInfo obj = (StoreInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore);
	}
}
