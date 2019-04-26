package br.com.gda.business.customerSearch.info;

import java.util.List;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class CusarchMerger extends InfoWritterFactory_<CusarchInfo> {	
	
	public CusarchMerger() {
		super(new CusarchUniquifier());
	}
	
	
	
	static public CusarchInfo merge(LanguInfo sourceOne, CusarchInfo sourceTwo) {
		return new CusarchMergerLangu().merge(sourceOne, sourceTwo);
	}	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CusarchInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {			
		if (sourceOnes.get(0) instanceof LanguInfo 		&&
			sourceTwos.get(0) instanceof CusarchInfo		)
			return new CusarchMergerLangu().merge((List<LanguInfo>) sourceOnes, (List<CusarchInfo>) sourceTwos);
		
		return null;
	}
}
