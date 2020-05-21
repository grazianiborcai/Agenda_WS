package br.com.mind5.business.bookService.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

final class BookiceVisiMergeSymsg implements InfoMergerVisitorV3<BookiceInfo, SymsgInfo> {
	
	@Override public List<BookiceInfo> beforeMerge(List<BookiceInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(BookiceInfo baseInfo, SymsgInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<BookiceInfo> merge(BookiceInfo baseInfo, SymsgInfo selectedInfo) {
		List<BookiceInfo> results = new ArrayList<>();
		
		baseInfo.symsgData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<BookiceInfo> getUniquifier() {
		return null;
	}
}
