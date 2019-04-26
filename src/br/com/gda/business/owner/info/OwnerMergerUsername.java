package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.username.info.UsernameInfo;

final class OwnerMergerUsername extends InfoMerger_<OwnerInfo, UsernameInfo, OwnerInfo> {
	public OwnerInfo merge(UsernameInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiMergeUsername());
	}
	
	
	
	public List<OwnerInfo> merge(List<UsernameInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiMergeUsername());
	}
}
