package br.com.mind5.business.storeList.info;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolisVisiMergeComp implements InfoMergerVisitor_<StolisInfo, CompInfo> {

	@Override public StolisInfo writeRecord(CompInfo sourceOne, StolisInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CompInfo sourceOne, StolisInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StolisInfo merge(CompInfo sourceOne, StolisInfo sourceTwo) {
		sourceTwo.companyData = new CompInfo();
		
		sourceTwo.companyData.codOwner = sourceOne.codOwner;
		sourceTwo.companyData.codCompany = sourceOne.codCompany;
		sourceTwo.companyData.name = sourceOne.name;
		sourceTwo.companyData.email = sourceOne.email;
		sourceTwo.companyData.codLanguage = sourceOne.codLanguage;
		sourceTwo.companyData.username = sourceOne.username;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CompInfo sourceOne, StolisInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
}
