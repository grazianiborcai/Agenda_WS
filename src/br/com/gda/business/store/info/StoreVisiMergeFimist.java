package br.com.gda.business.store.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.info.InfoMergerVisitor;

final class StoreVisiMergeFimist implements InfoMergerVisitor<StoreInfo, FimistInfo> {

	@Override public StoreInfo writeRecord(FimistInfo sourceOne, StoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FimistInfo sourceOne, StoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StoreInfo merge(FimistInfo sourceOne, StoreInfo sourceTwo) {
		sourceTwo.fimistes.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FimistInfo sourceOne, StoreInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner &&
				sourceOne.codStore 	== sourceTwo.codStore		);
	}	
}
