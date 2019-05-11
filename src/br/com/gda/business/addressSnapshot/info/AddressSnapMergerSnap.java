package br.com.gda.business.addressSnapshot.info;

import java.util.List;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class AddressSnapMergerSnap extends InfoMerger_<AddressSnapInfo, SnapInfo, AddressSnapInfo> {
	public AddressSnapInfo merge(SnapInfo sourceOne, AddressSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new AddressSnapVisitorSnap());
	}
	
	
	
	public List<AddressSnapInfo> merge(List<SnapInfo> sourceOnes, List<AddressSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new AddressSnapVisitorSnap());
	}
}
