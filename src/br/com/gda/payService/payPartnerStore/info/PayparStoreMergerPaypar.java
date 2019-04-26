package br.com.gda.payService.payPartnerStore.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMerger_;

final class PayparStoreMergerPaypar extends InfoMerger_<PayparStoreInfo, PayparInfo, PayparStoreInfo> {
	public PayparStoreInfo merge(PayparInfo sourceOne, PayparStoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayparStoreVisitorPaypar());
	}
	
	
	
	public List<PayparStoreInfo> merge(List<PayparInfo> sourceOnes, List<PayparStoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayparStoreVisitorPaypar());
	}
}
