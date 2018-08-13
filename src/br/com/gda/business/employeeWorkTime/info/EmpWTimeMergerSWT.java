package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.InfoWriter;

final class EmpWTimeMergerSWT extends InfoWriter<EmpWTimeInfo, StoreEmpInfo, StoreWTimeInfo> {
	public EmpWTimeInfo merge(StoreEmpInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpWTimeVisitorSWT());
	}
	
	
	
	public List<EmpWTimeInfo> merge(List<StoreEmpInfo> sourceOnes, List<StoreWTimeInfo> sourceTwos) {
		return super.write(sourceOnes, sourceTwos, new EmpWTimeVisitorSWT());
	}
}
