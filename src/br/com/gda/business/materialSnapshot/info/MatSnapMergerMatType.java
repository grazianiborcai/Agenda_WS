package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class MatSnapMergerMatType extends InfoMerger_<MatSnapInfo, MatTypeInfo, MatSnapInfo> {
	public MatSnapInfo merge(MatTypeInfo sourceOne, MatSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatSnapVisitorMatType());
	}
	
	
	
	public List<MatSnapInfo> merge(List<MatTypeInfo> sourceOnes, List<MatSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatSnapVisitorMatType());
	}
}
