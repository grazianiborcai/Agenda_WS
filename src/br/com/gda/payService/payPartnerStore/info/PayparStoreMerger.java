package br.com.gda.payService.payPartnerStore.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoWritterFactory;

public final class PayparStoreMerger extends InfoWritterFactory<PayparStoreInfo> {	
	
	public PayparStoreMerger() {
		super(new PayparStoreUniquifier());
	}
	
	
	
	static public PayparStoreInfo merge(PayparInfo sourceOne, PayparStoreInfo sourceTwo) {
		return new PayparStoreMergerPaypar().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PayparStoreInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof PayparInfo 		&&
			sourceTwos.get(0) instanceof PayparStoreInfo		)
			return new PayparStoreMergerPaypar().merge((List<PayparInfo>) sourceOnes, (List<PayparStoreInfo>) sourceTwos);	
		
		return null;
	}
}
