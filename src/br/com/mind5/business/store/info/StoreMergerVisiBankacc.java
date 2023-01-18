package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerVisiBankacc extends InfoMergerVisitorTemplate<StoreInfo, BankaccInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, BankaccInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, BankaccInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.bankaccData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
