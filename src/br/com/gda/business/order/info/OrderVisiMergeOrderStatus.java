package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class OrderVisiMergeOrderStatus implements InfoMergerVisitorV2<OrderInfo, OrderStatusInfo> {

	@Override public OrderInfo writeRecord(OrderStatusInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OrderStatusInfo sourceOne, OrderInfo sourceTwo) {
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
	
	
	
	private OrderInfo merge(OrderStatusInfo sourceOne, OrderInfo sourceTwo) {
		sourceTwo.txtOrderStatus = sourceOne.txtOrderStatus;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrderStatusInfo sourceOne, OrderInfo sourceTwo) {		
		return (sourceOne.codOrderStatus.equals(sourceTwo.codOrderStatus));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
