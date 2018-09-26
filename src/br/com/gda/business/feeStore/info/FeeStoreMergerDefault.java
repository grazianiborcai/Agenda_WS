package br.com.gda.business.feeStore.info;

import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.info.InfoMerger;

final class FeeStoreMergerDefault extends InfoMerger<FeeStoreInfo, FeeDefaultInfo, FeeStoreInfo> {
	public FeeStoreInfo merge(FeeDefaultInfo sourceOne, FeeStoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new FeeStoreVisitorDefault());
	}
	
	
	
	public List<FeeStoreInfo> merge(List<FeeDefaultInfo> sourceOnes, List<FeeStoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new FeeStoreVisitorDefault());
	}
}
