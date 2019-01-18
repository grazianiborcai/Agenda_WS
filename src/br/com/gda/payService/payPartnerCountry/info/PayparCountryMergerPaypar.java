package br.com.gda.payService.payPartnerCountry.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMerger;

final class PayparCountryMergerPaypar extends InfoMerger<PayparCountryInfo, PayparInfo, PayparCountryInfo> {
	public PayparCountryInfo merge(PayparInfo sourceOne, PayparCountryInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayparCountryVisitorPaypar());
	}
	
	
	
	public List<PayparCountryInfo> merge(List<PayparInfo> sourceOnes, List<PayparCountryInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayparCountryVisitorPaypar());
	}
}
