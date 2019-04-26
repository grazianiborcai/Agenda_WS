package br.com.gda.business.storeWorkTime.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class StowotmMergerToDelete extends InfoMerger_<StowotmInfo, StowotmInfo, StowotmInfo> {
	public StowotmInfo merge(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StowotmVisiMergeToDelete());
	}
	
	
	
	public List<StowotmInfo> merge(List<StowotmInfo> sourceOnes, List<StowotmInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StowotmVisiMergeToDelete());
	}
}
