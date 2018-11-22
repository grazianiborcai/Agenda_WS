package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class StoreLDateVisitorPlan implements InfoMergerVisitor<StoreLDateInfo, PlanDataInfo, StoreLDateInfo> {

	@Override public StoreLDateInfo writeRecord(PlanDataInfo sourceOne, StoreLDateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StoreLDateInfo resultInfo = makeClone(sourceTwo);
		resultInfo.dateValidFrom = LocalDate.of(sourceOne.date.getYear(), sourceOne.date.getMonth(), sourceOne.date.getDayOfMonth());
		resultInfo.dateValidTo = LocalDate.of(sourceOne.date.getYear(), sourceOne.date.getMonth(), sourceOne.date.getDayOfMonth());

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanDataInfo sourceOne, StoreLDateInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StoreLDateInfo makeClone(StoreLDateInfo storeLDate) {
		try {
			return (StoreLDateInfo) storeLDate.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}



	@Override public boolean shouldWrite(PlanDataInfo sourceOne, StoreLDateInfo sourceTwo) {
		if (sourceTwo.codOwner <= 0)
			return false;		
		
		if (sourceOne.codOwner != sourceTwo.codOwner)
			return false;
		
		if (sourceOne.date == null)
			return false;
		
		
		return true;
	}
}
