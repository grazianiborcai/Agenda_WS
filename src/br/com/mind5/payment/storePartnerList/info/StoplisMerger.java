package br.com.mind5.payment.storePartnerList.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StoplisMerger {		
	
	public static StoplisInfo mergeToSelect(StoplisInfo sourceOne, StoplisInfo sourceTwo) {
		InfoMerger_<StoplisInfo, StoplisInfo> merger = new StoplisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoplisInfo> mergeToSelect(List<StoplisInfo> sourceOnes, List<StoplisInfo> sourceTwos) {
		InfoMerger_<StoplisInfo, StoplisInfo> merger = new StoplisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoplisInfo mergeWithPaypar(PayparInfo sourceOne, StoplisInfo sourceTwo) {
		InfoMerger_<StoplisInfo, PayparInfo> merger = new StoplisMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoplisInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<StoplisInfo> sourceTwos) {
		InfoMerger_<StoplisInfo, PayparInfo> merger = new StoplisMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoplisInfo mergeWithStoparch(StoparchInfo sourceOne, StoplisInfo sourceTwo) {
		InfoMerger_<StoplisInfo, StoparchInfo> merger = new StoplisMergerStoparch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoplisInfo> mergeWithStoparch(List<StoparchInfo> sourceOnes, List<StoplisInfo> sourceTwos) {
		InfoMerger_<StoplisInfo, StoparchInfo> merger = new StoplisMergerStoparch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
