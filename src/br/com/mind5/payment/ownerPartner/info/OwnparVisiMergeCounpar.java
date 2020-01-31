package br.com.mind5.payment.ownerPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

final class OwnparVisiMergeCounpar implements InfoMergerVisitor_<OwnparInfo, CounparInfo> {

	@Override public OwnparInfo writeRecord(CounparInfo sourceOne, OwnparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnparInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CounparInfo sourceOne, OwnparInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnparInfo makeClone(OwnparInfo recordInfo) {
		try {
			return (OwnparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnparInfo merge(CounparInfo sourceOne, OwnparInfo sourceTwo) {
		sourceTwo.codPayPartner = sourceOne.codPayPartner;
		sourceTwo.txtPayPartner = sourceOne.txtPayPartner;
		sourceTwo.isDefault = sourceOne.isDefault;
		sourceTwo.description = sourceOne.description;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CounparInfo sourceOne, OwnparInfo sourceTwo) {
		return (sourceOne.codCountry != null && 
				sourceTwo.codCountry != null &&
				sourceTwo.codCountry.equals(sourceOne.codCountry)	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
