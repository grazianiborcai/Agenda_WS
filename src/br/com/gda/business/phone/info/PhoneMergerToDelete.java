package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class PhoneMergerToDelete extends InfoMerger_<PhoneInfo, PhoneInfo, PhoneInfo> {
	public PhoneInfo merge(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PhoneVisiMergeToDelete());
	}
	
	
	
	public List<PhoneInfo> merge(List<PhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PhoneVisiMergeToDelete());
	}
}
