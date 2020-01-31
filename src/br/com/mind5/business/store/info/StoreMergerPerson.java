package br.com.mind5.business.store.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerPerson extends InfoMergerTemplate_<StoreInfo, PersonInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, PersonInfo> getVisitorHook() {
		return new StoreVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
