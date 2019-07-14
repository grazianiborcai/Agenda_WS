package br.com.gda.payment.tokenMoip.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class TokemoipMerger {	
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
