package br.com.gda.business.materialEmployee.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoWritterFactory;

public final class MatEmpMerger extends InfoWritterFactory<MatEmpInfo> {
	public MatEmpInfo merge(MatInfo sourceOne, MatEmpInfo sourceTwo) {
		return new MatEmpMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	public MatEmpInfo merge(EmpInfo sourceOne, MatEmpInfo sourceTwo) {
		return new MatEmpMergerEmp().merge(sourceOne, sourceTwo);
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<MatEmpInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof EmpInfo &&
			sourceTwos.get(0) instanceof MatEmpInfo)
			return new MatEmpMergerEmp().merge((List<EmpInfo>) sourceOnes, (List<MatEmpInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatInfo &&
			sourceTwos.get(0) instanceof MatEmpInfo)
			return new MatEmpMergerMat().merge((List<MatInfo>) sourceOnes, (List<MatEmpInfo>) sourceTwos);
		
		
		return null;
	} 
}
