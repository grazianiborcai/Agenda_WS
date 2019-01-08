package br.com.gda.payService.payPartnerCountry.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.info.InfoMerger;

final class PayPartnerCountryMergerPayPartner extends InfoMerger<PayPartnerCountryInfo, PayPartnerInfo, PayPartnerCountryInfo> {
	public PayPartnerCountryInfo merge(PayPartnerInfo sourceOne, PayPartnerCountryInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayPartnerCountryVisitorPayPartner());
	}
	
	
	
	public List<PayPartnerCountryInfo> merge(List<PayPartnerInfo> sourceOnes, List<PayPartnerCountryInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayPartnerCountryVisitorPayPartner());
	}
}
