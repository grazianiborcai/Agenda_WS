package br.com.mind5.business.scheduleMonthData.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.MonthInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class SchedonthatVisiMergeMonth implements InfoMergerVisitor<SchedonthatInfo, MonthInfo> {

	@Override public SchedonthatInfo writeRecord(MonthInfo sourceOne, SchedonthatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		SchedonthatInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtMonth = sourceOne.txtMonth;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MonthInfo sourceOne, SchedonthatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private SchedonthatInfo makeClone(SchedonthatInfo recordInfo) {
		try {
			return (SchedonthatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(MonthInfo sourceOne, SchedonthatInfo sourceTwo) {
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
