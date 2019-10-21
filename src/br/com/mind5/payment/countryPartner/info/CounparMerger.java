package br.com.mind5.payment.countryPartner.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMerger;

public final class CounparMerger {		
	public static CounparInfo mergeWithPaypar(PayparInfo sourceOne, CounparInfo sourceTwo) {
		InfoMerger<CounparInfo, PayparInfo> merger = new CounparMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CounparInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<CounparInfo> sourceTwos) {
		InfoMerger<CounparInfo, PayparInfo> merger = new CounparMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
