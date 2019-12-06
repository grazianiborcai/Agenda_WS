package br.com.mind5.business.materialList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class MatlisVisiMergeMatarch implements InfoMergerVisitor<MatlisInfo, MatarchInfo> {

	@Override public MatlisInfo writeRecord(MatarchInfo sourceOne, MatlisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatlisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatarchInfo sourceOne, MatlisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatlisInfo makeClone(MatlisInfo recordInfo) {
		try {
			return (MatlisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatlisInfo merge(MatarchInfo sourceOne, MatlisInfo sourceTwo) {
		return MatlisInfo.copyFrom(sourceOne);
	}


	
	@Override public boolean shouldWrite(MatarchInfo sourceOne, MatlisInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
