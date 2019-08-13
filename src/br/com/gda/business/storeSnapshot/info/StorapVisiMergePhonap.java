package br.com.gda.business.storeSnapshot.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class StorapVisiMergePhonap implements InfoMergerVisitor<StorapInfo, PhonapInfo> {

	@Override public StorapInfo writeRecord(PhonapInfo sourceOne, StorapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PhonapInfo sourceOne, StorapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorapInfo merge(PhonapInfo sourceOne, StorapInfo sourceTwo) {
		PhoneInfo phoneCopy = PhoneInfo.copyFrom(sourceOne);
		sourceTwo.phones.add(phoneCopy);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(PhonapInfo sourceOne, StorapInfo sourceTwo) {
		return (sourceOne.codOwner 			== sourceTwo.codOwner 	&&
				sourceOne.codStore 			== sourceTwo.codStore	&&
				sourceOne.codStoreSnapshot 	== sourceTwo.codSnapshot);
	}	
}
