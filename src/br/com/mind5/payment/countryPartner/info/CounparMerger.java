package br.com.mind5.payment.countryPartner.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class CounparMerger {		
	public static CounparInfo mergeWithPaypar(PayparInfo sourceOne, CounparInfo sourceTwo) {
		InfoMerger_<CounparInfo, PayparInfo> merger = new CounparMergerPaypar();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CounparInfo> mergeWithPaypar(List<PayparInfo> sourceOnes, List<CounparInfo> sourceTwos) {
		InfoMerger_<CounparInfo, PayparInfo> merger = new CounparMergerPaypar();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
