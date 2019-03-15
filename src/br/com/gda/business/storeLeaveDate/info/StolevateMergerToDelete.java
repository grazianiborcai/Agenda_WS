package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class StolevateMergerToDelete extends InfoMerger<StolevateInfo, StolevateInfo, StolevateInfo> {
	public StolevateInfo merge(StolevateInfo sourceOne, StolevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StolevateVisiMergeToDelete());
	}
	
	
	
	public List<StolevateInfo> merge(List<StolevateInfo> sourceOnes, List<StolevateInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StolevateVisiMergeToDelete());
	}
}
