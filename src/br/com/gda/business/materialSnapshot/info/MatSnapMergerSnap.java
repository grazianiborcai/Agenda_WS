package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.InfoMerger_;

final class MatSnapMergerSnap extends InfoMerger_<MatSnapInfo, SnapInfo, MatSnapInfo> {
	public MatSnapInfo merge(SnapInfo sourceOne, MatSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatSnapVisitorSnap());
	}
	
	
	
	public List<MatSnapInfo> merge(List<SnapInfo> sourceOnes, List<MatSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatSnapVisitorSnap());
	}
}
