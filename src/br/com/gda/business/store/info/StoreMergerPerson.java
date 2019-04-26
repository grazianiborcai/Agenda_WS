package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger_;

final class StoreMergerPerson extends InfoMerger_<StoreInfo, PersonInfo, StoreInfo> {
	public StoreInfo merge(PersonInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergePerson());
	}
	
	
	
	public List<StoreInfo> merge(List<PersonInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergePerson());
	}
}
