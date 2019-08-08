package br.com.gda.business.materialSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatsnapVisiMergeMatCateg implements InfoMergerVisitor<MatsnapInfo, MatCategInfo> {

	@Override public MatsnapInfo writeRecord(MatCategInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatCategInfo sourceOne, MatsnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatsnapInfo makeClone(MatsnapInfo recordInfo) {
		try {
			return (MatsnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatsnapInfo merge(MatCategInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.codMatCateg = sourceOne.codMatCateg;
		sourceTwo.txtMatCateg = sourceOne.txtMatCateg;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatCategInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codMatCateg == sourceTwo.codMatCateg);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
