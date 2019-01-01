package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;

final class PayCusMergerPhone extends InfoMerger<PayCusInfo, PhoneInfo, PayCusInfo> {
	public PayCusInfo merge(PhoneInfo sourceOne, PayCusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayCusVisitorPhone());
	}
	
	
	
	public List<PayCusInfo> merge(List<PhoneInfo> sourceOnes, List<PayCusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayCusVisitorPhone());
	}
}
