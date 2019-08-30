package br.com.gda.payment.payOrderSearch.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class PayordarchMerger {	
	public static PayordarchInfo mergeToSelect(PayordarchInfo sourceOne, PayordarchInfo sourceTwo) {
		InfoMerger<PayordarchInfo, PayordarchInfo> merger = new PayordarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordarchInfo> mergeToSelect(List<PayordarchInfo> sourceOnes, List<PayordarchInfo> sourceTwos) {
		InfoMerger<PayordarchInfo, PayordarchInfo> merger = new PayordarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
