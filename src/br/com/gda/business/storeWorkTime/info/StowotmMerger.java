package br.com.gda.business.storeWorkTime.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class StowotmMerger extends InfoWritterFactory_<StowotmInfo> {	
	
	public StowotmMerger() {
		super(new StowotmUniquifier());
	}
	
	
	
	static public StowotmInfo merge(UsernameInfo sourceOne, StowotmInfo sourceTwo) {
		return new StowotmMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public StowotmInfo merge(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		return new StowotmMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<StowotmInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof StowotmInfo		)
			return new StowotmMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<StowotmInfo>) sourceTwos);	
		
		
		if (sourceOnes.get(0) instanceof StowotmInfo 	&&
			sourceTwos.get(0) instanceof StowotmInfo		)
			return new StowotmMergerToDelete().merge((List<StowotmInfo>) sourceOnes, (List<StowotmInfo>) sourceTwos);	
		
		return null;
	}
}
