package br.com.gda.business.storeWorkTime.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class StowotmMergerUsername extends InfoMerger<StowotmInfo, UsernameInfo, StowotmInfo> {
	public StowotmInfo merge(UsernameInfo sourceOne, StowotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StowotmVisiMergeUsername());
	}
	
	
	
	public List<StowotmInfo> merge(List<UsernameInfo> sourceOnes, List<StowotmInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StowotmVisiMergeUsername());
	}
}
