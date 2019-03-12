package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoMerger;

final class EmpWTimeMergerSWT extends InfoMerger<EmpWTimeInfo, EmposInfo, StowotmInfo> {
	public EmpWTimeInfo merge(EmposInfo sourceOne, StowotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpWTimeVisitorSWT());
	}
	
	
	
	public List<EmpWTimeInfo> merge(List<EmposInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new EmpWTimeVisitorSWT());
	}
}
