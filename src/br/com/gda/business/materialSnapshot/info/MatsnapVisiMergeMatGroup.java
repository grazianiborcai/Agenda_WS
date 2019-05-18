package br.com.gda.business.materialSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class MatsnapVisiMergeMatGroup implements InfoMergerVisitorV2<MatsnapInfo, MatGroupInfo> {

	@Override public MatsnapInfo writeRecord(MatGroupInfo sourceOne, MatsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatsnapInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatGroupInfo sourceOne, MatsnapInfo sourceTwo) {
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
	
	
	
	private MatsnapInfo merge(MatGroupInfo sourceOne, MatsnapInfo sourceTwo) {
		sourceTwo.codGroup = sourceOne.codGroup;
		sourceTwo.txtGroup = sourceOne.txtGroup;
		sourceTwo.codBusiness = sourceOne.codBusiness;
		sourceTwo.txtBusiness = sourceOne.txtBusiness;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatGroupInfo sourceOne, MatsnapInfo sourceTwo) {
		return (sourceOne.codGroup == sourceTwo.codGroup);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
