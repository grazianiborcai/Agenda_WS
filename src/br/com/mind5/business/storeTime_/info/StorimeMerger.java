package br.com.mind5.business.storeTime_.info;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.info.obsolete.InfoWritterFactory_;

public final class StorimeMerger extends InfoWritterFactory_<StorimeInfo> {	
	
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
