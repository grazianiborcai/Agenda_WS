package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.info.InfoWritterFactory;

public final class PhoneMerger extends InfoWritterFactory<PhoneInfo> {	
	
	public PhoneMerger() {
		super(new PhoneUniquifier());
	}
	
	
	
	static public PhoneInfo merge(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		return new PhoneMergerForm().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PhoneInfo merge(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		return new PhoneMergerCountryPhone().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PhoneInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {				
		if (sourceOnes.get(0) instanceof FormPhoneInfo 	&&
			sourceTwos.get(0) instanceof PhoneInfo		)
			return new PhoneMergerForm().merge((List<FormPhoneInfo>) sourceOnes, (List<PhoneInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CountryPhoneInfo 	&&
			sourceTwos.get(0) instanceof PhoneInfo		)
			return new PhoneMergerCountryPhone().merge((List<CountryPhoneInfo>) sourceOnes, (List<PhoneInfo>) sourceTwos);
		
		
		return null;
	}
}
