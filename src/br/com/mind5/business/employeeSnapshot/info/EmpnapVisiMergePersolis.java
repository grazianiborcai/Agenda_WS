package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class EmpnapVisiMergePersolis implements InfoMergerVisitor<EmpnapInfo, PersolisInfo> {

	@Override public EmpnapInfo writeRecord(PersolisInfo sourceOne, EmpnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(PersolisInfo sourceOne, EmpnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private EmpnapInfo merge(PersolisInfo sourceOne, EmpnapInfo sourceTwo) {
		sourceTwo.codPersonSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(PersolisInfo sourceOne, EmpnapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner &&
				sourceOne.codPerson == sourceTwo.codPerson);
	}
}
