package br.com.gda.business.planningTime.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanimeVisiMergeEmp implements InfoMergerVisitorV2<PlanimeInfo, EmpInfo> {

	@Override public PlanimeInfo writeRecord(EmpInfo sourceOne, PlanimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		EmpInfo clonedEmployee = makeClone(sourceOne);
		sourceTwo.employees.add(clonedEmployee);
		
		return sourceTwo;
	}
	
	
	
	private void checkArgument(EmpInfo sourceOne, PlanimeInfo sourceTwo) {	
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpInfo makeClone(EmpInfo employee) {
		try {
			return (EmpInfo) employee.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(EmpInfo sourceOne, PlanimeInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
