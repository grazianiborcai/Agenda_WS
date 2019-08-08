package br.com.gda.business.store.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerPerson extends InfoMergerTemplate<StoreInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, PersonInfo> getVisitorHook() {
		return new StoreVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
