package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

final class PayordMergerVisiCuspar extends InfoMergerVisitorTemplate<PayordInfo, CusparInfo> {

	@Override public boolean shouldMerge(PayordInfo baseInfo, CusparInfo selectedInfo) {
		return (baseInfo.codOwner       == selectedInfo.codOwner &&
				baseInfo.codPayCustomer == selectedInfo.codPayCustomer);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, CusparInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.cusparData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PayordInfo> uniquifyHook(List<PayordInfo> results) {
		InfoUniquifier<PayordInfo> uniquifier = new PayordUniquifier();		
		return uniquifier.uniquify(results);
	}
}
