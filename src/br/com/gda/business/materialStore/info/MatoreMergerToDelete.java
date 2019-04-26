package br.com.gda.business.materialStore.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class MatoreMergerToDelete extends InfoMerger_<MatoreInfo, MatoreInfo, MatoreInfo> {
	public MatoreInfo merge(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatoreVisiMergeToDelete());
	}
	
	
	
	public List<MatoreInfo> merge(List<MatoreInfo> sourceOnes, List<MatoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatoreVisiMergeToDelete());
	}
}
