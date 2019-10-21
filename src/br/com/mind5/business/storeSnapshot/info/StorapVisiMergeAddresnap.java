package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StorapVisiMergeAddresnap implements InfoMergerVisitor<StorapInfo, AddresnapInfo> {

	@Override public StorapInfo writeRecord(AddresnapInfo sourceOne, StorapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(AddresnapInfo sourceOne, StorapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StorapInfo merge(AddresnapInfo sourceOne, StorapInfo sourceTwo) {
		AddressInfo addressCopy = AddressInfo.copyFrom(sourceOne);
		sourceTwo.addresses.add(addressCopy);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(AddresnapInfo sourceOne, StorapInfo sourceTwo) {
		return (sourceOne.codOwner 			== sourceTwo.codOwner &&
				sourceOne.codStore 			== sourceTwo.codStore &&
				sourceOne.codStoreSnapshot 	== sourceTwo.codSnapshot);
	}	
}
