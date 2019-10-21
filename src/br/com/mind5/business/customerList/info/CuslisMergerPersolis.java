package br.com.mind5.business.customerList.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class CuslisMergerPersolis extends InfoMergerTemplate<CuslisInfo, PersolisInfo>{

	@Override protected InfoMergerVisitor<CuslisInfo, PersolisInfo> getVisitorHook() {
		return new CuslisVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
