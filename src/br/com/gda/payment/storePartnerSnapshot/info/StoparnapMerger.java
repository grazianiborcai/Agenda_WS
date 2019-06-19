package br.com.gda.payment.storePartnerSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMerger;

public final class StoparnapMerger {	
	public static StoparnapInfo mergeWithPaypar(PayparInfo sourceOne, StoparnapInfo sourceTwo) {
		InfoMerger<StoparnapInfo, PayparInfo> merger = new StoparnapMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparnapInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<StoparnapInfo> sourceTwos) {
		InfoMerger<StoparnapInfo, PayparInfo> merger = new StoparnapMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoparnapInfo mergeToSelect(StoparnapInfo sourceOne, StoparnapInfo sourceTwo) {
		InfoMerger<StoparnapInfo, StoparnapInfo> merger = new StoparnapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparnapInfo> mergeToSelect(List<StoparnapInfo> sourceOnes, List<StoparnapInfo> sourceTwos) {
		InfoMerger<StoparnapInfo, StoparnapInfo> merger = new StoparnapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
}
