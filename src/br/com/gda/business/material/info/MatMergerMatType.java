package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.info.InfoMerger_;

final class MatMergerMatType extends InfoMerger_<MatInfo, MatTypeInfo, MatInfo> {
	public MatInfo merge(MatTypeInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisiMergeMatType());
	}
	
	
	
	public List<MatInfo> merge(List<MatTypeInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisiMergeMatType());
	}
}
