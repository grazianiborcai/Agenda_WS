package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;

import br.com.gda.business.planningTime.info.PlanDataInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoWriteVisitor;

final class StoreLDateVisitorPlan implements InfoWriteVisitor<StoreLDateInfo, PlanDataInfo, StoreLDateInfo> {

	@Override public StoreLDateInfo writeRecord(PlanDataInfo sourceOne, StoreLDateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StoreLDateInfo resultInfo = makeClone(sourceTwo);
		resultInfo.dateValidFrom = LocalDate.of(sourceOne.date.getYear(), sourceOne.date.getMonth(), sourceOne.date.getDayOfMonth());
		resultInfo.dateValidTo = LocalDate.of(sourceOne.date.getYear(), sourceOne.date.getMonth(), sourceOne.date.getDayOfMonth());

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanDataInfo sourceOne, StoreLDateInfo sourceTwo) {		
		if (sourceTwo.codOwner <= 0)
			throw new IllegalArgumentException("codOwner" + SystemMessage.NULL_ARGUMENT);		
		
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.date == null)
			throw new IllegalArgumentException("codOwner" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private StoreLDateInfo makeClone(StoreLDateInfo storeLDate) {
		try {
			return (StoreLDateInfo) storeLDate.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
}
