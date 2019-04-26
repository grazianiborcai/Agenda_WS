package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory_;

public final class StateMerger extends InfoWritterFactory_<StateInfo> {	
	
	public StateMerger() {
		super(new StateUniquifier());
	}
	
	
	
	static public StateInfo merge(CountryInfo sourceOne, StateInfo sourceTwo) {
		return new StateMergerCountry().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<StateInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {				
		if (sourceOnes.get(0) instanceof CountryInfo 	&&
			sourceTwos.get(0) instanceof StateInfo		)
			return new StateMergerCountry().merge((List<CountryInfo>) sourceOnes, (List<StateInfo>) sourceTwos);
		
		
		return null;
	}
}
