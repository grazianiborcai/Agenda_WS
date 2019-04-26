package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoMerger_;

final class StoreMergerComp extends InfoMerger_<StoreInfo, CompInfo, StoreInfo> {
	public StoreInfo merge(CompInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergeComp());
	}
	
	
	
	public List<StoreInfo> merge(List<CompInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergeComp());
	}
}
