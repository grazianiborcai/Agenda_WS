package br.com.mind5.business.storeTime_.info;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

final class StorimeMergerStowotm extends InfoMerger_<StorimeInfo, StowotmInfo, StorimeInfo> {
	public StorimeInfo merge(StowotmInfo sourceOne, StorimeInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StorimeVisiMergeStowotm());
	}
	
	
	
	public List<StorimeInfo> merge(List<StowotmInfo> sourceOnes, List<StorimeInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StorimeVisiMergeStowotm());
	}
}
