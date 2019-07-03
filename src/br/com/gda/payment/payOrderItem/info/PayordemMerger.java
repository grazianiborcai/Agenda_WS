package br.com.gda.payment.payOrderItem.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class PayordemMerger {
	public static PayordemInfo mergeToSelect(PayordemInfo sourceOne, PayordemInfo sourceTwo) {
		InfoMerger<PayordemInfo, PayordemInfo> merger = new PayordemMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordemInfo> mergeToSelect(List<PayordemInfo> sourceOnes, List<PayordemInfo> sourceTwos) {
		InfoMerger<PayordemInfo, PayordemInfo> merger = new PayordemMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
