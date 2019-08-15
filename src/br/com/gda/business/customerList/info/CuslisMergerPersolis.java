package br.com.gda.business.customerList.info;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CuslisMergerPersolis extends InfoMergerTemplate<CuslisInfo, PersolisInfo>{

	@Override protected InfoMergerVisitor<CuslisInfo, PersolisInfo> getVisitorHook() {
		return new CuslisVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
