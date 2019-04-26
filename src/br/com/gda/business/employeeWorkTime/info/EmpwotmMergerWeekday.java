package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger_;

final class EmpwotmMergerWeekday extends InfoMerger_<EmpwotmInfo, WeekdayInfo, EmpwotmInfo> {
	public EmpwotmInfo merge(WeekdayInfo sourceOne, EmpwotmInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpwotmVisiMergeWeekday());
	}
	
	
	
	public List<EmpwotmInfo> merge(List<WeekdayInfo> sourceOnes, List<EmpwotmInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpwotmVisiMergeWeekday());
	}
}
