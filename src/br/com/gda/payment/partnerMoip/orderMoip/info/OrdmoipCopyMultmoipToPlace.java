package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class OrdmoipCopyMultmoipToPlace extends InfoCopierOneToManyTemplate<OrdmoipInfo, MultmoipInfo>{
	
	public OrdmoipCopyMultmoipToPlace() {
		super();
	}
	
	
	
	@Override protected List<OrdmoipInfo> makeCopyHook(MultmoipInfo source) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for(PayordemInfo eachPayordem : source.payordems) {
			OrdmoipInfo oneResult = new OrdmoipInfo();
			
			oneResult.codOwner = eachPayordem.codOwner;
			oneResult.itemNum = eachPayordem.codPayOrderItem;
			oneResult.codFeeCateg = source.codFeeCateg;
			oneResult.txtFeeCateg = source.txtFeeCateg;
			oneResult.payordemData = eachPayordem;
			oneResult.cusparData = source.cusparData;
			oneResult.sysparData = source.sysparData;		
			
			results.add(oneResult);
		}
		
		
		return results;
	}
}
