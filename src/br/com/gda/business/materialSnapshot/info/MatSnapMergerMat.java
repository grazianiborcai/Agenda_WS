package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;

final class MatSnapMergerMat extends InfoMerger<MatSnapInfo, MatInfo, MatSnapInfo> {
	public MatSnapInfo merge(MatInfo sourceOne, MatSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatSnapVisitorMat());
	}
	
	
	
	public List<MatSnapInfo> merge(List<MatInfo> sourceOnes, List<MatSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatSnapVisitorMat());
	}
}
