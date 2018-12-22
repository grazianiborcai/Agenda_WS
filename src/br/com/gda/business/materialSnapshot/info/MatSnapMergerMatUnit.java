package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.info.InfoMerger;

final class MatSnapMergerMatUnit extends InfoMerger<MatSnapInfo, MatUnitInfo, MatSnapInfo> {
	public MatSnapInfo merge(MatUnitInfo sourceOne, MatSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatSnapVisitorMatUnit());
	}
	
	
	
	public List<MatSnapInfo> merge(List<MatUnitInfo> sourceOnes, List<MatSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatSnapVisitorMatUnit());
	}
}
