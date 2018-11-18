package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.info.InfoMerger;

final class PhoneMergerCountryPhone extends InfoMerger<PhoneInfo, CountryPhoneInfo, PhoneInfo> {
	public PhoneInfo merge(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PhoneVisitorCountryPhone());
	}
	
	
	
	public List<PhoneInfo> merge(List<CountryPhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PhoneVisitorCountryPhone());
	}
}
