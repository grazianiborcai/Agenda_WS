package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMerger_;

final class EmpwotmMergerTimezone extends InfoMerger_<EmpwotmInfo, TimezoneInfo, EmpwotmInfo> {
	public EmpwotmInfo merge(TimezoneInfo sourceOne, EmpwotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpwotmVisiMergeTimezone());
	}
	
	
	
	public List<EmpwotmInfo> merge(List<TimezoneInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpwotmVisiMergeTimezone());
	}
}
