package br.com.gda.business.materialTextSnapshot.info;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class MatextsnapVisiMergeMatext implements InfoMergerVisitorV2<MatextsnapInfo, MatextInfo> {

	@Override public MatextsnapInfo writeRecord(MatextInfo sourceOne, MatextsnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatextInfo sourceOne, MatextsnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatextsnapInfo merge(MatextInfo sourceOne, MatextsnapInfo sourceTwo) {
		MatextsnapInfo result = MatextsnapInfo.copyFrom(sourceOne);		
		result.codSnapshot = sourceTwo.codSnapshot;		
		return result;
	}
	
	
	
	@Override public boolean shouldWrite(MatextInfo sourceOne, MatextsnapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codMat   == sourceTwo.codMat			);
	}
}
