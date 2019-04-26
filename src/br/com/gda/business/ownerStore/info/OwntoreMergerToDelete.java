package br.com.gda.business.ownerStore.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class OwntoreMergerToDelete extends InfoMerger_<OwntoreInfo, OwntoreInfo, OwntoreInfo> {
	public OwntoreInfo merge(OwntoreInfo sourceOne, OwntoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwntoreVisiMergeToDelete());
	}
	
	
	
	public List<OwntoreInfo> merge(List<OwntoreInfo> sourceOnes, List<OwntoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwntoreVisiMergeToDelete());
	}
}
