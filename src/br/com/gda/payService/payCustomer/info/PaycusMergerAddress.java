package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger;

final class PaycusMergerAddress extends InfoMerger<PaycusInfo, AddressInfo, PaycusInfo> {
	public PaycusInfo merge(AddressInfo sourceOne, PaycusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PaycusVisiAddress());
	}
	
	
	
	public List<PaycusInfo> merge(List<AddressInfo> sourceOnes, List<PaycusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PaycusVisiAddress());
	}
}
