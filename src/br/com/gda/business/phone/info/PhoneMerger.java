package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.phoneSearch.info.PhonarchInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class PhoneMerger {
	public static PhoneInfo mergeWithPhonarch(PhonarchInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger<PhoneInfo, PhonarchInfo> merger = new PhoneMergerPhonarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonarch(List<PhonarchInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger<PhoneInfo, PhonarchInfo> merger = new PhoneMergerPhonarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeWithUsername(UsernameInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger<PhoneInfo, UsernameInfo> merger = new PhoneMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger<PhoneInfo, UsernameInfo> merger = new PhoneMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
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
	
	
	
	public static PhoneInfo mergeWithPhonap(PhonapInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger<PhoneInfo, PhonapInfo> merger = new PhoneMergerPhonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonap(List<PhonapInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger<PhoneInfo, PhonapInfo> merger = new PhoneMergerPhonap();		
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
	
	
	
	public static PhoneInfo mergeToUpdate(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger<PhoneInfo, PhoneInfo> merger = new PhoneMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeToUpdate(List<PhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger<PhoneInfo, PhoneInfo> merger = new PhoneMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
