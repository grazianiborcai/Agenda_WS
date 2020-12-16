package br.com.mind5.business.bookService.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.security.username.info.UsernameInfo;

final class BookiceVisiMergeUsername extends InfoMergerVisitorTemplate<BookiceInfo, UsernameInfo> {

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
}
