package br.com.gda.business.employeeMaterial.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmpmatMerger extends InfoWritterFactory<EmpmatInfo> {
	
	public EmpmatMerger() {
		super(new EmpmatUniquifier());
	}
	
	
	
	public EmpmatInfo merge(MatInfo sourceOne, EmpmatInfo sourceTwo) {
		return new EmpmatMergerMat().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmpmatInfo merge(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
		return new EmpmatMergerEmp().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmpmatInfo merge(UsernameInfo sourceOne, EmpmatInfo sourceTwo) {
		return new EmpmatMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmpmatInfo merge(EmpmatInfo sourceOne, EmpmatInfo sourceTwo) {
		return new EmpmatMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpmatInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof EmpInfo 		&&
			sourceTwos.get(0) instanceof EmpmatInfo			)
			return new EmpmatMergerEmp().merge((List<EmpInfo>) sourceOnes, (List<EmpmatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof MatInfo 		&&
			sourceTwos.get(0) instanceof EmpmatInfo			)
			return new EmpmatMergerMat().merge((List<MatInfo>) sourceOnes, (List<EmpmatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof EmpmatInfo			)
			return new EmpmatMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<EmpmatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof EmpmatInfo 	&&
			sourceTwos.get(0) instanceof EmpmatInfo			)
			return new EmpmatMergerToDelete().merge((List<EmpmatInfo>) sourceOnes, (List<EmpmatInfo>) sourceTwos);
		
		
		return null;
	} 
}
