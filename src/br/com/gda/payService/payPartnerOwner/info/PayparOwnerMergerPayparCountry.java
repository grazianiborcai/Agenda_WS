package br.com.gda.payService.payPartnerOwner.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;

final class PayparOwnerMergerPayparCountry extends InfoMerger<PayparOwnerInfo, PayparCountryInfo, PayparOwnerInfo> {
	public PayparOwnerInfo merge(PayparCountryInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayparOwnerVisiPayparCountry());
	}
	
	
	
	public List<PayparOwnerInfo> merge(List<PayparCountryInfo> sourceOnes, List<PayparOwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayparOwnerVisiPayparCountry());
	}
}
