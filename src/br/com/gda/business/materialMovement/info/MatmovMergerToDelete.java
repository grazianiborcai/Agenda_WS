package br.com.gda.business.materialMovement.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class MatmovMergerToDelete extends InfoMerger_<MatmovInfo, MatmovInfo, MatmovInfo> {
	public MatmovInfo merge(MatmovInfo sourceOne, MatmovInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatmovVisiMergeToDelete());
	}
	
	
	
	public List<MatmovInfo> merge(List<MatmovInfo> sourceOnes, List<MatmovInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatmovVisiMergeToDelete());
	}
}
