package br.com.mind5.business.orderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemVisiMergeEmplis implements InfoMergerVisitor_<OrderemInfo, EmplisInfo> {

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
