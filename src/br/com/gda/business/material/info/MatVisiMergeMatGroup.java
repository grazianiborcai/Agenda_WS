package br.com.gda.business.material.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatVisiMergeMatGroup implements InfoMergerVisitor<MatInfo, MatGroupInfo, MatInfo> {

	@Override public MatInfo writeRecord(MatGroupInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatGroupInfo sourceOne, MatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatInfo makeClone(MatInfo recordInfo) {
		try {
			return (MatInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private MatInfo merge(MatGroupInfo sourceOne, MatInfo sourceTwo) {
		sourceTwo.codGroup = sourceOne.codGroup;
		sourceTwo.txtGroup = sourceOne.txtGroup;
		sourceTwo.codBusiness = sourceOne.codBusiness;
		sourceTwo.txtBusiness = sourceOne.txtBusiness;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatGroupInfo sourceOne, MatInfo sourceTwo) {
		return (sourceOne.codGroup == sourceTwo.codGroup);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
