package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.info.InfoMerger_;

final class StoreMergerPersonUser extends InfoMerger_<StoreInfo, PersonUserInfo, StoreInfo> {
	public StoreInfo merge(PersonUserInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergePersonUser());
	}
	
	
	
	public List<StoreInfo> merge(List<PersonUserInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergePersonUser());
	}
}
