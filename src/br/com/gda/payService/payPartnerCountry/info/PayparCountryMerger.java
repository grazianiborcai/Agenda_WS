package br.com.gda.payService.payPartnerCountry.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class PayparCountryMerger extends InfoWritterFactory_<PayparCountryInfo> {	
	
	public PayparCountryMerger() {
		super(new PayparCountryUniquifier());
	}
	
	
	
	static public PayparCountryInfo merge(PayparInfo sourceOne, PayparCountryInfo sourceTwo) {
		return new PayparCountryMergerPaypar().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PayparCountryInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof PayparInfo 		&&
			sourceTwos.get(0) instanceof PayparCountryInfo		)
			return new PayparCountryMergerPaypar().merge((List<PayparInfo>) sourceOnes, (List<PayparCountryInfo>) sourceTwos);	
		
		return null;
	}
}
