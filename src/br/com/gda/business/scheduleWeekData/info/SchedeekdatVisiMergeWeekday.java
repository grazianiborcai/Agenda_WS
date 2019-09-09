package br.com.gda.business.scheduleWeekData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class SchedeekdatVisiMergeWeekday implements InfoMergerVisitor<SchedeekdatInfo, WeekdayInfo> {

	@Override public SchedeekdatInfo writeRecord(WeekdayInfo sourceOne, SchedeekdatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedeekdatInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtWeekday = sourceOne.txtWeekday;

		return resultInfo;
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, SchedeekdatInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, SchedeekdatInfo sourceTwo) {
		if (sourceOne.codLanguage == null ||
			sourceTwo.codLanguage == null	)
			
			return false;
				
		
		
		return (sourceOne.codWeekday == sourceTwo.codWeekday && 
				sourceOne.codLanguage.equals(sourceTwo.codLanguage));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
