package br.com.mind5.business.scheduleLine.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class SchedineVisiMergeWeekday implements InfoMergerVisitor<SchedineInfo, WeekdayInfo> {

	@Override public SchedineInfo writeRecord(WeekdayInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedineInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtWeekday = sourceOne.txtWeekday;

		return resultInfo;
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, SchedineInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedineInfo makeClone(SchedineInfo recordInfo) {
		try {
			return (SchedineInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, SchedineInfo sourceTwo) {
		if (sourceOne.codLanguage == null ||
			sourceTwo.codLanguage == null 	)
			
			return false;
				
		
		
		return (sourceOne.codWeekday == sourceTwo.codWeekday && 
				sourceOne.codLanguage.equals(sourceTwo.codLanguage));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
