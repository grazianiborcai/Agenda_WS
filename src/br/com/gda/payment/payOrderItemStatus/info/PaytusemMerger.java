package br.com.gda.payment.payOrderItemStatus.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class PaytusemMerger {	
	public static PaytusemInfo mergeWithPayordem(PayordemInfo sourceOne, PaytusemInfo sourceTwo) {
		InfoMerger<PaytusemInfo, PayordemInfo> merger = new PaytusemMergerPayordem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusemInfo> mergeWithPayordem(List<PayordemInfo> sourceOnes, List<PaytusemInfo> sourceTwos) {
		InfoMerger<PaytusemInfo, PayordemInfo> merger = new PaytusemMergerPayordem();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
