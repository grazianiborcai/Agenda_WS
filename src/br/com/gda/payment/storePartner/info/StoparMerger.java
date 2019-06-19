package br.com.gda.payment.storePartner.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class StoparMerger {	
	public static StoparInfo mergeWithPaypar(PayparInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger<StoparInfo, PayparInfo> merger = new StoparMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger<StoparInfo, PayparInfo> merger = new StoparMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoparInfo mergeWithStoparnap(StoparnapInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger<StoparInfo, StoparnapInfo> merger = new StoparMergerStoparnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeWithStoparnap(List<StoparnapInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger<StoparInfo, StoparnapInfo> merger = new StoparMergerStoparnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoparInfo mergeWithUsername(UsernameInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger<StoparInfo, UsernameInfo> merger = new StoparMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger<StoparInfo, UsernameInfo> merger = new StoparMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoparInfo mergeToSelect(StoparInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger<StoparInfo, StoparInfo> merger = new StoparMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeToSelect(List<StoparInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger<StoparInfo, StoparInfo> merger = new StoparMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static StoparInfo mergeToDelete(StoparInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger<StoparInfo, StoparInfo> merger = new StoparMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeToDelete(List<StoparInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger<StoparInfo, StoparInfo> merger = new StoparMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
}
