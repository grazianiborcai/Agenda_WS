package br.com.gda.business.masterData.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class StateVisitorCountry implements InfoMergerVisitor<StateInfo, CountryInfo, StateInfo> {

	@Override public StateInfo writeRecord(CountryInfo sourceOne, StateInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		StateInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtCountry = sourceOne.txtCountry;
		resultInfo.codCountryAlpha3 = sourceOne.codCountryAlpha3;

		return resultInfo;
	}
	
	
	
	private void checkArgument(CountryInfo sourceOne, StateInfo sourceTwo) {
		if (sourceOne.codCountry == null)
			throw new NullPointerException("sourceOne.codCountry" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.codCountry == null)
			throw new NullPointerException("sourceTwo.codCountry" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceOne.codCountry.equals(sourceTwo.codCountry) == false)
			throw new IllegalArgumentException("codCountry" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private StateInfo makeClone(StateInfo recordInfo) {
		try {
			return (StateInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
