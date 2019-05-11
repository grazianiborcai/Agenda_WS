package br.com.gda.business.phoneSnapshot.info;

import java.util.List;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PhoneSnapMergerForm extends InfoMerger_<PhoneSnapInfo, FormPhoneInfo, PhoneSnapInfo> {
	public PhoneSnapInfo merge(FormPhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PhoneSnapVisitorForm());
	}
	
	
	
	public List<PhoneSnapInfo> merge(List<FormPhoneInfo> sourceOnes, List<PhoneSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PhoneSnapVisitorForm());
	}
}
