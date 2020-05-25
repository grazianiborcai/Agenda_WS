package br.com.mind5.business.scheduleWeekData.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.month.info.MonthInfo;

final class SchedeekdatVisiMergeMonth implements InfoMergerVisitor_<SchedeekdatInfo, MonthInfo> {

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
		
		SystemLog.logError(this.getClass(), e);
	}
}
