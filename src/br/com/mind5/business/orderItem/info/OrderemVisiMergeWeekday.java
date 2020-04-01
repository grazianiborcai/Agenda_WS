package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrderemVisiMergeWeekday implements InfoMergerVisitor_<OrderemInfo, WeekdayInfo> {

	@Override public OrderemInfo writeRecord(WeekdayInfo sourceOne, OrderemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderemInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtWeekday = sourceOne.txtWeekday;

		return resultInfo;
	}
	
	
	
	private void checkArgument(WeekdayInfo sourceOne, OrderemInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(WeekdayInfo sourceOne, OrderemInfo sourceTwo) {
		return (sourceOne.codWeekday == sourceTwo.codWeekday);
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
