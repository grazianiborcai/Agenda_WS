package br.com.mind5.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class OrderVisiMergePayord implements InfoMergerVisitor_<OrderInfo, PayordInfo> {

	@Override public OrderInfo writeRecord(PayordInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PayordInfo sourceOne, OrderInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OrderInfo merge(PayordInfo sourceOne, OrderInfo sourceTwo) {
		sourceTwo.codPayPartner = sourceOne.codPayPartner;
		sourceTwo.statusOrderPartner = sourceOne.statusOrderPartner;
		sourceTwo.statusPaymentPartner = sourceOne.statusPaymentPartner;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PayordInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner &&
				sourceOne.codOrder    == sourceTwo.codOrder &&
				sourceOne.codPayOrder == sourceTwo.codPayOrder);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
