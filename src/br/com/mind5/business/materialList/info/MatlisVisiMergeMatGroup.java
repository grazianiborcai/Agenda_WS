package br.com.mind5.business.materialList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisVisiMergeMatGroup implements InfoMergerVisitor_<MatlisInfo, MatGroupInfo> {

	@Override public MatlisInfo writeRecord(MatGroupInfo sourceOne, MatlisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		MatlisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(MatGroupInfo sourceOne, MatlisInfo sourceTwo) {
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
	
	
	
	private MatlisInfo merge(MatGroupInfo sourceOne, MatlisInfo sourceTwo) {
		sourceTwo.codGroup = sourceOne.codGroup;
		sourceTwo.txtGroup = sourceOne.txtGroup;
		sourceTwo.codBusiness = sourceOne.codBusiness;
		sourceTwo.txtBusiness = sourceOne.txtBusiness;

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(MatGroupInfo sourceOne, MatlisInfo sourceTwo) {
		return (sourceOne.codGroup == sourceTwo.codGroup);
	}		
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
