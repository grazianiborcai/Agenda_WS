package br.com.gda.business.employeeWorkTime.info;

import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmpwotmMerger extends InfoWritterFactory_<EmpwotmInfo> {
	
	public EmpwotmMerger() {
		super(new EmpwotmUniquifier());
	}
	
	
	
	public EmpwotmInfo merge(EmposInfo sourceOne, StowotmInfo sourceTwo) {
		return new EmpwotmMergerStowotm().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmpwotmInfo merge(UsernameInfo sourceOne, EmpwotmInfo sourceTwo) {
		return new EmpwotmMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmpwotmInfo merge(EmpwotmInfo sourceOne, EmpwotmInfo sourceTwo) {
		return new EmpwotmMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmpwotmInfo merge(WeekdayInfo sourceOne, EmpwotmInfo sourceTwo) {
		return new EmpwotmMergerWeekday().merge(sourceOne, sourceTwo);
	}	
	
	
	
	public EmpwotmInfo merge(TimezoneInfo sourceOne, EmpwotmInfo sourceTwo) {
		return new EmpwotmMergerTimezone().merge(sourceOne, sourceTwo);
	}	
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmpwotmInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof EmposInfo 		&&
			sourceTwos.get(0) instanceof StowotmInfo		)
			return new EmpwotmMergerStowotm().merge((List<EmposInfo>) sourceOnes, (List<StowotmInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof EmpwotmInfo		)
			return new EmpwotmMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<EmpwotmInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof EmpwotmInfo 	&&
			sourceTwos.get(0) instanceof EmpwotmInfo		)
			return new EmpwotmMergerToDelete().merge((List<EmpwotmInfo>) sourceOnes, (List<EmpwotmInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof WeekdayInfo 	&&
			sourceTwos.get(0) instanceof EmpwotmInfo		)
			return new EmpwotmMergerWeekday().merge((List<WeekdayInfo>) sourceOnes, (List<EmpwotmInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof TimezoneInfo 	&&
			sourceTwos.get(0) instanceof EmpwotmInfo		)
			return new EmpwotmMergerTimezone().merge((List<TimezoneInfo>) sourceOnes, (List<EmpwotmInfo>) sourceTwos);
		
		return null;
	} 
}
