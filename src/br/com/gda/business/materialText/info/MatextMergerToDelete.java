package br.com.gda.business.materialText.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class MatextMergerToDelete extends InfoMerger_<MatextInfo, MatextInfo, MatextInfo> {
	public MatextInfo merge(MatextInfo sourceOne, MatextInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatextVisiMergeToDelete());
	}
	
	
	
	public List<MatextInfo> merge(List<MatextInfo> sourceOnes, List<MatextInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatextVisiMergeToDelete());
	}
}
