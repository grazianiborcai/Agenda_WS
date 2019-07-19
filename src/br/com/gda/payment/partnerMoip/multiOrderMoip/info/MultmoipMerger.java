package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class MultmoipMerger {
	public static MultmoipInfo mergeWithSetupar(SetuparInfo sourceOne, MultmoipInfo sourceTwo) {
		InfoMerger<MultmoipInfo, SetuparInfo> merger = new MultmoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MultmoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<MultmoipInfo> sourceTwos) {
		InfoMerger<MultmoipInfo, SetuparInfo> merger = new MultmoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static MultmoipInfo mergeWithOrdmoip(OrdmoipInfo sourceOne, MultmoipInfo sourceTwo) {
		InfoMerger<MultmoipInfo, OrdmoipInfo> merger = new MultmoipMergerOrdmoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MultmoipInfo> mergeWithOrdmoip(List<OrdmoipInfo> sourceOnes, List<MultmoipInfo> sourceTwos) {
		InfoMerger<MultmoipInfo, OrdmoipInfo> merger = new MultmoipMergerOrdmoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
