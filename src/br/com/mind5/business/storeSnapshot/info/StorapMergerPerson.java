package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerPerson extends InfoMergerTemplate<StorapInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<StorapInfo, PersonInfo> getVisitorHook() {
		return new StorapVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
