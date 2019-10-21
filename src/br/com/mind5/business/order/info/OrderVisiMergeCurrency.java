package br.com.mind5.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OrderVisiMergeCurrency implements InfoMergerVisitor<OrderInfo, CurrencyInfo> {

	@Override public OrderInfo writeRecord(CurrencyInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CurrencyInfo sourceOne, OrderInfo sourceTwo) {
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
	
	
	
	private OrderInfo merge(CurrencyInfo sourceOne, OrderInfo sourceTwo) {
		sourceTwo.txtCurr = sourceOne.txtCurr;

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CurrencyInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codCurr.equals(sourceTwo.codCurr));
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
