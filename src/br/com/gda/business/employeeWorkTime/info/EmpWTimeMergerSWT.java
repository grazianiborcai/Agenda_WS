package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.InfoMerger;

final class EmpWTimeMergerSWT extends InfoMerger<EmpWTimeInfo, EmposInfo, StoreWTimeInfo> {
	public EmpWTimeInfo merge(EmposInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpWTimeVisitorSWT());
	}
	
	
	
	public List<EmpWTimeInfo> merge(List<EmposInfo> sourceOnes, List<StoreWTimeInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new EmpWTimeVisitorSWT());
	}
}
