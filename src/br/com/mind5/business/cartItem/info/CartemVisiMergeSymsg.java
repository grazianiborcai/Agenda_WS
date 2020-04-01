package br.com.mind5.business.cartItem.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

final class CartemVisiMergeSymsg implements InfoMergerVisitor_<CartemInfo, SymsgInfo> {

	@Override public CartemInfo writeRecord(SymsgInfo sourceOne, CartemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartemInfo resultInfo = makeClone(sourceTwo);
		resultInfo.symsgData = sourceOne;
		return resultInfo;
	}
	
	
	
	private void checkArgument(SymsgInfo sourceOne, CartemInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(SymsgInfo sourceOne, CartemInfo sourceTwo) {
		return true;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
