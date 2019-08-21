package br.com.gda.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerOneToManyVisitor;

final class SchedineVisiMergeOrder implements InfoMergerOneToManyVisitor<SchedineInfo, OrderInfo> {

	@Override public List<SchedineInfo> writeRecord(OrderInfo sourceOne, SchedineInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrderInfo sourceOne, SchedineInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private List<SchedineInfo> merge(OrderInfo sourceOne, SchedineInfo sourceTwo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		for(OrderemInfo eachOrderem : sourceOne.orderms) {
			SchedineInfo eachResult = SchedineInfo.copyFrom(eachOrderem);
			eachResult.codCustomer = sourceOne.codCustomer;		
			eachResult.codOrderStatus = sourceOne.codOrderStatus;
			eachResult.codSchedule = sourceTwo.codSchedule;	
			
			results.add(eachResult);
		}
		
		
		return results;
	}
	
	
	
	@Override public boolean shouldWrite(OrderInfo sourceOne, SchedineInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codOrder == sourceTwo.codOrder	);
	}
}
