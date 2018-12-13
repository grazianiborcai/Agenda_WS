package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PhoneSnapVisitorPhone implements InfoMergerVisitor<PhoneSnapInfo, PhoneInfo, PhoneSnapInfo> {

	@Override public PhoneSnapInfo writeRecord(PhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PhoneSnapInfo merge(PhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		PhoneSnapInfo resultInfo = PhoneSnapInfo.copyFrom(sourceOne);
		resultInfo.codSnapshot = sourceTwo.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	@Override public boolean shouldWrite(PhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return (sourceOne.codOwner   == sourceTwo.codOwner 		&&
				sourceOne.codPhone == sourceTwo.codPhone			);
	}
}
