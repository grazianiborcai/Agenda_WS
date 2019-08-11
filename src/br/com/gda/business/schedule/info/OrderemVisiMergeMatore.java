package br.com.gda.business.schedule.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderemVisiMergeMatore implements InfoMergerVisitor<ScheduInfo, MatoreInfo> {

	@Override public ScheduInfo writeRecord(MatoreInfo sourceOne, ScheduInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		ScheduInfo resultInfo = makeClone(sourceTwo);
		resultInfo.price = sourceOne.matPrice;
		
		if (resultInfo.codWeekday == 1)
			resultInfo.price = sourceOne.matPrice1;
		
		if (resultInfo.codWeekday == 2)
			resultInfo.price = sourceOne.matPrice2;
		
		if (resultInfo.codWeekday == 3)
			resultInfo.price = sourceOne.matPrice3;
		
		if (resultInfo.codWeekday == 4)
			resultInfo.price = sourceOne.matPrice4;
		
		if (resultInfo.codWeekday == 5)
			resultInfo.price = sourceOne.matPrice5;
		
		if (resultInfo.codWeekday == 6)
			resultInfo.price = sourceOne.matPrice6;
		
		if (resultInfo.codWeekday == 7)
			resultInfo.price = sourceOne.matPrice7;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatoreInfo sourceOne, ScheduInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(MatoreInfo sourceOne, ScheduInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codStore == sourceTwo.codStore && 
				sourceOne.codMat   == sourceTwo.codMat		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
