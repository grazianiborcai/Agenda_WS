package br.com.mind5.payment.statusPayOrderItem.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PaytusemMerger {	
	public static PaytusemInfo mergeWithPayordem(PayordemInfo sourceOne, PaytusemInfo sourceTwo) {
		InfoMerger_<PaytusemInfo, PayordemInfo> merger = new PaytusemMergerPayordem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusemInfo> mergeWithPayordem(List<PayordemInfo> sourceOnes, List<PaytusemInfo> sourceTwos) {
		InfoMerger_<PaytusemInfo, PayordemInfo> merger = new PaytusemMergerPayordem();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static PaytusemInfo mergeWithOrdmoip(OrdmoipInfo sourceOne, PaytusemInfo sourceTwo) {
		InfoMerger_<PaytusemInfo, OrdmoipInfo> merger = new PaytusemMergerOrdmoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaytusemInfo> mergeWithOrdmoip(List<OrdmoipInfo> sourceOnes, List<PaytusemInfo> sourceTwos) {
		InfoMerger_<PaytusemInfo, OrdmoipInfo> merger = new PaytusemMergerOrdmoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
