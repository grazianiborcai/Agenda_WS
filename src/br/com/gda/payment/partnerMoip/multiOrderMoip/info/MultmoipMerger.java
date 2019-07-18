package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class MultmoipMerger {
	public static MultmoipInfo mergeWithOrdmoip(OrdmoipInfo sourceOne, MultmoipInfo sourceTwo) {
		InfoMerger<MultmoipInfo, OrdmoipInfo> merger = new MultmoipMergerOrdmoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MultmoipInfo> mergeWithOrdmoip(List<OrdmoipInfo> sourceOnes, List<MultmoipInfo> sourceTwos) {
		InfoMerger<MultmoipInfo, OrdmoipInfo> merger = new MultmoipMergerOrdmoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
