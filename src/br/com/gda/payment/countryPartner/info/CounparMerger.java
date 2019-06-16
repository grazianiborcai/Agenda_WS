package br.com.gda.payment.countryPartner.info;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.obsolete.InfoWritterFactory_;

public final class CounparMerger extends InfoWritterFactory_<CounparInfo> {	
	
	public CounparMerger() {
		super(new CounparUniquifier());
	}
	
	
	
	static public CounparInfo merge(PayparInfo sourceOne, CounparInfo sourceTwo) {
		return new CounparMergerPaypar().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<CounparInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof PayparInfo 		&&
			sourceTwos.get(0) instanceof CounparInfo		)
			return new CounparMergerPaypar().merge((List<PayparInfo>) sourceOnes, (List<CounparInfo>) sourceTwos);	
		
		return null;
	}
}
