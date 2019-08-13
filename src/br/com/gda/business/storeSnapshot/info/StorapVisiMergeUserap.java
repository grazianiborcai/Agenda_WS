package br.com.gda.business.storeSnapshot.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.userSnapshot.info.UserapInfo;

final class StorapVisiMergeUserap implements InfoMergerVisitor<StorapInfo, UserapInfo> {

	@Override public StorapInfo writeRecord(UserapInfo sourceOne, StorapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UserapInfo sourceOne, StorapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorapInfo merge(UserapInfo sourceOne, StorapInfo sourceTwo) {
		sourceTwo.userData = UserInfo.copyFrom(sourceOne);
		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(UserapInfo sourceOne, StorapInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner 	&&
				sourceOne.codUser 		== sourceTwo.codUser	&&
				sourceOne.codSnapshot 	== sourceTwo.codUserSnapshot);
	}	
}
