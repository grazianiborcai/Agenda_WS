package br.com.mind5.business.owner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoKeeperVisitor_;

final class OwnerVisiKeepOwner implements InfoKeeperVisitor_<OwnerInfo, OwnerInfo> {

	@Override public OwnerInfo keepAtribute(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerInfo clonedInfo = makeClone(sourceTwo);
		return keep(sourceOne, clonedInfo);
	}
	
	
	
	private OwnerInfo makeClone(OwnerInfo recordInfo) {
		try {
			return (OwnerInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void checkArgument(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.KEEP_NOT_ALLOWED);
	}
	
	
	
	private OwnerInfo keep(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		sourceTwo.codOwner = sourceOne.codOwner;
		sourceTwo.codPerson = sourceOne.codPerson;
		sourceTwo.codCompany = sourceOne.codCompany;
		sourceTwo.codUser = sourceOne.codUser;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OwnerInfo sourceOne, OwnerInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
