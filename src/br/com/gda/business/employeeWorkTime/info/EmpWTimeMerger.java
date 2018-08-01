package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.RecordMergerFacTempl;

public final class EmpWTimeMerger extends RecordMergerFacTempl<EmpWTimeInfo> {
	public EmpWTimeInfo merge(StoreEmpInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return new EmpWTimeMergerSWT().merge(sourceOne, sourceTwo);
	}
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpWTimeInfo> mergeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof StoreEmpInfo 	&&
			sourceTwos.get(0) instanceof StoreWTimeInfo		)
			return new EmpWTimeMergerSWT().merge((List<StoreEmpInfo>) sourceOnes, (List<StoreWTimeInfo>) sourceTwos);
		
		return null;
	} 
}
