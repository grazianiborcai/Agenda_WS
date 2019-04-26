package br.com.gda.business.customer.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerPerson extends InfoMergerTemplate<CusInfo, PersonInfo>{

	@Override protected InfoMergerVisitor<CusInfo, PersonInfo, CusInfo> getVisitorHook() {
		return new CusVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
