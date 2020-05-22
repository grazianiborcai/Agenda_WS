package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class TokemoipMerger {	
	public static TokemoipInfo mergeWithSysenv(SysenvInfo sourceOne, TokemoipInfo sourceTwo) {
		InfoMerger_<TokemoipInfo, SysenvInfo> merger = new TokemoipMergerSysenv();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TokemoipInfo> mergeWithSysenv(List<SysenvInfo> sourceOnes, List<TokemoipInfo> sourceTwos) {
		InfoMerger_<TokemoipInfo, SysenvInfo> merger = new TokemoipMergerSysenv();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static TokemoipInfo mergeWithSetupar(SetuparInfo sourceOne, TokemoipInfo sourceTwo) {
		InfoMerger_<TokemoipInfo, SetuparInfo> merger = new TokemoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TokemoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<TokemoipInfo> sourceTwos) {
		InfoMerger_<TokemoipInfo, SetuparInfo> merger = new TokemoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static TokemoipInfo mergeWithSyspar(SysparInfo sourceOne, TokemoipInfo sourceTwo) {
		InfoMerger_<TokemoipInfo, SysparInfo> merger = new TokemoipMergerSyspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<TokemoipInfo> mergeWithSyspar(List<SysparInfo> sourceOnes, List<TokemoipInfo> sourceTwos) {
		InfoMerger_<TokemoipInfo, SysparInfo> merger = new TokemoipMergerSyspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
