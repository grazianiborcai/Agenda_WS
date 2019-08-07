package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

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
