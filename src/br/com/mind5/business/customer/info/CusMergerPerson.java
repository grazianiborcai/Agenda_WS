package br.com.mind5.business.customer.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CusMergerPerson extends InfoMergerTemplate<CusInfo, PersonInfo>{

	@Override protected InfoMergerVisitor<CusInfo, PersonInfo> getVisitorHook() {
		return new CusVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
