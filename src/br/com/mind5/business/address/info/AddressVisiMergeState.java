package br.com.mind5.business.address.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddressVisiMergeState implements InfoMergerVisitor_<AddressInfo, StateInfo> {

	@Override public AddressInfo writeRecord(StateInfo sourceOne, AddressInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(StateInfo sourceOne, AddressInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddressInfo merge(StateInfo sourceOne, AddressInfo sourceTwo) {
		AddressInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtState = sourceOne.txtState;
		
		return resultInfo;
	}
	
	
	
	private AddressInfo makeClone(AddressInfo recordInfo) {
		try {
			return (AddressInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(StateInfo sourceOne, AddressInfo sourceTwo) {
		return sourceOne.codCountry.equals(sourceTwo.codCountry);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
