package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.info.InfoMerger_;

final class MatMergerMatext extends InfoMerger_<MatInfo, MatextInfo, MatInfo> {
	public MatInfo merge(MatextInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisiMergeMatext());
	}
	
	
	
	public List<MatInfo> merge(List<MatextInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisiMergeMatext());
	}
}
