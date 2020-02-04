package br.com.mind5.payment.partnerMoip.creditCardMoip.info;

import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class CremoipMerger {
	public static CremoipInfo mergeWithSysEnviron(SysEnvironInfo sourceOne, CremoipInfo sourceTwo) {
		InfoMerger_<CremoipInfo, SysEnvironInfo> merger = new CremoipMergerSysEnviron();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CremoipInfo> mergeWithSysEnviron(List<SysEnvironInfo> sourceOnes, List<CremoipInfo> sourceTwos) {
		InfoMerger_<CremoipInfo, SysEnvironInfo> merger = new CremoipMergerSysEnviron();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CremoipInfo mergeWithSetupar(SetuparInfo sourceOne, CremoipInfo sourceTwo) {
		InfoMerger_<CremoipInfo, SetuparInfo> merger = new CremoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CremoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<CremoipInfo> sourceTwos) {
		InfoMerger_<CremoipInfo, SetuparInfo> merger = new CremoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
