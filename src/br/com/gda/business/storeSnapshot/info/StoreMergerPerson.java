package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerPerson extends InfoMergerTemplate<StorapInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, PersonInfo> getVisitorHook() {
		return new StoreVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
