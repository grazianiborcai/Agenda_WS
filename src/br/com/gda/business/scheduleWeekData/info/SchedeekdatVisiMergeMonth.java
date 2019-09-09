package br.com.gda.business.scheduleWeekData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MonthInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedeekdatVisiMergeMonth implements InfoMergerVisitor<SchedeekdatInfo, MonthInfo> {

	@Override public SchedeekdatInfo writeRecord(MonthInfo sourceOne, SchedeekdatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedeekdatInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtMonth = sourceOne.txtMonth;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MonthInfo sourceOne, SchedeekdatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedeekdatInfo makeClone(SchedeekdatInfo recordInfo) {
		try {
			return (SchedeekdatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(MonthInfo sourceOne, SchedeekdatInfo sourceTwo) {
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
