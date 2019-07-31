package br.com.gda.payment.partnerMoip.refundMoip.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class RefumoipMerger {
	public static RefumoipInfo mergeWithSetupar(SetuparInfo sourceOne, RefumoipInfo sourceTwo) {
		InfoMerger<RefumoipInfo, SetuparInfo> merger = new RefumoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefumoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<RefumoipInfo> sourceTwos) {
		InfoMerger<RefumoipInfo, SetuparInfo> merger = new RefumoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
