package br.com.mind5.business.cartItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class CartemVisiMergeMat implements InfoMergerVisitor<CartemInfo, MatInfo> {

	@Override public CartemInfo writeRecord(MatInfo sourceOne, CartemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartemInfo resultInfo = makeClone(sourceTwo);
		resultInfo.matData = sourceOne;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, CartemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(MatInfo sourceOne, CartemInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codMat   == sourceTwo.codMat		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
