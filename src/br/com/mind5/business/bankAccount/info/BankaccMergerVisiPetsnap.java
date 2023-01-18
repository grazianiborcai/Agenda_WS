package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class BankaccMergerVisiPetsnap extends InfoMergerVisitorTemplate<BankaccInfo, PetsnapInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, PetsnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codBankAccount   == selectedInfo.codPet		);
	}
	
	

	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, PetsnapInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
