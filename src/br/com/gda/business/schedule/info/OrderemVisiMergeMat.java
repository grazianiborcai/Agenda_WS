package br.com.gda.business.schedule.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderemVisiMergeMat implements InfoMergerVisitor<ScheduInfo, MatInfo> {

	@Override public ScheduInfo writeRecord(MatInfo sourceOne, ScheduInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		ScheduInfo resultInfo = makeClone(sourceTwo);
		resultInfo.matData = sourceOne;
		resultInfo.codMatSnapshot = sourceOne.codSnapshot;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, ScheduInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(MatInfo sourceOne, ScheduInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codMat   == sourceTwo.codMat		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
