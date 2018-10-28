package br.com.gda.business.customer.info;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CusVisitorGender implements InfoMergerVisitor<CusInfo, GenderInfo, CusInfo> {

	@Override public CusInfo writeRecord(GenderInfo sourceOne, CusInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CusInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(GenderInfo sourceOne, CusInfo sourceTwo) {
		if (sourceOne.codGender != sourceTwo.codGender)
			throw new IllegalArgumentException("codGender" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private CusInfo makeClone(CusInfo recordInfo) {
		try {
			return (CusInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CusInfo merge(GenderInfo sourceOne, CusInfo sourceTwo) {
		sourceTwo.txtGender = sourceOne.txtGender;

		return sourceTwo;
	}
}
