package br.com.gda.payment.customerPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.partnerMoip.customerMoip.info.CusmoipInfo;

final class CusparVisiMergeCusmoip implements InfoMergerVisitorV2<CusparInfo, CusmoipInfo> {

	@Override public CusparInfo writeRecord(CusmoipInfo sourceOne, CusparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusparInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CusmoipInfo sourceOne, CusparInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusparInfo makeClone(CusparInfo recordInfo) {
		try {
			return (CusparInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusparInfo merge(CusmoipInfo sourceOne, CusparInfo sourceTwo) {
		sourceTwo.customerId = sourceOne.customerId;
		sourceTwo.customerLink = sourceOne.customerLink;
		sourceTwo.accountLink = sourceOne.accountLink;	
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CusmoipInfo sourceOne, CusparInfo sourceTwo) {
		return (sourceOne.codOwner 		 == sourceTwo.codOwner			&&
				sourceOne.codPayCustomer == sourceTwo.codPayCustomer		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
