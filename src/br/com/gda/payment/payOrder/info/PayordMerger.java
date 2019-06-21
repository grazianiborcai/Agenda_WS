package br.com.gda.payment.payOrder.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class PayordMerger {	
	public static PayordInfo mergeWithPaypar(PayparInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, PayparInfo> merger = new PayordMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, PayparInfo> merger = new PayordMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeWithUsername(UsernameInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, UsernameInfo> merger = new PayordMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, UsernameInfo> merger = new PayordMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static PayordInfo mergeToSelect(PayordInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, PayordInfo> merger = new PayordMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeToSelect(List<PayordInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, PayordInfo> merger = new PayordMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static PayordInfo mergeToDelete(PayordInfo sourceOne, PayordInfo sourceTwo) {
		InfoMerger<PayordInfo, PayordInfo> merger = new PayordMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PayordInfo> mergeToDelete(List<PayordInfo> sourceOnes, List<PayordInfo> sourceTwos) {
		InfoMerger<PayordInfo, PayordInfo> merger = new PayordMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}			
}
