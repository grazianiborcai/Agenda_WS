package br.com.mind5.payment.partnerMoip.tokenMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class TokemoipMerger {	
	public static TokemoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, TokemoipInfo sourceTwo) {
		InfoMerger<TokemoipInfo, SysEnvironInfo> merger = new TokemoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TokemoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<TokemoipInfo> sourceTwos) {
		InfoMerger<TokemoipInfo, SysEnvironInfo> merger = new TokemoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static TokemoipInfo mergeWithSetupar(SetuparInfo sourceOne, TokemoipInfo sourceTwo) {
		InfoMerger<TokemoipInfo, SetuparInfo> merger = new TokemoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TokemoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<TokemoipInfo> sourceTwos) {
		InfoMerger<TokemoipInfo, SetuparInfo> merger = new TokemoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static TokemoipInfo mergeWithSyspar(SysparInfo sourceOne, TokemoipInfo sourceTwo) {
		InfoMerger<TokemoipInfo, SysparInfo> merger = new TokemoipMergerSyspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TokemoipInfo> mergeWithSyspar(List<SysparInfo> sourceOnes, List<TokemoipInfo> sourceTwos) {
		InfoMerger<TokemoipInfo, SysparInfo> merger = new TokemoipMergerSyspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
