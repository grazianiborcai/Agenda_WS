package br.com.gda.payService.payPartnerCountry.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.info.InfoWritterFactory;

public final class PayPartnerCountryMerger extends InfoWritterFactory<PayPartnerCountryInfo> {	
	
	public PayPartnerCountryMerger() {
		super(new PayPartnerCountryUniquifier());
	}
	
	
	
	static public PayPartnerCountryInfo merge(PayPartnerInfo sourceOne, PayPartnerCountryInfo sourceTwo) {
		return new PayPartnerCountryMergerPayPartner().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PayPartnerCountryInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof PayPartnerInfo 		&&
			sourceTwos.get(0) instanceof PayPartnerCountryInfo		)
			return new PayPartnerCountryMergerPayPartner().merge((List<PayPartnerInfo>) sourceOnes, (List<PayPartnerCountryInfo>) sourceTwos);	
		
		return null;
	}
}
