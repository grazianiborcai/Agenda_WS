package br.com.mind5.business.owner.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OwnerMergerPerson extends InfoMergerTemplate<OwnerInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, PersonInfo> getVisitorHook() {
		return new OwnerVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
