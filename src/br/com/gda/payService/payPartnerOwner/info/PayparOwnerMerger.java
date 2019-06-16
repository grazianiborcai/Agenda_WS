package br.com.gda.payService.payPartnerOwner.info;

import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.payment.countryPartner.info.CounparInfo;

public final class PayparOwnerMerger extends InfoWritterFactory_<PayparOwnerInfo> {	
	
	public PayparOwnerMerger() {
		super(new PayparOwnerUniquifier());
	}
	
	
	
	static public PayparOwnerInfo merge(OwnerInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return new PayparOwnerMergerOwner().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PayparOwnerInfo merge(CounparInfo sourceOne, PayparOwnerInfo sourceTwo) {
		return new PayparOwnerMergerPayparCountry().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PayparOwnerInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {
		if (sourceOnes.get(0) instanceof OwnerInfo 			&&
			sourceTwos.get(0) instanceof PayparOwnerInfo		)
			return new PayparOwnerMergerOwner().merge((List<OwnerInfo>) sourceOnes, (List<PayparOwnerInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof CounparInfo 	&&
			sourceTwos.get(0) instanceof PayparOwnerInfo		)
			return new PayparOwnerMergerPayparCountry().merge((List<CounparInfo>) sourceOnes, (List<PayparOwnerInfo>) sourceTwos);
		
		return null;
	}
}
