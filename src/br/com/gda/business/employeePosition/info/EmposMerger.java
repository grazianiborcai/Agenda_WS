package br.com.gda.business.employeePosition.info;

import java.util.List;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.info.InfoWritterFactory;

public final class EmposMerger extends InfoWritterFactory<EmposInfo> {	
	
	public EmposMerger() {
		super(new EmposUniquifier());
	}
	
	
	
	static public EmposInfo merge(PositionInfo sourceOne, EmposInfo sourceTwo) {
		return new EmposMergerPosition().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmposInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof PositionInfo 	&&
			sourceTwos.get(0) instanceof EmposInfo		)
			return new EmposMergerPosition().merge((List<PositionInfo>) sourceOnes, (List<EmposInfo>) sourceTwos);	
		
		return null;
	}
}
