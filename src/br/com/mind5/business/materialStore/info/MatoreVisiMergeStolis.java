package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class MatoreVisiMergeStolis implements InfoMergerVisitor<MatoreInfo, StolisInfo> {

	@Override public MatoreInfo writeRecord(StolisInfo sourceOne, MatoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		sourceTwo.stolisData = sourceOne;
		return sourceTwo;
	}
	
	
	
	private void checkArgument(StolisInfo sourceOne, MatoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(StolisInfo sourceOne, MatoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codStore == sourceTwo.codStore);
	}
}
