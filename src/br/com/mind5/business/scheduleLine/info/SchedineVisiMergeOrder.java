package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerOneToManyVisitor_;

final class SchedineVisiMergeOrder implements InfoMergerOneToManyVisitor_<SchedineInfo, OrderInfo> {

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
