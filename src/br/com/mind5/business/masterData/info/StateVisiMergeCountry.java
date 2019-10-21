package br.com.mind5.business.masterData.info;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class StateVisiMergeCountry implements InfoMergerVisitor<StateInfo, CountryInfo> {

	@Override public StateInfo writeRecord(CountryInfo sourceOne, StateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StateInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtCountry = sourceOne.txtCountry;
		resultInfo.codCountryAlpha3 = sourceOne.codCountryAlpha3;

		return resultInfo;
	}
	
	
	
	private void checkArgument(CountryInfo sourceOne, StateInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private StateInfo makeClone(StateInfo recordInfo) {
		try {
			return (StateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(CountryInfo sourceOne, StateInfo sourceTwo) {
		return (sourceOne.codCountry != null) &&
			   (sourceTwo.codCountry != null) &&
			   (sourceOne.codCountry.equals(sourceTwo.codCountry));
	}
}
