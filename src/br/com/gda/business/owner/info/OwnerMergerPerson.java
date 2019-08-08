package br.com.gda.business.owner.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerPerson extends InfoMergerTemplate<OwnerInfo, PersonInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, PersonInfo> getVisitorHook() {
		return new OwnerVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
