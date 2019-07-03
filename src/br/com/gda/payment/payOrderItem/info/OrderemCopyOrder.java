package br.com.gda.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class OrderemCopyOrder extends InfoCopierOneToManyTemplate<PayordemInfo, OrderInfo>{
	
	public OrderemCopyOrder() {
		super();
	}
	
	
	
	@Override protected List<PayordemInfo> makeCopyHook(OrderInfo source) {	
		List<PayordemInfo> results = new ArrayList<>();
		
		for (PayordemInfo eachOrderem : source.orderms) {
			results.add(makeClone(eachOrderem));
		}
		
		return results;
	}
	
	
	
	private PayordemInfo makeClone(PayordemInfo recordInfo) {
		try {
			return (PayordemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
