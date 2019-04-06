package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class EmpMergerUsername extends InfoMerger<EmpInfo, UsernameInfo, EmpInfo> {
	public EmpInfo merge(UsernameInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpVisiMergeUsername());
	}
	
	
	
	public List<EmpInfo> merge(List<UsernameInfo> sourceOnes, List<EmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpVisiMergeUsername());
	}
}
