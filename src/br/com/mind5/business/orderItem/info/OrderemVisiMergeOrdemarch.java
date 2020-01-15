package br.com.mind5.business.orderItem.info;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OrderemVisiMergeOrdemarch implements InfoMergerVisitor<OrderemInfo, OrdemarchInfo> {

	@Override public OrderemInfo writeRecord(OrdemarchInfo sourceOne, OrderemInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);

		return OrderemInfo.copyFrom(sourceOne);
	}
	
	
	
	private void checkArgument(OrdemarchInfo sourceOne, OrderemInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}


	
	@Override public boolean shouldWrite(OrdemarchInfo sourceOne, OrderemInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
