package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class OrdmoipCopyMultmoipToRead extends InfoCopierOneToManyTemplate<OrdmoipInfo, MultmoipInfo>{
	
	public OrdmoipCopyMultmoipToRead() {
		super();
	}
	
	
	
	@Override protected List<OrdmoipInfo> makeCopyHook(MultmoipInfo source) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for(OrdmoipInfo eachOrdmoip : source.ordmoips) {
			OrdmoipInfo oneResult = eachOrdmoip;
			results.add(oneResult);
		}
		
		
		return results;
	}
}
