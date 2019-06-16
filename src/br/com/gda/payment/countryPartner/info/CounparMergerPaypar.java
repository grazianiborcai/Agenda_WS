package br.com.gda.payment.countryPartner.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class CounparMergerPaypar extends InfoMerger_<CounparInfo, PayparInfo, CounparInfo> {
	public CounparInfo merge(PayparInfo sourceOne, CounparInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CounparVisiMergePaypar());
	}
	
	
	
	public List<CounparInfo> merge(List<PayparInfo> sourceOnes, List<CounparInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CounparVisiMergePaypar());
	}
}
