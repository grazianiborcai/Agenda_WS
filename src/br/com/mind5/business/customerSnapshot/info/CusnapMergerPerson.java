package br.com.mind5.business.customerSnapshot.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CusnapMergerPerson extends InfoMergerTemplate_<CusnapInfo, PersonInfo>{

	@Override protected InfoMergerVisitor_<CusnapInfo, PersonInfo> getVisitorHook() {
		return new CusnapVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<CusnapInfo> getUniquifierHook() {
		return new CusnapUniquifier();
	}
}
