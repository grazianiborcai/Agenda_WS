package br.com.gda.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.username.info.UsernameInfo;

final class PayordVisiMergeUsername implements InfoMergerVisitor<PayordInfo, UsernameInfo> {

	@Override public PayordInfo writeRecord(UsernameInfo sourceOne, PayordInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayordInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UsernameInfo sourceOne, PayordInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PayordInfo makeClone(PayordInfo recordInfo) {
		try {
			return (PayordInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PayordInfo merge(UsernameInfo sourceOne, PayordInfo sourceTwo) {
		sourceTwo.codUser = sourceOne.codUser;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UsernameInfo sourceOne, PayordInfo sourceTwo) {
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
