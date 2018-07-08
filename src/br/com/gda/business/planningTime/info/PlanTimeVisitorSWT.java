package br.com.gda.business.planningTime.info;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.VisitorMerger;

final class PlanTimeVisitorSWT implements VisitorMerger<PlanTimeInfo, MatStoreInfo, StoreWTimeInfo> {

	@Override public PlanTimeInfo mergeRecord(MatStoreInfo sourceOne, StoreWTimeInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanTimeInfo resultInfo = PlanTimeInfo.copyFrom(sourceTwo);
		//resultInfo.codEmployee = sourceOne.codEmployee;		

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatStoreInfo sourceOne, StoreWTimeInfo sourceTwo) {
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codStore != sourceTwo.codStore)
			throw new IllegalArgumentException("codStore" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
}
