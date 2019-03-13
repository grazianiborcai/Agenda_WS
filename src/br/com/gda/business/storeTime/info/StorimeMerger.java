package br.com.gda.business.storeTime.info;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoWritterFactory;

public final class StorimeMerger extends InfoWritterFactory<StorimeInfo> {	
	
	public StorimeMerger() {
		super(new StorimeUniquifier());
	}
	
	
	
	static public StorimeInfo merge(StowotmInfo sourceOne, StorimeInfo sourceTwo) {
		return new StorimeMergerStowotm().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<StorimeInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof StowotmInfo 	&&
			sourceTwos.get(0) instanceof StorimeInfo		)
			return new StorimeMergerStowotm().merge((List<StowotmInfo>) sourceOnes, (List<StorimeInfo>) sourceTwos);	
		
		return null;
	}
}
