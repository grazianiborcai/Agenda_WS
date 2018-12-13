package br.com.gda.business.phoneSnapshot.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;

final class PhoneSnapMergerPhone extends InfoMerger<PhoneSnapInfo, PhoneInfo, PhoneSnapInfo> {
	public PhoneSnapInfo merge(PhoneInfo sourceOne, PhoneSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PhoneSnapVisitorPhone());
	}
	
	
	
	public List<PhoneSnapInfo> merge(List<PhoneInfo> sourceOnes, List<PhoneSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PhoneSnapVisitorPhone());
	}
}
