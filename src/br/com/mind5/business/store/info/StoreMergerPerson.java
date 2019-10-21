package br.com.mind5.business.store.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerPerson extends InfoMergerTemplate<StoreInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, PersonInfo> getVisitorHook() {
		return new StoreVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
