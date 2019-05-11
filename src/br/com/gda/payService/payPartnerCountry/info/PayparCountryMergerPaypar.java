package br.com.gda.payService.payPartnerCountry.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PayparCountryMergerPaypar extends InfoMerger_<PayparCountryInfo, PayparInfo, PayparCountryInfo> {
	public PayparCountryInfo merge(PayparInfo sourceOne, PayparCountryInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayparCountryVisitorPaypar());
	}
	
	
	
	public List<PayparCountryInfo> merge(List<PayparInfo> sourceOnes, List<PayparCountryInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayparCountryVisitorPaypar());
	}
}
