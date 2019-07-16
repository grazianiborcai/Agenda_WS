package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class OrderVisiMergeFeeCateg implements InfoMergerVisitorV2<OrderInfo, FeeCategInfo> {

	@Override public OrderInfo writeRecord(FeeCategInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FeeCategInfo sourceOne, OrderInfo sourceTwo) {
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
	
	
	
	private OrderInfo merge(FeeCategInfo sourceOne, OrderInfo sourceTwo) {
		sourceTwo.txtFeeCateg = sourceOne.txtFeeCateg;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FeeCategInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codFeeCateg == sourceTwo.codFeeCateg);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
