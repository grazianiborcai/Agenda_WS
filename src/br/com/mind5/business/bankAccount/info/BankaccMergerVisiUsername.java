package br.com.mind5.business.bankAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class BankaccMergerVisiUsername extends InfoMergerVisitorTemplate<BankaccInfo, UsernameInfo> {

	@Override public boolean shouldMerge(BankaccInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		&&
				baseInfo.username.equals(selectedInfo.username)		);
	}
	
	
	
	@Override public List<BankaccInfo> merge(BankaccInfo baseInfo, UsernameInfo selectedInfo) {
		List<BankaccInfo> results = new ArrayList<>();
		
		baseInfo.lastChangedBy = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
