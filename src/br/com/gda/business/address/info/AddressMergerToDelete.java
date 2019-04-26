package br.com.gda.business.address.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class AddressMergerToDelete extends InfoMerger_<AddressInfo, AddressInfo, AddressInfo> {
	public AddressInfo merge(AddressInfo sourceOne, AddressInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new AddressVisiMergeToDelete());
	}
	
	
	
	public List<AddressInfo> merge(List<AddressInfo> sourceOnes, List<AddressInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new AddressVisiMergeToDelete());
	}
}
