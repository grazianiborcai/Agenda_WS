package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.InfoWritterFactory;

public final class EmpWTimeMerger extends InfoWritterFactory<EmpWTimeInfo> {
	public EmpWTimeInfo merge(EmposInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return new EmpWTimeMergerSWT().merge(sourceOne, sourceTwo);
	}
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpWTimeInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof EmposInfo 	&&
			sourceTwos.get(0) instanceof StoreWTimeInfo		)
			return new EmpWTimeMergerSWT().merge((List<EmposInfo>) sourceOnes, (List<StoreWTimeInfo>) sourceTwos);
		
		return null;
	} 
}
