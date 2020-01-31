package br.com.mind5.business.owner.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerMergerPerson extends InfoMergerTemplate_<OwnerInfo, PersonInfo> {

	@Override protected InfoMergerVisitor_<OwnerInfo, PersonInfo> getVisitorHook() {
		return new OwnerVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
