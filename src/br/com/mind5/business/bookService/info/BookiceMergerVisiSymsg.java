package br.com.mind5.business.bookService.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

final class BookiceMergerVisiSymsg extends InfoMergerVisitorTemplate<BookiceInfo, SymsgInfo> {

	@Override public boolean shouldMerge(BookiceInfo baseInfo, SymsgInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<BookiceInfo> merge(BookiceInfo baseInfo, SymsgInfo selectedInfo) {
		List<BookiceInfo> results = new ArrayList<>();
		
		baseInfo.symsgData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
