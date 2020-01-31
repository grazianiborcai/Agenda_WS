package br.com.mind5.business.customerList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CuslisVisiMergeCusarch implements InfoMergerVisitor_<CuslisInfo, CusarchInfo> {

	@Override public CuslisInfo writeRecord(CusarchInfo sourceOne, CuslisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CuslisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusarchInfo sourceOne, CuslisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CuslisInfo makeClone(CuslisInfo recordInfo) {
		try {
			return (CuslisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CuslisInfo merge(CusarchInfo sourceOne, CuslisInfo sourceTwo) {
		return CuslisInfo.copyFrom(sourceOne);
	}
	
	
	
	@Override public boolean shouldWrite(CusarchInfo sourceOne, CuslisInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
