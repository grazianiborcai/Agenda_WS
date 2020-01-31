package br.com.mind5.business.companyList.info;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class ComplisVisiMergeComparch implements InfoMergerVisitor_<ComplisInfo, ComparchInfo> {

	@Override public ComplisInfo writeRecord(ComparchInfo sourceOne, ComplisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return ComplisInfo.copyFrom(sourceOne);
	}
	
	
	
	private void checkArgument(ComparchInfo sourceOne, ComplisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	@Override public boolean shouldWrite(ComparchInfo sourceOne, ComplisInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
