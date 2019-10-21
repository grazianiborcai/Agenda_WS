package br.com.mind5.business.employeeWorkTimeOutlier.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwoutMergerStolis extends InfoMergerTemplate<EmpwoutInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<EmpwoutInfo, StolisInfo> getVisitorHook() {
		return new EmpwoutVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
