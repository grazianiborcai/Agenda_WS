package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger;

final class OwnerMergerAddress extends InfoMerger<OwnerInfo, AddressInfo, OwnerInfo> {
	public OwnerInfo merge(AddressInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisitorAddress());
	}
	
	
	
	public List<OwnerInfo> merge(List<AddressInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisitorAddress());
	}
}
