package br.com.mind5.business.orderItemSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemrapVisiMergeMatsnap implements InfoMergerVisitor_<OrdemrapInfo, MatsnapInfo> {

	@Override public OrdemrapInfo writeRecord(MatsnapInfo sourceOne, OrdemrapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrdemrapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.matData = MatInfo.copyFrom(sourceOne);

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatsnapInfo sourceOne, OrdemrapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}	
	
	
	
	private OrdemrapInfo makeClone(OrdemrapInfo recordInfo) {
		try {
			return (OrdemrapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(MatsnapInfo sourceOne, OrdemrapInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner && 
				sourceOne.codMat  		== sourceTwo.codMat	  &&
				sourceOne.codSnapshot  	== sourceTwo.codMatSnapshot);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
