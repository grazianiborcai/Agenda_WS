package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoWritterFactory;

public final class EmpWTimeMerger extends InfoWritterFactory<EmpWTimeInfo> {
	public EmpWTimeInfo merge(EmposInfo sourceOne, StowotmInfo sourceTwo) {
		return new EmpWTimeMergerSWT().merge(sourceOne, sourceTwo);
	}
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpWTimeInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof EmposInfo 	&&
			sourceTwos.get(0) instanceof StowotmInfo		)
			return new EmpWTimeMergerSWT().merge((List<EmposInfo>) sourceOnes, (List<StowotmInfo>) sourceTwos);
		
		return null;
	} 
}
