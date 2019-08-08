package br.com.gda.payment.customerPartner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CusparVisiMergeAddresnap implements InfoMergerVisitor<CusparInfo, AddresnapInfo> {

	@Override public CusparInfo writeRecord(AddresnapInfo sourceOne, CusparInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusparInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AddresnapInfo sourceOne, CusparInfo sourceTwo) {
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
	
	
	
	private CusparInfo merge(AddresnapInfo sourceOne, CusparInfo sourceTwo) {
		sourceTwo.addresnapData = makeClone(sourceOne);
		return sourceTwo;
	}
	
	
	
	private AddresnapInfo makeClone(AddresnapInfo recordInfo) {
		try {
			return (AddresnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(AddresnapInfo sourceOne, CusparInfo sourceTwo) {		
		return (sourceOne.codOwner    == sourceTwo.codOwner		&&
				sourceOne.codAddress  == sourceTwo.codAddress	&&
				sourceOne.codSnapshot == sourceTwo.codAddressSnapshot);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
