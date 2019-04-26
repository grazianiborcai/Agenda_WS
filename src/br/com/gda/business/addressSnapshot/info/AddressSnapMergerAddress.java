package br.com.gda.business.addressSnapshot.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger_;

final class AddressSnapMergerAddress extends InfoMerger_<AddressSnapInfo, AddressInfo, AddressSnapInfo> {
	public AddressSnapInfo merge(AddressInfo sourceOne, AddressSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new AddressSnapVisitorAddress());
	}
	
	
	
	public List<AddressSnapInfo> merge(List<AddressInfo> sourceOnes, List<AddressSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new AddressSnapVisitorAddress());
	}
}
