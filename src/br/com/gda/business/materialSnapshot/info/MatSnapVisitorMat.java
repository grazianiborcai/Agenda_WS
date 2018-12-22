package br.com.gda.business.materialSnapshot.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class MatSnapVisitorMat implements InfoMergerVisitor<MatSnapInfo, MatInfo, MatSnapInfo> {

	@Override public MatSnapInfo writeRecord(MatInfo sourceOne, MatSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, MatSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatSnapInfo merge(MatInfo sourceOne, MatSnapInfo sourceTwo) {
		MatSnapInfo resultInfo = MatSnapInfo.copyFrom(sourceOne);
		resultInfo.codSnapshot = sourceTwo.codSnapshot;
		
		return resultInfo;
	}
	
	
	
	@Override public boolean shouldWrite(MatInfo sourceOne, MatSnapInfo sourceTwo) {
		return (sourceOne.codOwner  == sourceTwo.codOwner	&&
				sourceOne.codMat 	== sourceTwo.codMat		);
	}
}
