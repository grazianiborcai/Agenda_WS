package br.com.mind5.payment.storePartnerSnapshot.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class StoparnapMerger {	
	public static StoparnapInfo mergeWithPaypar(PayparInfo sourceOne, StoparnapInfo sourceTwo) {
		InfoMerger_<StoparnapInfo, PayparInfo> merger = new StoparnapMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparnapInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<StoparnapInfo> sourceTwos) {
		InfoMerger_<StoparnapInfo, PayparInfo> merger = new StoparnapMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoparnapInfo mergeToSelect(StoparnapInfo sourceOne, StoparnapInfo sourceTwo) {
		InfoMerger_<StoparnapInfo, StoparnapInfo> merger = new StoparnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparnapInfo> mergeToSelect(List<StoparnapInfo> sourceOnes, List<StoparnapInfo> sourceTwos) {
		InfoMerger_<StoparnapInfo, StoparnapInfo> merger = new StoparnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
}
