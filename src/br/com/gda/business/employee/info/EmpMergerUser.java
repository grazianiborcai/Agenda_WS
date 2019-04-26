package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger_;

final class EmpMergerUser extends InfoMerger_<EmpInfo, UserInfo, EmpInfo> {
	public EmpInfo merge(UserInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpVisiMergeUser());
	}
	
	
	
	public List<EmpInfo> merge(List<UserInfo> sourceOnes, List<EmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpVisiMergeUser());
	}
}
