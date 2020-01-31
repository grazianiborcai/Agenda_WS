package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StorapVisiMergeCompnap implements InfoMergerVisitor_<StorapInfo, CompnapInfo> {

	@Override public StorapInfo writeRecord(CompnapInfo sourceOne, StorapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CompnapInfo sourceOne, StorapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorapInfo merge(CompnapInfo sourceOne, StorapInfo sourceTwo) {
		sourceTwo.companyData = CompInfo.copyFrom(sourceOne);
		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(CompnapInfo sourceOne, StorapInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&&
				sourceOne.codCompany 	== sourceTwo.codCompany	&&
				sourceOne.codSnapshot 	== sourceTwo.codCompanySnapshot);
	}	
}
