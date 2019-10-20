package br.com.gda.payment.storePartnerList.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMerger;

public final class StoplisMerger {		
	public static StoplisInfo mergeToSelect(StoplisInfo sourceOne, StoplisInfo sourceTwo) {
		InfoMerger<StoplisInfo, StoplisInfo> merger = new StoplisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoplisInfo> mergeToSelect(List<StoplisInfo> sourceOnes, List<StoplisInfo> sourceTwos) {
		InfoMerger<StoplisInfo, StoplisInfo> merger = new StoplisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoplisInfo mergeWithPaypar(PayparInfo sourceOne, StoplisInfo sourceTwo) {
		InfoMerger<StoplisInfo, PayparInfo> merger = new StoplisMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoplisInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<StoplisInfo> sourceTwos) {
		InfoMerger<StoplisInfo, PayparInfo> merger = new StoplisMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
