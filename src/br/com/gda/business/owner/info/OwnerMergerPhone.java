package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger_;

final class OwnerMergerPhone extends InfoMerger_<OwnerInfo, PhoneInfo, OwnerInfo> {
	public OwnerInfo merge(PhoneInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiMergePhone());
	}
	
	
	
	public List<OwnerInfo> merge(List<PhoneInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiMergePhone());
	}
}
