package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.security.userList.info.UselisInfo;

final class EmpnapVisiMergeUselis implements InfoMergerVisitor<EmpnapInfo, UselisInfo> {

	@Override public EmpnapInfo writeRecord(UselisInfo sourceOne, EmpnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UselisInfo sourceOne, EmpnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpnapInfo merge(UselisInfo sourceOne, EmpnapInfo sourceTwo) {
		sourceTwo.codUserSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(UselisInfo sourceOne, EmpnapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner &&
				sourceOne.codUser   == sourceTwo.codUser);
	}
}
