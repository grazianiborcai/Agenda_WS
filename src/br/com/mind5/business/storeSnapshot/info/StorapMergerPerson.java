package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapMergerPerson extends InfoMergerTemplate_<StorapInfo, PersonInfo> {

	@Override protected InfoMergerVisitor_<StorapInfo, PersonInfo> getVisitorHook() {
		return new StorapVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<StorapInfo> getUniquifierHook() {
		return new StorapUniquifier();
	}
}
