package br.com.mind5.business.scheduleYearData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class SchedyeratVisiMergeMonth implements InfoMergerVisitor<SchedyeratInfo, MonthInfo> {

	@Override public SchedyeratInfo writeRecord(MonthInfo sourceOne, SchedyeratInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedyeratInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtMonth = sourceOne.txtMonth;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MonthInfo sourceOne, SchedyeratInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedyeratInfo makeClone(SchedyeratInfo recordInfo) {
		try {
			return (SchedyeratInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(MonthInfo sourceOne, SchedyeratInfo sourceTwo) {
		if (sourceOne.codLanguage == null ||
			sourceTwo.codLanguage == null	)
			
			return false;
				
		
		
		return (sourceOne.month == sourceTwo.month && 
				sourceOne.codLanguage.equals(sourceTwo.codLanguage));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
