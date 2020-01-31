package br.com.mind5.business.customerList.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class CuslisMergerPersolis extends InfoMergerTemplate_<CuslisInfo, PersolisInfo>{

	@Override protected InfoMergerVisitor_<CuslisInfo, PersolisInfo> getVisitorHook() {
		return new CuslisVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
