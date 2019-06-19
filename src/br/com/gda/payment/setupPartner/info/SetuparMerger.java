package br.com.gda.payment.setupPartner.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMerger;

public final class SetuparMerger {		
	public static SetuparInfo mergeWithPaypar(PayparInfo sourceOne, SetuparInfo sourceTwo) {
		InfoMerger<SetuparInfo, PayparInfo> merger = new SetuparMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SetuparInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<SetuparInfo> sourceTwos) {
		InfoMerger<SetuparInfo, PayparInfo> merger = new SetuparMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
