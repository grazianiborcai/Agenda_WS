package br.com.mind5.business.ownerList.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OwnelisVisiMergeComplis implements InfoMergerVisitor<OwnelisInfo, ComplisInfo> {

	@Override public OwnelisInfo writeRecord(ComplisInfo sourceOne, OwnelisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnelisInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(ComplisInfo sourceOne, OwnelisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnelisInfo makeClone(OwnelisInfo recordInfo) {
		try {
			return (OwnelisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnelisInfo merge(ComplisInfo sourceOne, OwnelisInfo sourceTwo) {
		sourceTwo.complisData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private ComplisInfo makeClone(ComplisInfo recordInfo) {
		try {
			return (ComplisInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(ComplisInfo sourceOne, OwnelisInfo sourceTwo) {
		return (sourceOne.codOwner   == sourceTwo.codOwner &&
				sourceOne.codCompany == sourceTwo.codCompany	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
