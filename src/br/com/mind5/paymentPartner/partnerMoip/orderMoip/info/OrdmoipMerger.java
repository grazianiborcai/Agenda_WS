package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class OrdmoipMerger {
	public static OrdmoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, OrdmoipInfo sourceTwo) {
		InfoMerger_<OrdmoipInfo, SysEnvironInfo> merger = new OrdmoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<OrdmoipInfo> sourceTwos) {
		InfoMerger_<OrdmoipInfo, SysEnvironInfo> merger = new OrdmoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdmoipInfo mergeWithSetupar(SetuparInfo sourceOne, OrdmoipInfo sourceTwo) {
		InfoMerger_<OrdmoipInfo, SetuparInfo> merger = new OrdmoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdmoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<OrdmoipInfo> sourceTwos) {
		InfoMerger_<OrdmoipInfo, SetuparInfo> merger = new OrdmoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
