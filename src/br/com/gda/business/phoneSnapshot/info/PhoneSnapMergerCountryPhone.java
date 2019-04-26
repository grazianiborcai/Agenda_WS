package br.com.gda.business.phoneSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.info.InfoMerger_;

final class PhoneSnapMergerCountryPhone extends InfoMerger_<PhoneSnapInfo, CountryPhoneInfo, PhoneSnapInfo> {
	public PhoneSnapInfo merge(CountryPhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PhoneSnapVisitorCountryPhone());
	}
	
	
	
	public List<PhoneSnapInfo> merge(List<CountryPhoneInfo> sourceOnes, List<PhoneSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PhoneSnapVisitorCountryPhone());
	}
}
