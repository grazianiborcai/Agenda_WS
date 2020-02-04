package br.com.mind5.payment.storePartner.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StoparMerger {	
	public static StoparInfo mergeWithStoparch(StoparchInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger_<StoparInfo, StoparchInfo> merger = new StoparMergerStoparch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeWithStoparch(List<StoparchInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger_<StoparInfo, StoparchInfo> merger = new StoparMergerStoparch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoparInfo mergeWithPaypar(PayparInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger_<StoparInfo, PayparInfo> merger = new StoparMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger_<StoparInfo, PayparInfo> merger = new StoparMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StoparInfo mergeWithStoparnap(StoparnapInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger_<StoparInfo, StoparnapInfo> merger = new StoparMergerStoparnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeWithStoparnap(List<StoparnapInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger_<StoparInfo, StoparnapInfo> merger = new StoparMergerStoparnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoparInfo mergeWithUsername(UsernameInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger_<StoparInfo, UsernameInfo> merger = new StoparMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger_<StoparInfo, UsernameInfo> merger = new StoparMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StoparInfo mergeToSelect(StoparInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger_<StoparInfo, StoparInfo> merger = new StoparMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeToSelect(List<StoparInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger_<StoparInfo, StoparInfo> merger = new StoparMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static StoparInfo mergeToDelete(StoparInfo sourceOne, StoparInfo sourceTwo) {
		InfoMerger_<StoparInfo, StoparInfo> merger = new StoparMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StoparInfo> mergeToDelete(List<StoparInfo> sourceOnes, List<StoparInfo> sourceTwos) {
		InfoMerger_<StoparInfo, StoparInfo> merger = new StoparMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
}
