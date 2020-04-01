package br.com.mind5.business.customer.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusVisiMergePhone implements InfoMergerVisitor_<CusInfo, PhoneInfo> {

	@Override public CusInfo writeRecord(PhoneInfo sourceOne, CusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(PhoneInfo sourceOne, CusInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CusInfo makeClone(CusInfo recordInfo) {
		try {
			return (CusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusInfo merge(PhoneInfo sourceOne, CusInfo sourceTwo) {
		sourceTwo.phones.add(sourceOne);

		return sourceTwo;
	}


	
	@Override public boolean shouldWrite(PhoneInfo sourceOne, CusInfo sourceTwo) {
		return (sourceOne.codOwner    == sourceTwo.codOwner && 
				sourceOne.codCustomer == sourceTwo.codCustomer);
	}		
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
