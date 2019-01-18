package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger;

final class PayCusMergerAddress extends InfoMerger<PayCusInfo, AddressInfo, PayCusInfo> {
	public PayCusInfo merge(AddressInfo sourceOne, PayCusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayCusVisiAddress());
	}
	
	
	
	public List<PayCusInfo> merge(List<AddressInfo> sourceOnes, List<PayCusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayCusVisiAddress());
	}
}
