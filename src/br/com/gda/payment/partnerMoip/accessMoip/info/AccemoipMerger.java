package br.com.gda.payment.partnerMoip.accessMoip.info;

import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.setupPartner.info.SetuparInfo;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class AccemoipMerger {
	public static AccemoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, AccemoipInfo sourceTwo) {
		InfoMerger<AccemoipInfo, SysEnvironInfo> merger = new AccemoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AccemoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<AccemoipInfo> sourceTwos) {
		InfoMerger<AccemoipInfo, SysEnvironInfo> merger = new AccemoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static AccemoipInfo mergeWithSetupar(SetuparInfo sourceOne, AccemoipInfo sourceTwo) {
		InfoMerger<AccemoipInfo, SetuparInfo> merger = new AccemoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AccemoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<AccemoipInfo> sourceTwos) {
		InfoMerger<AccemoipInfo, SetuparInfo> merger = new AccemoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static AccemoipInfo mergeWithSyspar(SysparInfo sourceOne, AccemoipInfo sourceTwo) {
		InfoMerger<AccemoipInfo, SysparInfo> merger = new AccemoipMergerSyspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AccemoipInfo> mergeWithSyspar(List<SysparInfo> sourceOnes, List<AccemoipInfo> sourceTwos) {
		InfoMerger<AccemoipInfo, SysparInfo> merger = new AccemoipMergerSyspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
