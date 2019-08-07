package br.com.gda.payment.partnerMoip.creditCardMoip.info;

import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class CremoipMerger {
	public static CremoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, CremoipInfo sourceTwo) {
		InfoMerger<CremoipInfo, SysEnvironInfo> merger = new CremoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CremoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<CremoipInfo> sourceTwos) {
		InfoMerger<CremoipInfo, SysEnvironInfo> merger = new CremoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CremoipInfo mergeWithSetupar(SetuparInfo sourceOne, CremoipInfo sourceTwo) {
		InfoMerger<CremoipInfo, SetuparInfo> merger = new CremoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CremoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<CremoipInfo> sourceTwos) {
		InfoMerger<CremoipInfo, SetuparInfo> merger = new CremoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
