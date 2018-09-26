package br.com.gda.business.materialEmployee.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;

final class MatEmpMergerMat extends InfoMerger<MatEmpInfo, MatInfo, MatEmpInfo> {
	public MatEmpInfo merge(MatInfo sourceOne, MatEmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatEmpVisitorMat());
	}
	
	
	
	public List<MatEmpInfo> merge(List<MatInfo> sourceOnes, List<MatEmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatEmpVisitorMat());
	}
}
