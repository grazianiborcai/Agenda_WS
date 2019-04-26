package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class MatMergerToDelete extends InfoMerger_<MatInfo, MatInfo, MatInfo> {
	public MatInfo merge(MatInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisiMergeToDelete());
	}
	
	
	
	public List<MatInfo> merge(List<MatInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisiMergeToDelete());
	}
}
