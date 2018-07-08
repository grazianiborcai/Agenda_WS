package br.com.gda.business.materialEmployee.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.RecordMerger;

final class MatEmpMergerMat extends RecordMerger<MatEmpInfo, MatInfo, MatEmpInfo> {
	public MatEmpInfo merge(MatInfo sourceOne, MatEmpInfo sourceTwo) {
		return super.merge(sourceOne, sourceTwo, new MatEmpVisitorMat());
	}
	
	
	
	public List<MatEmpInfo> merge(List<MatInfo> sourceOnes, List<MatEmpInfo> sourceTwos) {		
		return super.merge(sourceOnes, sourceTwos, new MatEmpVisitorMat());
	}
}
