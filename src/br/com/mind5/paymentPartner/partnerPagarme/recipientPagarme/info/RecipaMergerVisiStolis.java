package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class RecipaMergerVisiStolis extends InfoMergerVisitorTemplate<RecipaInfo, StolisInfo> {

	@Override public boolean shouldMerge(RecipaInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore);
	}
	
	
	
	@Override public List<RecipaInfo> merge(RecipaInfo baseInfo, StolisInfo selectedInfo) {
		List<RecipaInfo> results = new ArrayList<>();
		
		baseInfo.name     = getStoreName(selectedInfo);
		baseInfo.email    = getStoreEmail(selectedInfo);
		baseInfo.document = getStoreDocument(selectedInfo);
		baseInfo.code     = getStoreCode(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private String getStoreName(StolisInfo selectedInfo) {
		if (selectedInfo.complisData == null)
			return null;
		
		return selectedInfo.complisData.name;
	}
	
	
	
	private String getStoreEmail(StolisInfo selectedInfo) {
		if (selectedInfo.complisData == null)
			return null;
		
		return selectedInfo.complisData.email;
	}
	
	
	
	private String getStoreDocument(StolisInfo selectedInfo) {
		if (selectedInfo.complisData == null)
			return null;
		
		return selectedInfo.complisData.cnpj;
	}
	
	
	
	private String getStoreCode(StolisInfo selectedInfo) {
		return selectedInfo.codOwner + "-" + selectedInfo.codStore;
	}
}
