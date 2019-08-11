package br.com.gda.business.schedule.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderemVisiMergeStolis implements InfoMergerVisitor<ScheduInfo, StolisInfo> {

	@Override public ScheduInfo writeRecord(StolisInfo sourceOne, ScheduInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		ScheduInfo resultInfo = makeClone(sourceTwo);
		resultInfo.stolisData = sourceOne;
		resultInfo.recordMode = sourceOne.codCurr;
		resultInfo.txtCurr = sourceOne.txtCurr;
		return resultInfo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, ScheduInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private ScheduInfo makeClone(ScheduInfo recordInfo) {
		try {
			return (ScheduInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(StolisInfo sourceOne, ScheduInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codStore == sourceTwo.codStore	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
