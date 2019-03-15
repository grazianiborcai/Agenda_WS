package br.com.gda.business.storeTime_.info;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoMerger;

final class StorimeMergerStowotm extends InfoMerger<StorimeInfo, StowotmInfo, StorimeInfo> {
	public StorimeInfo merge(StowotmInfo sourceOne, StorimeInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StorimeVisiMergeStowotm());
	}
	
	
	
	public List<StorimeInfo> merge(List<StowotmInfo> sourceOnes, List<StorimeInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StorimeVisiMergeStowotm());
	}
}
