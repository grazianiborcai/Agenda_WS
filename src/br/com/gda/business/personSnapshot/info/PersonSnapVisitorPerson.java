package br.com.gda.business.personSnapshot.info;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class PersonSnapVisitorPerson implements InfoMergerVisitor_<PersonSnapInfo, PersonInfo, PersonSnapInfo> {

	@Override public PersonSnapInfo writeRecord(PersonInfo sourceOne, PersonSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PersonInfo sourceOne, PersonSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PersonSnapInfo merge(PersonInfo sourceOne, PersonSnapInfo sourceTwo) {
		PersonSnapInfo resultInfo = PersonSnapInfo.copyFrom(sourceOne);
		resultInfo.codSnapshot = sourceTwo.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	@Override public boolean shouldWrite(PersonInfo sourceOne, PersonSnapInfo sourceTwo) {
		return (sourceOne.codOwner   == sourceTwo.codOwner 		&&
				sourceOne.codPerson  == sourceTwo.codPerson			);
	}
}
