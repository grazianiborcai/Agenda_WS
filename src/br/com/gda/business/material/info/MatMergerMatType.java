package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.info.InfoMerger;

final class MatMergerMatType extends InfoMerger<MatInfo, MatTypeInfo, MatInfo> {
	public MatInfo merge(MatTypeInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisitorMatType());
	}
	
	
	
	public List<MatInfo> merge(List<MatTypeInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisitorMatType());
	}
}
