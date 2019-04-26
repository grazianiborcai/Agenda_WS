package br.com.gda.business.materialStore.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger_;

final class MatoreMergerMat extends InfoMerger_<MatoreInfo, MatInfo, MatoreInfo> {
	public MatoreInfo merge(MatInfo sourceOne, MatoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatoreVisitorMat());
	}
	
	
	
	public List<MatoreInfo> merge(List<MatInfo> sourceOnes, List<MatoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatoreVisitorMat());
	}
}
