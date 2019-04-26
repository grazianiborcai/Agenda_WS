package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.info.InfoMerger_;

final class PhoneMergerForm extends InfoMerger_<PhoneInfo, FormPhoneInfo, PhoneInfo> {
	public PhoneInfo merge(FormPhoneInfo sourceOne, PhoneInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PhoneVisitorForm());
	}
	
	
	
	public List<PhoneInfo> merge(List<FormPhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PhoneVisitorForm());
	}
}
