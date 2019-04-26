package br.com.gda.business.employeeLeaveDate.info;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmplevateMerger extends InfoWritterFactory_<EmplevateInfo> {
	
	public EmplevateMerger() {
		super(new EmplevateUniquifier());
	}
	
	
	
	public EmplevateInfo merge(UsernameInfo sourceOne, EmplevateInfo sourceTwo) {
		return new EmplevateMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmplevateInfo merge(EmplevateInfo sourceOne, EmplevateInfo sourceTwo) {
		return new EmplevateMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	public EmplevateInfo merge(TimezoneInfo sourceOne, EmplevateInfo sourceTwo) {
		return new EmplevateMergerTimezone().merge(sourceOne, sourceTwo);
	}	
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<EmplevateInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof EmplevateInfo		)
			return new EmplevateMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<EmplevateInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof EmplevateInfo 	&&
			sourceTwos.get(0) instanceof EmplevateInfo		)
			return new EmplevateMergerToDelete().merge((List<EmplevateInfo>) sourceOnes, (List<EmplevateInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof TimezoneInfo 	&&
			sourceTwos.get(0) instanceof EmplevateInfo		)
			return new EmplevateMergerTimezone().merge((List<TimezoneInfo>) sourceOnes, (List<EmplevateInfo>) sourceTwos);
		
		return null;
	} 
}
