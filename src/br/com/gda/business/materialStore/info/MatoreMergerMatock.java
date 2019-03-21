package br.com.gda.business.materialStore.info;

import java.util.List;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.info.InfoMerger;

final class MatoreMergerMatock extends InfoMerger<MatoreInfo, MatockInfo, MatoreInfo> {
	public MatoreInfo merge(MatockInfo sourceOne, MatoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatoreVisiMergeMatock());
	}
	
	
	
	public List<MatoreInfo> merge(List<MatockInfo> sourceOnes, List<MatoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatoreVisiMergeMatock());
	}
}
