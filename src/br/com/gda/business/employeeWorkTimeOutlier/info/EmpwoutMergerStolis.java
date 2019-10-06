package br.com.gda.business.employeeWorkTimeOutlier.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmpwoutMergerStolis extends InfoMergerTemplate<EmpwoutInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<EmpwoutInfo, StolisInfo> getVisitorHook() {
		return new EmpwoutVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpwoutInfo> getUniquifierHook() {
		return new EmpwoutUniquifier();
	}
}
