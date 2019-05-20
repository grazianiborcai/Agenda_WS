package br.com.gda.business.phoneSnapshot.info;

import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.info.InfoMerger;

public final class PhonapMerger {
	public static PhonapInfo mergeWithCountryPhone(CountryPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger<PhonapInfo, CountryPhoneInfo> merger = new PhonapMergerCountryPhone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithCountryPhone(List<CountryPhoneInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger<PhonapInfo, CountryPhoneInfo> merger = new PhonapMergerCountryPhone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PhonapInfo mergeWithForm(FormPhoneInfo sourceOne, PhonapInfo sourceTwo) {
		InfoMerger<PhonapInfo, FormPhoneInfo> merger = new PhonapMergerForm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonapInfo> mergeWithForm(List<FormPhoneInfo> sourceOnes, List<PhonapInfo> sourceTwos) {
		InfoMerger<PhonapInfo, FormPhoneInfo> merger = new PhonapMergerForm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
