package br.com.gda.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.info.InfoCopierOneToManyTemplate;

final class OrderemCopyOrder extends InfoCopierOneToManyTemplate<SchedineInfo, OrderInfo>{
	
	public OrderemCopyOrder() {
		super();
	}
	
	
	
	@Override protected List<SchedineInfo> makeCopyHook(OrderInfo source) {	
		List<SchedineInfo> results = new ArrayList<>();
		
		for (SchedineInfo eachOrderem : source.orderms) {
			results.add(makeClone(eachOrderem));
		}
		
		return results;
	}
	
	
	
	private SchedineInfo makeClone(SchedineInfo recordInfo) {
		try {
			return (SchedineInfo) recordInfo.clone();
			
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
