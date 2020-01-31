package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatoreVisiMergeMatorarch implements InfoMergerVisitor_<MatoreInfo, MatorarchInfo> {

	@Override public MatoreInfo writeRecord(MatorarchInfo sourceOne, MatoreInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return MatoreInfo.copyFrom(sourceOne);
	}
	
	
	
	private void checkArgument(MatorarchInfo sourceOne, MatoreInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(MatorarchInfo sourceOne, MatoreInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
