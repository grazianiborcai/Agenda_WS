package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.storePartner.info.StoparInfo;

public final class OrdmoipMerger {
	public static OrdmoipInfo mergeWithStopar(StoparInfo sourceOne, OrdmoipInfo sourceTwo) {
		InfoMerger<OrdmoipInfo, StoparInfo> merger = new OrdmoipMergerStopar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithStopar(List<StoparInfo> sourceOnes, List<OrdmoipInfo> sourceTwos) {
		InfoMerger<OrdmoipInfo, StoparInfo> merger = new OrdmoipMergerStopar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
