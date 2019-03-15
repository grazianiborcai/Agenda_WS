package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class StolevateMergerUsername extends InfoMerger<StolevateInfo, UsernameInfo, StolevateInfo> {
	public StolevateInfo merge(UsernameInfo sourceOne, StolevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StolevateVisiMergeUsername());
	}
	
	
	
	public List<StolevateInfo> merge(List<UsernameInfo> sourceOnes, List<StolevateInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StolevateVisiMergeUsername());
	}
}
