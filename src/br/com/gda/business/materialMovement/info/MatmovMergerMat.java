package br.com.gda.business.materialMovement.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;

final class MatmovMergerMat extends InfoMerger<MatmovInfo, MatInfo, MatmovInfo> {
	public MatmovInfo merge(MatInfo sourceOne, MatmovInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatmovVisiMergeMat());
	}
	
	
	
	public List<MatmovInfo> merge(List<MatInfo> sourceOnes, List<MatmovInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatmovVisiMergeMat());
	}
}
