package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class StolevateVisiMergePlan implements InfoMergerVisitor<StolevateInfo, PlanDataInfo, StolevateInfo> {

	@Override public StolevateInfo writeRecord(PlanDataInfo sourceOne, StolevateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StolevateInfo resultInfo = makeClone(sourceTwo);
		resultInfo.dateValidFrom = LocalDate.of(sourceOne.date.getYear(), sourceOne.date.getMonth(), sourceOne.date.getDayOfMonth());
		resultInfo.dateValidTo = LocalDate.of(sourceOne.date.getYear(), sourceOne.date.getMonth(), sourceOne.date.getDayOfMonth());

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanDataInfo sourceOne, StolevateInfo sourceTwo) {		
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolevateInfo makeClone(StolevateInfo storeLDate) {
		try {
			return (StolevateInfo) storeLDate.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}



	@Override public boolean shouldWrite(PlanDataInfo sourceOne, StolevateInfo sourceTwo) {
		if (sourceTwo.codOwner <= 0)
			return false;		
		
		if (sourceOne.codOwner != sourceTwo.codOwner)
			return false;
		
		if (sourceOne.date == null)
			return false;
		
		
		return true;
	}
}
