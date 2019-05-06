package br.com.gda.business.employeeWorkTimeConflict.info;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMerger_;

final class EmpwocoMergerTimezone_ extends InfoMerger_<EmpwocoInfo, TimezoneInfo, EmpwocoInfo> {
	public EmpwocoInfo merge(TimezoneInfo sourceOne, EmpwocoInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpwocoVisiMergeTimezone_());
	}
	
	
	
	public List<EmpwocoInfo> merge(List<TimezoneInfo> sourceOnes, List<EmpwocoInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpwocoVisiMergeTimezone_());
	}
}
