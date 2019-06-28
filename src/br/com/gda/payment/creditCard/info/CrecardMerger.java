package br.com.gda.payment.creditCard.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class CrecardMerger {
	public static CrecardInfo mergeWithCuspar(CusparInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, CusparInfo> merger = new CrecardMergerCuspar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithCuspar(List<CusparInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, CusparInfo> merger = new CrecardMergerCuspar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CrecardInfo mergeWithUsername(UsernameInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, UsernameInfo> merger = new CrecardMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, UsernameInfo> merger = new CrecardMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CrecardInfo mergeToSelect(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeToSelect(List<CrecardInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CrecardInfo mergeToDelete(CrecardInfo sourceOne, CrecardInfo sourceTwo) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CrecardInfo> mergeToDelete(List<CrecardInfo> sourceOnes, List<CrecardInfo> sourceTwos) {
		InfoMerger<CrecardInfo, CrecardInfo> merger = new CrecardMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
