package br.com.mind5.business.cartItem.info;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CartemVisiMergeCartemarch implements InfoMergerVisitor_<CartemInfo, CartemarchInfo> {

	@Override public CartemInfo writeRecord(CartemarchInfo sourceOne, CartemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);

		return CartemInfo.copyFrom(sourceOne);
	}
	
	
	
	private void checkArgument(CartemarchInfo sourceOne, CartemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(CartemarchInfo sourceOne, CartemInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
