package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoMerger_;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;

final class PaycusMergerPayparOwner extends InfoMerger_<PaycusInfo, OwnparInfo, PaycusInfo> {
	public PaycusInfo merge(OwnparInfo sourceOne, PaycusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PaycusVisiPayparOwner());
	}
	
	
	
	public List<PaycusInfo> merge(List<OwnparInfo> sourceOnes, List<PaycusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PaycusVisiPayparOwner());
	}
}
