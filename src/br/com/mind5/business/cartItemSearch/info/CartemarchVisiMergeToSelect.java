package br.com.mind5.business.cartItemSearch.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemarchVisiMergeToSelect implements InfoMergerVisitor_<CartemarchInfo, CartemarchInfo> {

	@Override public CartemarchInfo writeRecord(CartemarchInfo sourceOne, CartemarchInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CartemarchInfo sourceOne, CartemarchInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CartemarchInfo merge(CartemarchInfo sourceOne, CartemarchInfo sourceTwo) {
		CartemarchInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private CartemarchInfo makeClone(CartemarchInfo recordInfo) {
		try {
			return (CartemarchInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CartemarchInfo sourceOne, CartemarchInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
