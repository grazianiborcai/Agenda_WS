package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.username.info.UsernameInfo;

final class EmpwotmMergerUsername extends InfoMerger_<EmpwotmInfo, UsernameInfo, EmpwotmInfo> {
	public EmpwotmInfo merge(UsernameInfo sourceOne, EmpwotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpwotmVisiMergeUsername());
	}
	
	
	
	public List<EmpwotmInfo> merge(List<UsernameInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpwotmVisiMergeUsername());
	}
}
