package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.info.InfoMerger;

final class MatMergerMatCateg extends InfoMerger<MatInfo, MatCategInfo, MatInfo> {
	public MatInfo merge(MatCategInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisitorMatCateg());
	}
	
	
	
	public List<MatInfo> merge(List<MatCategInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisitorMatCateg());
	}
}
