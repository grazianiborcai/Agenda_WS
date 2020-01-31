package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedeekVisiMergeMatlis implements InfoMergerVisitor_<SchedeekInfo, MatlisInfo> {

	@Override public SchedeekInfo writeRecord(MatlisInfo sourceOne, SchedeekInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		sourceTwo.matlises.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatlisInfo sourceOne, SchedeekInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	


	
	@Override public boolean shouldWrite(MatlisInfo sourceOne, SchedeekInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
