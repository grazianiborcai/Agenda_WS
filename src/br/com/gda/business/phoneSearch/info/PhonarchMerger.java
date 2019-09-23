package br.com.gda.business.phoneSearch.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class PhonarchMerger {	
	public static PhonarchInfo mergeToSelect(PhonarchInfo sourceOne, PhonarchInfo sourceTwo) {
		InfoMerger<PhonarchInfo, PhonarchInfo> merger = new PhonarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PhonarchInfo> mergeToSelect(List<PhonarchInfo> sourceOnes, List<PhonarchInfo> sourceTwos) {
		InfoMerger<PhonarchInfo, PhonarchInfo> merger = new PhonarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
