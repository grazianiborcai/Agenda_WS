package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.info.InfoMerger_;

final class OwnerMergerOwntore extends InfoMerger_<OwnerInfo, OwntoreInfo, OwnerInfo> {
	public OwnerInfo merge(OwntoreInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiMergeOwntore());
	}
	
	
	
	public List<OwnerInfo> merge(List<OwntoreInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiMergeOwntore());
	}
}
