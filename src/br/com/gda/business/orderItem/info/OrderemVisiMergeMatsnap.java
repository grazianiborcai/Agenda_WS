package br.com.gda.business.orderItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderemVisiMergeMatsnap implements InfoMergerVisitor<OrderemInfo, MatsnapInfo> {

	@Override public OrderemInfo writeRecord(MatsnapInfo sourceOne, OrderemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderemInfo resultInfo = makeClone(sourceTwo);
		resultInfo.matData = MatInfo.copyFrom(sourceOne);

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatsnapInfo sourceOne, OrderemInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(MatsnapInfo sourceOne, OrderemInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner && 
				sourceOne.codMat  		== sourceTwo.codMat   &&
				sourceOne.codSnapshot   == sourceTwo.codMatSnapshot);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
