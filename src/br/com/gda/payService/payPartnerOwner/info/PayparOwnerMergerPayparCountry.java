package br.com.gda.payService.payPartnerOwner.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoMerger_;
import br.com.gda.payment.countryPartner.info.CounparInfo;

final class PayparOwnerMergerPayparCountry extends InfoMerger_<PayparOwnerInfo, CounparInfo, PayparOwnerInfo> {
	public PayparOwnerInfo merge(CounparInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayparOwnerVisiPayparCountry());
	}
	
	
	
	public List<PayparOwnerInfo> merge(List<CounparInfo> sourceOnes, List<PayparOwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayparOwnerVisiPayparCountry());
	}
}
