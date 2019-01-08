package br.com.gda.payService.payPartnerStore.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.info.InfoMerger;

final class PayPartnerStoreMergerPayPartner extends InfoMerger<PayPartnerStoreInfo, PayPartnerInfo, PayPartnerStoreInfo> {
	public PayPartnerStoreInfo merge(PayPartnerInfo sourceOne, PayPartnerStoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayPartnerStoreVisitorPayPartner());
	}
	
	
	
	public List<PayPartnerStoreInfo> merge(List<PayPartnerInfo> sourceOnes, List<PayPartnerStoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayPartnerStoreVisitorPayPartner());
	}
}
