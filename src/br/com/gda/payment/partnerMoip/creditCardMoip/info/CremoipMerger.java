package br.com.gda.payment.partnerMoip.creditCardMoip.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

public final class CremoipMerger {
	public static CremoipInfo mergeWithSetupar(SetuparInfo sourceOne, CremoipInfo sourceTwo) {
		InfoMerger<CremoipInfo, SetuparInfo> merger = new CremoipMergerSetupar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CremoipInfo> mergeWithSetupar(List<SetuparInfo> sourceOnes, List<CremoipInfo> sourceTwos) {
		InfoMerger<CremoipInfo, SetuparInfo> merger = new CremoipMergerSetupar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
