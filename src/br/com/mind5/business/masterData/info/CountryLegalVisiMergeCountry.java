package br.com.mind5.business.masterData.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CountryLegalVisiMergeCountry implements InfoMergerVisitor_<CountryLegalInfo, CountryInfo> {

	@Override public CountryLegalInfo writeRecord(CountryInfo sourceOne, CountryLegalInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CountryLegalInfo resultInfo = CountryLegalInfo.copyFrom(sourceOne);
		return resultInfo;
	}
	
	
	
	private void checkArgument(CountryInfo sourceOne, CountryLegalInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}



	@Override public boolean shouldWrite(CountryInfo sourceOne, CountryLegalInfo sourceTwo) {
		return (sourceOne.codCountry != null) &&
			   (sourceTwo.codCountry != null) &&
			   (sourceOne.codCountry.equals(sourceTwo.codCountry));
	}
}
