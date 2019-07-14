package br.com.gda.payment.permissionMoip.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.tokenMoip.info.TokemoipInfo;

final class PeresmoipVisiMergeTokemoip implements InfoMergerVisitorV2<PeresmoipInfo, TokemoipInfo> {

	@Override public PeresmoipInfo writeRecord(TokemoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PeresmoipInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(TokemoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private PeresmoipInfo makeClone(PeresmoipInfo recordInfo) {
		try {
			return (PeresmoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private PeresmoipInfo merge(TokemoipInfo sourceOne, PeresmoipInfo sourceTwo) {
		sourceTwo.tokemoipData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private TokemoipInfo makeClone(TokemoipInfo recordInfo) {
		try {
			return (TokemoipInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	@Override public boolean shouldWrite(TokemoipInfo sourceOne, PeresmoipInfo sourceTwo) {		
		return (sourceOne.codPayPartner == sourceTwo.codPayPartner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
