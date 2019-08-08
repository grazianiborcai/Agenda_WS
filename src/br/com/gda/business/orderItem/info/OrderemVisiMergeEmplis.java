package br.com.gda.business.orderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderemVisiMergeEmplis implements InfoMergerVisitor<OrderemInfo, EmplisInfo> {

	@Override public OrderemInfo writeRecord(EmplisInfo sourceOne, OrderemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderemInfo resultInfo = makeClone(sourceTwo);
		resultInfo.emplisData = sourceOne;
		return resultInfo;
	}
	
	
	
	private void checkArgument(EmplisInfo sourceOne, OrderemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderemInfo makeClone(OrderemInfo recordInfo) {
		try {
			return (OrderemInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(EmplisInfo sourceOne, OrderemInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&& 
				sourceOne.codEmployee 	== sourceTwo.codEmployee	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
