package br.com.gda.business.planningTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanimeVisiMergeEmplis implements InfoMergerVisitor<PlanimeInfo, EmplisInfo> {

	@Override public PlanimeInfo writeRecord(EmplisInfo sourceOne, PlanimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		EmplisInfo clonedEmployee = makeClone(sourceOne);
		sourceTwo.employees.add(clonedEmployee);
		
		return sourceTwo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, PlanimeInfo sourceTwo) {	
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmplisInfo makeClone(EmplisInfo employee) {
		try {
			return (EmplisInfo) employee.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(EmplisInfo sourceOne, PlanimeInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
