package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class AddressSnapVisitorAddress implements InfoMergerVisitor_<AddressSnapInfo, AddressInfo, AddressSnapInfo> {

	@Override public AddressSnapInfo writeRecord(AddressInfo sourceOne, AddressSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(AddressInfo sourceOne, AddressSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private AddressSnapInfo merge(AddressInfo sourceOne, AddressSnapInfo sourceTwo) {
		AddressSnapInfo resultInfo = AddressSnapInfo.copyFrom(sourceOne);
		resultInfo.codSnapshot = sourceTwo.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	@Override public boolean shouldWrite(AddressInfo sourceOne, AddressSnapInfo sourceTwo) {
		return (sourceOne.codOwner   == sourceTwo.codOwner 		&&
				sourceOne.codAddress == sourceTwo.codAddress		);
	}
}
