package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class OrderemCopyOrder extends InfoCopierOneToManyTemplate<OrderemInfo, OrderInfo>{
	
	public OrderemCopyOrder() {
		super();
	}
	
	
	
	@Override protected List<OrderemInfo> makeCopyHook(OrderInfo source) {	
		List<OrderemInfo> results = new ArrayList<>();
		
		for (OrderemInfo eachOrderem : source.orderms) {
			results.add(makeClone(eachOrderem));
		}
		
		return results;
	}
	
	
	
	private OrderemInfo makeClone(OrderemInfo recordInfo) {
		try {
			return (OrderemInfo) recordInfo.clone();
			
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
