package br.com.gda.business.schedule.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class OrderemCopyOrder extends InfoCopierOneToManyTemplate<ScheduInfo, OrderInfo>{
	
	public OrderemCopyOrder() {
		super();
	}
	
	
	
	@Override protected List<ScheduInfo> makeCopyHook(OrderInfo source) {	
		List<ScheduInfo> results = new ArrayList<>();
		
		for (ScheduInfo eachOrderem : source.orderms) {
			results.add(makeClone(eachOrderem));
		}
		
		return results;
	}
	
	
	
	private ScheduInfo makeClone(ScheduInfo recordInfo) {
		try {
			return (ScheduInfo) recordInfo.clone();
			
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
