package br.com.gda.business.employeeWorkTimeConflict.info;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger_;

final class EmpwocoMergerWeekday_ extends InfoMerger_<EmpwocoInfo, WeekdayInfo, EmpwocoInfo> {
	public EmpwocoInfo merge(WeekdayInfo sourceOne, EmpwocoInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpwocoVisiMergeWeekday_());
	}
	
	
	
	public List<EmpwocoInfo> merge(List<WeekdayInfo> sourceOnes, List<EmpwocoInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpwocoVisiMergeWeekday_());
	}
}
