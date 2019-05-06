package br.com.gda.business.employeeWorkTimeConflict.info;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class EmpwocoMerger_ extends InfoWritterFactory_<EmpwocoInfo> {
	
	public EmpwocoMerger_() {
		super(new EmpwocoUniquifier());
	}
	
	
	
	public EmpwocoInfo merge(WeekdayInfo sourceOne, EmpwocoInfo sourceTwo) {
		return new EmpwocoMergerWeekday_().merge(sourceOne, sourceTwo);
	}	
	
	
	
	public EmpwocoInfo merge(TimezoneInfo sourceOne, EmpwocoInfo sourceTwo) {
		return new EmpwocoMergerTimezone_().merge(sourceOne, sourceTwo);
	}	
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpwocoInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof WeekdayInfo 	&&
			sourceTwos.get(0) instanceof EmpwocoInfo		)
			return new EmpwocoMergerWeekday_().merge((List<WeekdayInfo>) sourceOnes, (List<EmpwocoInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof TimezoneInfo 	&&
			sourceTwos.get(0) instanceof EmpwocoInfo		)
			return new EmpwocoMergerTimezone_().merge((List<TimezoneInfo>) sourceOnes, (List<EmpwocoInfo>) sourceTwos);
		
		return null;
	} 
}
