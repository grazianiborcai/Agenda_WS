package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;

final class PaycusMergerPhone extends InfoMerger<PaycusInfo, PhoneInfo, PaycusInfo> {
	public PaycusInfo merge(PhoneInfo sourceOne, PaycusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PaycusVisiPhone());
	}
	
	
	
	public List<PaycusInfo> merge(List<PhoneInfo> sourceOnes, List<PaycusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PaycusVisiPhone());
	}
}
