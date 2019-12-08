package br.com.mind5.business.material.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerVisitor;

final class MatVisiMergeFimist implements InfoMergerVisitor<MatInfo, FimistInfo> {

	@Override public MatInfo writeRecord(FimistInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(FimistInfo sourceOne, MatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatInfo merge(FimistInfo sourceOne, MatInfo sourceTwo) {
		sourceTwo.fimistes.add(sourceOne);

		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FimistInfo sourceOne, MatInfo sourceTwo) {
		return (sourceOne.codOwner 	== sourceTwo.codOwner &&
				sourceOne.codMat 	== sourceTwo.codMat		);
	}	
}
