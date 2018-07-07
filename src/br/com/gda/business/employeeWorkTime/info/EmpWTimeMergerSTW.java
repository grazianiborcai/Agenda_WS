package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.RecordMerger;

public final class EmpWTimeMergerSTW extends RecordMerger<EmpWTimeInfo, StoreEmpInfo, StoreWTimeInfo> {
	public EmpWTimeInfo merge(StoreEmpInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return super.merge(sourceOne, sourceTwo, new EmpWTimeVisitorSTW());
	}
	
	
	
	public List<EmpWTimeInfo> merge(List<StoreEmpInfo> sourceOnes, List<StoreWTimeInfo> sourceTwos) {
		return super.merge(sourceOnes, sourceTwos, new EmpWTimeVisitorSTW());
	}
}
