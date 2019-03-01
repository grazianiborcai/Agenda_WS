package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class OwnerMergerToDelete extends InfoMerger<OwnerInfo, OwnerInfo, OwnerInfo> {
	public OwnerInfo merge(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiMergeToDelete());
	}
	
	
	
	public List<OwnerInfo> merge(List<OwnerInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiMergeToDelete());
	}
}
