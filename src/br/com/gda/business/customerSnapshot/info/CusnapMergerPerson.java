package br.com.gda.business.customerSnapshot.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusnapMergerPerson extends InfoMergerTemplate<CusnapInfo, PersonInfo>{

	@Override protected InfoMergerVisitor<CusnapInfo, PersonInfo> getVisitorHook() {
		return new CusnapVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<CusnapInfo> getUniquifierHook() {
		return new CusnapUniquifier();
	}
}
