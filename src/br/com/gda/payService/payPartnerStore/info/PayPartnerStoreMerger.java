package br.com.gda.payService.payPartnerStore.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.info.InfoWritterFactory;

public final class PayPartnerStoreMerger extends InfoWritterFactory<PayPartnerStoreInfo> {	
	
	public PayPartnerStoreMerger() {
		super(new PayPartnerStoreUniquifier());
	}
	
	
	
	static public PayPartnerStoreInfo merge(PayPartnerInfo sourceOne, PayPartnerStoreInfo sourceTwo) {
		return new PayPartnerStoreMergerPayPartner().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PayPartnerStoreInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof PayPartnerInfo 		&&
			sourceTwos.get(0) instanceof PayPartnerStoreInfo		)
			return new PayPartnerStoreMergerPayPartner().merge((List<PayPartnerInfo>) sourceOnes, (List<PayPartnerStoreInfo>) sourceTwos);	
		
		return null;
	}
}
