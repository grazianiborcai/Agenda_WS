package br.com.mind5.payment.storePartnerList.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoplisVisiMergeStoparch implements InfoMergerVisitor<StoplisInfo, StoparchInfo> {

	@Override public StoplisInfo writeRecord(StoparchInfo sourceOne, StoplisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return StoplisInfo.copyFrom(sourceOne);
	}
	
	
	
	private void checkArgument(StoparchInfo sourceOne, StoplisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(StoparchInfo sourceOne, StoplisInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
