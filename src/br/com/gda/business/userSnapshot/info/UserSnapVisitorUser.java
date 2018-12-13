package br.com.gda.business.userSnapshot.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class UserSnapVisitorUser implements InfoMergerVisitor<UserSnapInfo, UserInfo, UserSnapInfo> {

	@Override public UserSnapInfo writeRecord(UserInfo sourceOne, UserSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UserInfo sourceOne, UserSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserSnapInfo merge(UserInfo sourceOne, UserSnapInfo sourceTwo) {
		UserSnapInfo resultInfo = UserSnapInfo.copyFrom(sourceOne);
		resultInfo.codSnapshot = sourceTwo.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	@Override public boolean shouldWrite(UserInfo sourceOne, UserSnapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codUser 	== sourceTwo.codUser		);
	}
}
