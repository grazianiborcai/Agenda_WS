package br.com.mind5.paymentPartner.partnerMoip.accessMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class AccemoipMerger {
	public static AccemoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, AccemoipInfo sourceTwo) {
		InfoMerger_<AccemoipInfo, SysEnvironInfo> merger = new AccemoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AccemoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<AccemoipInfo> sourceTwos) {
		InfoMerger_<AccemoipInfo, SysEnvironInfo> merger = new AccemoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static AccemoipInfo mergeWithSetupar(SetuparInfo sourceOne, AccemoipInfo sourceTwo) {
		InfoMerger_<AccemoipInfo, SetuparInfo> merger = new AccemoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AccemoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<AccemoipInfo> sourceTwos) {
		InfoMerger_<AccemoipInfo, SetuparInfo> merger = new AccemoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static AccemoipInfo mergeWithSyspar(SysparInfo sourceOne, AccemoipInfo sourceTwo) {
		InfoMerger_<AccemoipInfo, SysparInfo> merger = new AccemoipMergerSyspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AccemoipInfo> mergeWithSyspar(List<SysparInfo> sourceOnes, List<AccemoipInfo> sourceTwos) {
		InfoMerger_<AccemoipInfo, SysparInfo> merger = new AccemoipMergerSyspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
