package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class StoreMerger extends InfoWritterFactory_<StoreInfo> {	
	
	public StoreMerger() {
		super(new StoreUniquifier());
	}
	
	
	
	static public StoreInfo merge(AddressInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerAddress().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public StoreInfo merge(PhoneInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerPhone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public StoreInfo merge(PersonInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerPerson().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public StoreInfo merge(PersonUserInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerPersonUser().merge(sourceOne, sourceTwo);
	}		
	
	
	
	static public StoreInfo merge(CompInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerComp().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public StoreInfo merge(TimezoneInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerTimezone().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public StoreInfo merge(CurrencyInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerCurrency().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public StoreInfo merge(UserInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public StoreInfo merge(UsernameInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public StoreInfo merge(StoreInfo sourceOne, StoreInfo sourceTwo) {
		return new StoreMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<StoreInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof AddressInfo 		&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerAddress().merge((List<AddressInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 			&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 		&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof PersonUserInfo 	&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerPersonUser().merge((List<PersonUserInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof CompInfo 			&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerComp().merge((List<CompInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof TimezoneInfo 		&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerTimezone().merge((List<TimezoneInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof CurrencyInfo 		&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerCurrency().merge((List<CurrencyInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UserInfo 			&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerUser().merge((List<UserInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);			
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 		&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof StoreInfo 			&&
			sourceTwos.get(0) instanceof StoreInfo		)
			return new StoreMergerToDelete().merge((List<StoreInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);	
		
		return null;
	}
}
