package br.com.gda.business.userSnapshot.info;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class UserSnapVisitorPersonSnap implements InfoMergerVisitor<UserSnapInfo, PersonSnapInfo, UserSnapInfo> {

	@Override public UserSnapInfo writeRecord(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private UserSnapInfo merge(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		UserSnapInfo resultInfo = UserSnapInfo.copyFrom(sourceOne);
		resultInfo.addresses = sourceTwo.addresses;
		resultInfo.phones = sourceTwo.phones;
		resultInfo.codUser = sourceTwo.codUser;
		resultInfo.codCustomer = sourceTwo.codCustomer;
		
		return resultInfo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codPerson == sourceTwo.codPerson		);
	}
}
