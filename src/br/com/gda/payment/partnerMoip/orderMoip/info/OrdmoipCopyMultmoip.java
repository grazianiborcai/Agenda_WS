package br.com.gda.payment.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;
import br.com.gda.info.InfoCopierOneToManyTemplate;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class OrdmoipCopyMultmoip extends InfoCopierOneToManyTemplate<OrdmoipInfo, MultmoipInfo>{
	
	public OrdmoipCopyMultmoip() {
		super();
	}
	
	
	
	@Override protected List<OrdmoipInfo> makeCopyHook(MultmoipInfo source) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		for(PayordemInfo eachPayordem : source.payordems) {
			OrdmoipInfo oneResult = new OrdmoipInfo();
			
			oneResult.feeReceiver = source.feeReceiver;
			oneResult.feeAmount = source.feeAmount;
			oneResult.codFeeCurrency = source.codFeeCurrency;
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
