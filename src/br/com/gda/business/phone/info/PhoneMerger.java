package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.info.InfoMerger;

public final class PhoneMerger {
	public static PhoneInfo mergeWithCountryPhone(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger<PhoneInfo, CountryPhoneInfo> merger = new PhoneMergerCountryPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithCountryPhone(List<CountryPhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger<PhoneInfo, CountryPhoneInfo> merger = new PhoneMergerCountryPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeWithForm(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger<PhoneInfo, FormPhoneInfo> merger = new PhoneMergerForm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithForm(List<FormPhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger<PhoneInfo, FormPhoneInfo> merger = new PhoneMergerForm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeToDelete(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger<PhoneInfo, PhoneInfo> merger = new PhoneMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeToDelete(List<PhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger<PhoneInfo, PhoneInfo> merger = new PhoneMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeToSelect(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger<PhoneInfo, PhoneInfo> merger = new PhoneMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeToSelect(List<PhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger<PhoneInfo, PhoneInfo> merger = new PhoneMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
