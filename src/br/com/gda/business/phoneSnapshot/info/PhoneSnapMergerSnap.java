package br.com.gda.business.phoneSnapshot.info;

import java.util.List;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.InfoMerger;

final class PhoneSnapMergerSnap extends InfoMerger<PhoneSnapInfo, SnapInfo, PhoneSnapInfo> {
	public PhoneSnapInfo merge(SnapInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PhoneSnapVisitorSnap());
	}
	
	
	
	public List<PhoneSnapInfo> merge(List<SnapInfo> sourceOnes, List<PhoneSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PhoneSnapVisitorSnap());
	}
}
