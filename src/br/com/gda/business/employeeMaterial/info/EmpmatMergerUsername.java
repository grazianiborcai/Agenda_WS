package br.com.gda.business.employeeMaterial.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class EmpmatMergerUsername extends InfoMerger<EmpmatInfo, UsernameInfo, EmpmatInfo> {
	public EmpmatInfo merge(UsernameInfo sourceOne, EmpmatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpmatVisiMergeUsername());
	}
	
	
	
	public List<EmpmatInfo> merge(List<UsernameInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpmatVisiMergeUsername());
	}
}
