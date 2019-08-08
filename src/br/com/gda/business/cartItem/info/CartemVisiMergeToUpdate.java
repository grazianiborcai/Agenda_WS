package br.com.gda.business.cartItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartemVisiMergeToUpdate implements InfoMergerVisitor<CartemInfo, CartemInfo> {

	@Override public CartemInfo writeRecord(CartemInfo sourceOne, CartemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CartemInfo sourceOne, CartemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CartemInfo merge(CartemInfo sourceOne, CartemInfo sourceTwo) {
		CartemInfo result = makeClone(sourceTwo);		
		result.createdOn = sourceOne.createdOn;
		return result;
	}
	
	
	
	private CartemInfo makeClone(CartemInfo recordInfo) {
		try {
			return (CartemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CartemInfo sourceOne, CartemInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
