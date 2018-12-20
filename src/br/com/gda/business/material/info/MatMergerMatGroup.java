package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.info.InfoMerger;

final class MatMergerMatGroup extends InfoMerger<MatInfo, MatGroupInfo, MatInfo> {
	public MatInfo merge(MatGroupInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisitorMatGroup());
	}
	
	
	
	public List<MatInfo> merge(List<MatGroupInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisitorMatGroup());
	}
}
