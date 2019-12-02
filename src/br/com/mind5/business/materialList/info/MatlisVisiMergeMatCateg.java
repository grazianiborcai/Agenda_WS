package br.com.mind5.business.materialList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class MatlisVisiMergeMatCateg implements InfoMergerVisitor<MatlisInfo, MatCategInfo> {

	@Override public MatlisInfo writeRecord(MatCategInfo sourceOne, MatlisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatlisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatCategInfo sourceOne, MatlisInfo sourceTwo) {
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
	
	
	
	private MatlisInfo merge(MatCategInfo sourceOne, MatlisInfo sourceTwo) {
		sourceTwo.codMatCateg = sourceOne.codMatCateg;
		sourceTwo.txtMatCateg = sourceOne.txtMatCateg;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatCategInfo sourceOne, MatlisInfo sourceTwo) {
		return (sourceOne.codMatCateg == sourceTwo.codMatCateg);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
