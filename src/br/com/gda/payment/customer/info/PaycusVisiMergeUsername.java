package br.com.gda.payment.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.security.username.info.UsernameInfo;

final class PaycusVisiMergeUsername implements InfoMergerVisitorV2<PaycusInfo, UsernameInfo> {

	@Override public PaycusInfo writeRecord(UsernameInfo sourceOne, PaycusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaycusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UsernameInfo sourceOne, PaycusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PaycusInfo makeClone(PaycusInfo recordInfo) {
		try {
			return (PaycusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PaycusInfo merge(UsernameInfo sourceOne, PaycusInfo sourceTwo) {
		sourceTwo.codUser = sourceOne.codUser;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UsernameInfo sourceOne, PaycusInfo sourceTwo) {
		if (sourceOne.username == null ||
			sourceTwo.username == null		)
			return false;
		
		return (sourceOne.codOwner == sourceTwo.codOwner		&&
				sourceOne.username.equals(sourceTwo.username)		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
