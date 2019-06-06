package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoKeeper_;

final class EmpKeeperEmp extends InfoKeeper_<EmpInfo, EmpInfo> {
	public EmpInfo keep(EmpInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpVisiKeepEmp());
	}
	
	
	
	public List<EmpInfo> keep(List<EmpInfo> sourceOnes, List<EmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpVisiKeepEmp());
	}
}
