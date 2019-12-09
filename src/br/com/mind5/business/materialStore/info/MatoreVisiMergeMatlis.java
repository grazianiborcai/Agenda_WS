package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class MatoreVisiMergeMatlis implements InfoMergerVisitor<MatoreInfo, MatlisInfo> {

	@Override public MatoreInfo writeRecord(MatlisInfo sourceOne, MatoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		sourceTwo.matlisData = sourceOne;
		return sourceTwo;
	}
	
	
	
	private void checkArgument(MatlisInfo sourceOne, MatoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(MatlisInfo sourceOne, MatoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner && 
				sourceOne.codMat   == sourceTwo.codMat);
	}
}
