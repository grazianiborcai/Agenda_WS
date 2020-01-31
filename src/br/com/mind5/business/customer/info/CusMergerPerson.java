package br.com.mind5.business.customer.info;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CusMergerPerson extends InfoMergerTemplate_<CusInfo, PersonInfo>{

	@Override protected InfoMergerVisitor_<CusInfo, PersonInfo> getVisitorHook() {
		return new CusVisiMergePerson();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
