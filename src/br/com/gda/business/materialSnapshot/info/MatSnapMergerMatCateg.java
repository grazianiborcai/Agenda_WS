package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.info.InfoMerger_;

final class MatSnapMergerMatCateg extends InfoMerger_<MatSnapInfo, MatCategInfo, MatSnapInfo> {
	public MatSnapInfo merge(MatCategInfo sourceOne, MatSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatSnapVisitorMatCateg());
	}
	
	
	
	public List<MatSnapInfo> merge(List<MatCategInfo> sourceOnes, List<MatSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatSnapVisitorMatCateg());
	}
}
