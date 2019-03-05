package br.com.gda.business.phone.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class PhoneMergerToDelete extends InfoMerger<PhoneInfo, PhoneInfo, PhoneInfo> {
	public PhoneInfo merge(PhoneInfo sourceOne, PhoneInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PhoneVisiMergeToDelete());
	}
	
	
	
	public List<PhoneInfo> merge(List<PhoneInfo> sourceOnes, List<PhoneInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PhoneVisiMergeToDelete());
	}
}
