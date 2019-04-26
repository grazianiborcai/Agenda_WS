package br.com.gda.business.materialStore.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.username.info.UsernameInfo;

final class MatoreMergerUsername extends InfoMerger_<MatoreInfo, UsernameInfo, MatoreInfo> {
	public MatoreInfo merge(UsernameInfo sourceOne, MatoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatoreVisiMergeUsername());
	}
	
	
	
	public List<MatoreInfo> merge(List<UsernameInfo> sourceOnes, List<MatoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatoreVisiMergeUsername());
	}
}
