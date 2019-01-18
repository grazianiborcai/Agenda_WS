package br.com.gda.payService.payPartnerOwner.info;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoMerger;

final class PayparOwnerMergerOwner extends InfoMerger<PayparOwnerInfo, OwnerInfo, PayparOwnerInfo> {
	public PayparOwnerInfo merge(OwnerInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayparOwnerVisiOwner());
	}
	
	
	
	public List<PayparOwnerInfo> merge(List<OwnerInfo> sourceOnes, List<PayparOwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayparOwnerVisiOwner());
	}
}
