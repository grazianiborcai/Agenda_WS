package br.com.gda.payService.payPartnerOwner.info;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;

public final class PayparOwnerMerger extends InfoWritterFactory<PayparOwnerInfo> {	
	
	public PayparOwnerMerger() {
		super(new PayparOwnerUniquifier());
	}
	
	
	
	static public PayparOwnerInfo merge(OwnerInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return new PayparOwnerMergerOwner().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PayparOwnerInfo merge(PayparCountryInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return new PayparOwnerMergerPayparCountry().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PayparOwnerInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {
		if (sourceOnes.get(0) instanceof OwnerInfo 			&&
			sourceTwos.get(0) instanceof PayparOwnerInfo		)
			return new PayparOwnerMergerOwner().merge((List<OwnerInfo>) sourceOnes, (List<PayparOwnerInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PayparCountryInfo 	&&
			sourceTwos.get(0) instanceof PayparOwnerInfo		)
			return new PayparOwnerMergerPayparCountry().merge((List<PayparCountryInfo>) sourceOnes, (List<PayparOwnerInfo>) sourceTwos);
		
		return null;
	}
}
