package br.com.gda.business.employeeLeaveDate.info;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMerger_;

final class EmplevateMergerTimezone extends InfoMerger_<EmplevateInfo, TimezoneInfo, EmplevateInfo> {
	public EmplevateInfo merge(TimezoneInfo sourceOne, EmplevateInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmplevateVisiMergeTimezone());
	}
	
	
	
	public List<EmplevateInfo> merge(List<TimezoneInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmplevateVisiMergeTimezone());
	}
}
