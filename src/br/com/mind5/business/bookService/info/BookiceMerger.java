package br.com.mind5.business.bookService.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class BookiceMerger {
	public static List<BookiceInfo> mergeWithUsername(List<BookiceInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<BookiceInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BookiceMergeVisiUsername());
		InfoMerger<BookiceInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BookiceInfo> mergeWithSymsg(List<BookiceInfo> baseInfos, List<SymsgInfo> selectedInfos) {
		InfoMergerBuilder<BookiceInfo, SymsgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BookiceMergerVisiSymsg());
		InfoMerger<BookiceInfo, SymsgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
