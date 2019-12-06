package br.com.mind5.business.material.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class MatVisiMergeMatext implements InfoMergerVisitor<MatInfo, MatextInfo> {

	@Override public MatInfo writeRecord(MatextInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(MatextInfo sourceOne, MatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private MatInfo merge(MatextInfo sourceOne, MatInfo sourceTwo) {
		sourceTwo.matextes.add(sourceOne);		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(MatextInfo sourceOne, MatInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codMat == sourceTwo.codMat			);
	}
}
