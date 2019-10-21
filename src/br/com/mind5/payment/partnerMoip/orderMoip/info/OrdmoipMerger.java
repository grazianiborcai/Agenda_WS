package br.com.mind5.payment.partnerMoip.orderMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class OrdmoipMerger {
	public static OrdmoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, OrdmoipInfo sourceTwo) {
		InfoMerger<OrdmoipInfo, SysEnvironInfo> merger = new OrdmoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<OrdmoipInfo> sourceTwos) {
		InfoMerger<OrdmoipInfo, SysEnvironInfo> merger = new OrdmoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdmoipInfo mergeWithSetupar(SetuparInfo sourceOne, OrdmoipInfo sourceTwo) {
		InfoMerger<OrdmoipInfo, SetuparInfo> merger = new OrdmoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<OrdmoipInfo> sourceTwos) {
		InfoMerger<OrdmoipInfo, SetuparInfo> merger = new OrdmoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
