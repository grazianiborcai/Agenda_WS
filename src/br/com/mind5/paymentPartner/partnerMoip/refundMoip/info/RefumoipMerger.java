package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class RefumoipMerger {
	public static RefumoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, RefumoipInfo sourceTwo) {
		InfoMerger_<RefumoipInfo, SysEnvironInfo> merger = new RefumoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefumoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<RefumoipInfo> sourceTwos) {
		InfoMerger_<RefumoipInfo, SysEnvironInfo> merger = new RefumoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static RefumoipInfo mergeWithSetupar(SetuparInfo sourceOne, RefumoipInfo sourceTwo) {
		InfoMerger_<RefumoipInfo, SetuparInfo> merger = new RefumoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefumoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<RefumoipInfo> sourceTwos) {
		InfoMerger_<RefumoipInfo, SetuparInfo> merger = new RefumoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static RefumoipInfo mergeWithStopar(StoparInfo sourceOne, RefumoipInfo sourceTwo) {
		InfoMerger_<RefumoipInfo, StoparInfo> merger = new RefumoipMergerStopar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<RefumoipInfo> mergeWithStopar(List<StoparInfo> sourceOnes, List<RefumoipInfo> sourceTwos) {
		InfoMerger_<RefumoipInfo, StoparInfo> merger = new RefumoipMergerStopar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
