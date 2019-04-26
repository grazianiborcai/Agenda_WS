package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger_;

final class OwnerMergerAddress extends InfoMerger_<OwnerInfo, AddressInfo, OwnerInfo> {
	public OwnerInfo merge(AddressInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiMergeAddress());
	}
	
	
	
	public List<OwnerInfo> merge(List<AddressInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiMergeAddress());
	}
}
