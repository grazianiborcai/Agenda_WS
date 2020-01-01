package br.com.mind5.payment.storePartner.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoparVisiMergeStoparch implements InfoMergerVisitor<StoparInfo, StoparchInfo> {

	@Override public StoparInfo writeRecord(StoparchInfo sourceOne, StoparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return StoparInfo.copyFrom(sourceOne);
	}
	
	
	
	private void checkArgument(StoparchInfo sourceOne, StoparInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(StoparchInfo sourceOne, StoparInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
