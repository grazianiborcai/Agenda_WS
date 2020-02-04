package br.com.mind5.payment.partnerMoip.multiPayMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class PaymoipMerger {
	public static PaymoipInfo mergeWithSetupar(SetuparInfo sourceOne, PaymoipInfo sourceTwo) {
		InfoMerger_<PaymoipInfo, SetuparInfo> merger = new PaymoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaymoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<PaymoipInfo> sourceTwos) {
		InfoMerger_<PaymoipInfo, SetuparInfo> merger = new PaymoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PaymoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, PaymoipInfo sourceTwo) {
		InfoMerger_<PaymoipInfo, SysEnvironInfo> merger = new PaymoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PaymoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<PaymoipInfo> sourceTwos) {
		InfoMerger_<PaymoipInfo, SysEnvironInfo> merger = new PaymoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
