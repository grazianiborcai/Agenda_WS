package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;

final class OwnerMergerPhone extends InfoMerger<OwnerInfo, PhoneInfo, OwnerInfo> {
	public OwnerInfo merge(PhoneInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisitorPhone());
	}
	
	
	
	public List<OwnerInfo> merge(List<PhoneInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisitorPhone());
	}
}
