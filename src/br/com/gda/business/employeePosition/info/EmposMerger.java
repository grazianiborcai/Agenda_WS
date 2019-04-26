package br.com.gda.business.employeePosition.info;

import java.util.List;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmposMerger extends InfoWritterFactory_<EmposInfo> {	
	
	public EmposMerger() {
		super(new EmposUniquifier());
	}
	
	
	
	static public EmposInfo merge(PositionInfo sourceOne, EmposInfo sourceTwo) {
		return new EmposMergerPosition().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public EmposInfo merge(UsernameInfo sourceOne, EmposInfo sourceTwo) {
		return new EmposMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public EmposInfo merge(EmposInfo sourceOne, EmposInfo sourceTwo) {
		return new EmposMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmposInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof PositionInfo 	&&
			sourceTwos.get(0) instanceof EmposInfo			)
			return new EmposMergerPosition().merge((List<PositionInfo>) sourceOnes, (List<EmposInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof EmposInfo			)
			return new EmposMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<EmposInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof EmposInfo 		&&
			sourceTwos.get(0) instanceof EmposInfo			)
			return new EmposMergerToDelete().merge((List<EmposInfo>) sourceOnes, (List<EmposInfo>) sourceTwos);	
		
		return null;
	}
}
