package br.com.mind5.payment.setupPartner.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class SetuparMerger {		
	public static SetuparInfo mergeWithPaypar(PayparInfo sourceOne, SetuparInfo sourceTwo) {
		InfoMerger_<SetuparInfo, PayparInfo> merger = new SetuparMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SetuparInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<SetuparInfo> sourceTwos) {
		InfoMerger_<SetuparInfo, PayparInfo> merger = new SetuparMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
