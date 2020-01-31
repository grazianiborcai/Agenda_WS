package br.com.mind5.business.orderList.info;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdistVisiMergeOrdarch implements InfoMergerVisitor_<OrdistInfo, OrdarchInfo> {

	@Override public OrdistInfo writeRecord(OrdarchInfo sourceOne, OrdistInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return OrdistInfo.copyFrom(sourceOne);
	}
	
	
	
	private void checkArgument(OrdarchInfo sourceOne, OrdistInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	@Override public boolean shouldWrite(OrdarchInfo sourceOne, OrdistInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
