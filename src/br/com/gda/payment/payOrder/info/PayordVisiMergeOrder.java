package br.com.gda.payment.payOrder.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PayordVisiMergeOrder implements InfoMergerVisitorV2<PayordInfo, OrderInfo> {

	@Override public PayordInfo writeRecord(OrderInfo sourceOne, PayordInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PayordInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OrderInfo sourceOne, PayordInfo sourceTwo) {
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
	
	
	
	private PayordInfo merge(OrderInfo sourceOne, PayordInfo sourceTwo) {
		sourceTwo.codOrderStatus = sourceOne.codOrderStatus;
		sourceTwo.txtOrderStatus = sourceOne.txtOrderStatus;
		sourceTwo.codOrderUser = sourceOne.codUser;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrderInfo sourceOne, PayordInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
