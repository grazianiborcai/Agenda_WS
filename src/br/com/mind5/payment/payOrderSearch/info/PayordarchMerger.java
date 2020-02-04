package br.com.mind5.payment.payOrderSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class PayordarchMerger {	
	public static PayordarchInfo mergeToSelect(PayordarchInfo sourceOne, PayordarchInfo sourceTwo) {
		InfoMerger_<PayordarchInfo, PayordarchInfo> merger = new PayordarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordarchInfo> mergeToSelect(List<PayordarchInfo> sourceOnes, List<PayordarchInfo> sourceTwos) {
		InfoMerger_<PayordarchInfo, PayordarchInfo> merger = new PayordarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
