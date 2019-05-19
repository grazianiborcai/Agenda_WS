package br.com.gda.business.phoneSnapshot.info;

import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class PhoneSnapMerger extends InfoWritterFactory_<PhoneSnapInfo> {	
	
	public PhoneSnapMerger() {
		super(new PhoneSnapUniquifier());
	}
	
	
	
	static public PhoneSnapInfo merge(FormPhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return new PhoneSnapMergerForm().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PhoneSnapInfo merge(CountryPhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return new PhoneSnapMergerCountryPhone().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PhoneSnapInfo merge(PhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return new PhoneSnapMergerPhone().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PhoneSnapInfo merge(SnapInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return new PhoneSnapMergerSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PhoneSnapInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {				
		if (sourceOnes.get(0) instanceof FormPhoneInfo 	&&
			sourceTwos.get(0) instanceof PhoneSnapInfo		)
			return new PhoneSnapMergerForm().merge((List<FormPhoneInfo>) sourceOnes, (List<PhoneSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CountryPhoneInfo 	&&
			sourceTwos.get(0) instanceof PhoneSnapInfo		)
			return new PhoneSnapMergerCountryPhone().merge((List<CountryPhoneInfo>) sourceOnes, (List<PhoneSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PhoneInfo 	&&
			sourceTwos.get(0) instanceof PhoneSnapInfo		)
			return new PhoneSnapMergerPhone().merge((List<PhoneInfo>) sourceOnes, (List<PhoneSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof SnapInfo 	&&
			sourceTwos.get(0) instanceof PhoneSnapInfo		)
			return new PhoneSnapMergerSnap().merge((List<SnapInfo>) sourceOnes, (List<PhoneSnapInfo>) sourceTwos);
		
		
		return null;
	}
}
