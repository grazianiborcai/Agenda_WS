package br.com.mind5.business.cartItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class CartemVisiMergeEmplis implements InfoMergerVisitor<CartemInfo, EmplisInfo> {

	@Override public CartemInfo writeRecord(EmplisInfo sourceOne, CartemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartemInfo resultInfo = makeClone(sourceTwo);
		resultInfo.emplisData = sourceOne;
		return resultInfo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, CartemInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, CartemInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&& 
				sourceOne.codEmployee 	== sourceTwo.codEmployee	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
