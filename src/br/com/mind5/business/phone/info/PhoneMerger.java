package br.com.mind5.business.phone.info;

import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class PhoneMerger {
	public static PhoneInfo mergeWithPhonarch(PhonarchInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger_<PhoneInfo, PhonarchInfo> merger = new PhoneMergerPhonarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonarch(List<PhonarchInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger_<PhoneInfo, PhonarchInfo> merger = new PhoneMergerPhonarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeWithUsername(UsernameInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger_<PhoneInfo, UsernameInfo> merger = new PhoneMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger_<PhoneInfo, UsernameInfo> merger = new PhoneMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeWithCountryPhone(CountryPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger_<PhoneInfo, CountryPhoneInfo> merger = new PhoneMergerCountryPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithCountryPhone(List<CountryPhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger_<PhoneInfo, CountryPhoneInfo> merger = new PhoneMergerCountryPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PhoneInfo mergeWithFormone(FormoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger_<PhoneInfo, FormoneInfo> merger = new PhoneMergerFormone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithFormone(List<FormoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger_<PhoneInfo, FormoneInfo> merger = new PhoneMergerFormone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeWithPhonap(PhonapInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger_<PhoneInfo, PhonapInfo> merger = new PhoneMergerPhonap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeWithPhonap(List<PhonapInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger_<PhoneInfo, PhonapInfo> merger = new PhoneMergerPhonap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PhoneInfo mergeToDelete(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger_<PhoneInfo, PhoneInfo> merger = new PhoneMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeToDelete(List<PhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger_<PhoneInfo, PhoneInfo> merger = new PhoneMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeToSelect(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger_<PhoneInfo, PhoneInfo> merger = new PhoneMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeToSelect(List<PhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger_<PhoneInfo, PhoneInfo> merger = new PhoneMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhoneInfo mergeToUpdate(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		InfoMerger_<PhoneInfo, PhoneInfo> merger = new PhoneMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhoneInfo> mergeToUpdate(List<PhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {
		InfoMerger_<PhoneInfo, PhoneInfo> merger = new PhoneMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
