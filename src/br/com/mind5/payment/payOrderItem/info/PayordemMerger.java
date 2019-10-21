package br.com.mind5.payment.payOrderItem.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class PayordemMerger {
	public static PayordemInfo mergeWithStopar(StoparInfo sourceOne, PayordemInfo sourceTwo) {
		InfoMerger<PayordemInfo, StoparInfo> merger = new PayordemMergerStopar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordemInfo> mergeWithStopar(List<StoparInfo> sourceOnes, List<PayordemInfo> sourceTwos) {
		InfoMerger<PayordemInfo, StoparInfo> merger = new PayordemMergerStopar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PayordemInfo mergeToSelect(PayordemInfo sourceOne, PayordemInfo sourceTwo) {
		InfoMerger<PayordemInfo, PayordemInfo> merger = new PayordemMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordemInfo> mergeToSelect(List<PayordemInfo> sourceOnes, List<PayordemInfo> sourceTwos) {
		InfoMerger<PayordemInfo, PayordemInfo> merger = new PayordemMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordemInfo mergeToUpdate(PayordemInfo sourceOne, PayordemInfo sourceTwo) {
		InfoMerger<PayordemInfo, PayordemInfo> merger = new PayordemMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordemInfo> mergeToUpdate(List<PayordemInfo> sourceOnes, List<PayordemInfo> sourceTwos) {
		InfoMerger<PayordemInfo, PayordemInfo> merger = new PayordemMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordemInfo mergeToUpdateStatus(PayordemInfo sourceOne, PayordemInfo sourceTwo) {
		InfoMerger<PayordemInfo, PayordemInfo> merger = new PayordemMergerToUpdateStatus();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordemInfo> mergeToUpdateStatus(List<PayordemInfo> sourceOnes, List<PayordemInfo> sourceTwos) {
		InfoMerger<PayordemInfo, PayordemInfo> merger = new PayordemMergerToUpdateStatus();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
