package br.com.mind5.business.bookService.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class BookiceVisiMergeUsername implements InfoMergerVisitorV3<BookiceInfo, UsernameInfo> {
	
	@Override public List<BookiceInfo> beforeMerge(List<BookiceInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(BookiceInfo baseInfo, UsernameInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.username.equals(selectedInfo.username));
	}
	
	
	
	@Override public List<BookiceInfo> merge(BookiceInfo baseInfo, UsernameInfo selectedInfo) {
		List<BookiceInfo> results = new ArrayList<>();
		
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<BookiceInfo> getUniquifier() {
		return null;
	}
}