package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmpwotmMerger extends InfoWritterFactory<EmpwotmInfo> {
	
	public EmpwotmMerger() {
		super(new EmpwotmUniquifier());
	}
	
	
	
	public EmpwotmInfo merge(EmposInfo sourceOne, StowotmInfo sourceTwo) {
		return new EmpwotmMergerStowotm().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmpwotmInfo merge(UsernameInfo sourceOne, EmpwotmInfo sourceTwo) {
		return new EmpwotmMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmpwotmInfo merge(EmpwotmInfo sourceOne, EmpwotmInfo sourceTwo) {
		return new EmpwotmMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpwotmInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof EmposInfo 		&&
			sourceTwos.get(0) instanceof StowotmInfo		)
			return new EmpwotmMergerStowotm().merge((List<EmposInfo>) sourceOnes, (List<StowotmInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof EmpwotmInfo		)
			return new EmpwotmMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<EmpwotmInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof EmpwotmInfo 	&&
			sourceTwos.get(0) instanceof EmpwotmInfo		)
			return new EmpwotmMergerToDelete().merge((List<EmpwotmInfo>) sourceOnes, (List<EmpwotmInfo>) sourceTwos);
		
		return null;
	} 
}
