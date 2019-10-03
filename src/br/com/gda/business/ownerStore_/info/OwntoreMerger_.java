package br.com.gda.business.ownerStore_.info;

import java.util.List;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class OwntoreMerger_ extends InfoWritterFactory_<OwntoreInfo> {	
	
	public OwntoreMerger_() {
		super(new OwntoreUniquifier());
	}
	
	
	
	static public OwntoreInfo merge(OwntoreInfo sourceOne, OwntoreInfo sourceTwo) {
		return new OwntoreMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<OwntoreInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		
		if (sourceOnes.get(0) instanceof OwntoreInfo	&&
			sourceTwos.get(0) instanceof OwntoreInfo		)
			return new OwntoreMergerToDelete().merge((List<OwntoreInfo>) sourceOnes, (List<OwntoreInfo>) sourceTwos);	
		
		return null;
	}
}
