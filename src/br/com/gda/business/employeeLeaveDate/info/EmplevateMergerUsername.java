package br.com.gda.business.employeeLeaveDate.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.username.info.UsernameInfo;

final class EmplevateMergerUsername extends InfoMerger_<EmplevateInfo, UsernameInfo, EmplevateInfo> {
	public EmplevateInfo merge(UsernameInfo sourceOne, EmplevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmplevateVisiMergeUsername());
	}
	
	
	
	public List<EmplevateInfo> merge(List<UsernameInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmplevateVisiMergeUsername());
	}
}
