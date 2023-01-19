package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerVisiBankacc extends InfoMergerVisitorTemplate<StorapInfo, BankaccInfo> {

	@Override public boolean shouldMerge(StorapInfo baseInfo, BankaccInfo selectedInfo) {
		return (baseInfo.codOwner       == selectedInfo.codOwner	&&
				baseInfo.codBankAccount == selectedInfo.codBankAccount		);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, BankaccInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.codBankAccountSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StorapInfo> uniquifyHook(List<StorapInfo> results) {
		InfoUniquifier<StorapInfo> uniquifier = new StorapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
