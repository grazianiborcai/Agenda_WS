package br.com.mind5.business.owner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OwnerVisiMergeAddress implements InfoMergerVisitor_<OwnerInfo, AddressInfo> {

	@Override public OwnerInfo writeRecord(AddressInfo sourceOne, OwnerInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OwnerInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(AddressInfo sourceOne, OwnerInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OwnerInfo makeClone(OwnerInfo recordInfo) {
		try {
			return (OwnerInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OwnerInfo merge(AddressInfo sourceOne, OwnerInfo sourceTwo) {
		sourceTwo.addresses.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(AddressInfo sourceOne, OwnerInfo sourceTwo) {
		return (sourceOne.codOwner 		== sourceTwo.codOwner &&
				sourceOne.codOwnerRef 	== sourceTwo.codOwner		);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
