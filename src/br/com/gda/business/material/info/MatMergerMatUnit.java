package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.info.InfoMerger;

final class MatMergerMatUnit extends InfoMerger<MatInfo, MatUnitInfo, MatInfo> {
	public MatInfo merge(MatUnitInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisiMergeMatUnit());
	}
	
	
	
	public List<MatInfo> merge(List<MatUnitInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisiMergeMatUnit());
	}
}
