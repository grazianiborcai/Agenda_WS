package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;

final class PaycusMergerPayparOwner extends InfoMerger<PaycusInfo, PayparOwnerInfo, PaycusInfo> {
	public PaycusInfo merge(PayparOwnerInfo sourceOne, PaycusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PaycusVisiPayparOwner());
	}
	
	
	
	public List<PaycusInfo> merge(List<PayparOwnerInfo> sourceOnes, List<PaycusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PaycusVisiPayparOwner());
	}
}
