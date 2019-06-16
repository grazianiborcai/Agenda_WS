package br.com.gda.payment.customer.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PaycusVisiMergeUser implements InfoMergerVisitorV2<PaycusInfo, UserInfo> {

	@Override public PaycusInfo writeRecord(UserInfo sourceOne, PaycusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PaycusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, PaycusInfo sourceTwo) {
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
	
	
	
	private PaycusInfo merge(UserInfo sourceOne, PaycusInfo sourceTwo) {
		sourceTwo.codUserSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, PaycusInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codUser  == sourceTwo.codUser		); 
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
