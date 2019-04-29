package br.com.gda.business.customer.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerPerson extends InfoMergerTemplate<CusInfo, PersonInfo>{

	@Override protected InfoMergerVisitorV2<CusInfo, PersonInfo> getVisitorHook() {
		return new CusVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
