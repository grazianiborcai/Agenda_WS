package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class MultmoipMerger {
	public static MultmoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, MultmoipInfo sourceTwo) {
		InfoMerger_<MultmoipInfo, SysEnvironInfo> merger = new MultmoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MultmoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<MultmoipInfo> sourceTwos) {
		InfoMerger_<MultmoipInfo, SysEnvironInfo> merger = new MultmoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static MultmoipInfo mergeWithSetupar(SetuparInfo sourceOne, MultmoipInfo sourceTwo) {
		InfoMerger_<MultmoipInfo, SetuparInfo> merger = new MultmoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MultmoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<MultmoipInfo> sourceTwos) {
		InfoMerger_<MultmoipInfo, SetuparInfo> merger = new MultmoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static MultmoipInfo mergeWithOrdmoip(OrdmoipInfo sourceOne, MultmoipInfo sourceTwo) {
		InfoMerger_<MultmoipInfo, OrdmoipInfo> merger = new MultmoipMergerOrdmoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MultmoipInfo> mergeWithOrdmoip(List<OrdmoipInfo> sourceOnes, List<MultmoipInfo> sourceTwos) {
		InfoMerger_<MultmoipInfo, OrdmoipInfo> merger = new MultmoipMergerOrdmoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static MultmoipInfo mergeWithPaymoip(PaymoipInfo sourceOne, MultmoipInfo sourceTwo) {
		InfoMerger_<MultmoipInfo, PaymoipInfo> merger = new MultmoipMergerPaymoip();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MultmoipInfo> mergeWithPaymoip(List<PaymoipInfo> sourceOnes, List<MultmoipInfo> sourceTwos) {
		InfoMerger_<MultmoipInfo, PaymoipInfo> merger = new MultmoipMergerPaymoip();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
