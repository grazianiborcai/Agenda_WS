package br.com.mind5.business.customerSnapshot.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CusnapMergerPerson extends InfoMergerTemplate<CusnapInfo, PersonInfo>{

	@Override protected InfoMergerVisitor<CusnapInfo, PersonInfo> getVisitorHook() {
		return new CusnapVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<CusnapInfo> getUniquifierHook() {
		return new CusnapUniquifier();
	}
}
