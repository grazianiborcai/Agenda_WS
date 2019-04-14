package br.com.gda.business.employeeWorkTimeConflict.info;

import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoMerger;

final class EmpwocoMergerWeekday extends InfoMerger<EmpwocoInfo, WeekdayInfo, EmpwocoInfo> {
	public EmpwocoInfo merge(WeekdayInfo sourceOne, EmpwocoInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpwocoVisiMergeWeekday());
	}
	
	
	
	public List<EmpwocoInfo> merge(List<WeekdayInfo> sourceOnes, List<EmpwocoInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpwocoVisiMergeWeekday());
	}
}
