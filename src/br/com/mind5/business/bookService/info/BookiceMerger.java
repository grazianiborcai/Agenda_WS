package br.com.mind5.business.bookService.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class BookiceMerger {
	public static List<BookiceInfo> mergeWithUsername(List<BookiceInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<BookiceInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BookiceVisiMergeUsername());
		InfoMergerV3<BookiceInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BookiceInfo> mergeWithSymsg(List<BookiceInfo> baseInfos, List<SymsgInfo> selectedInfos) {
		InfoMergerBuilderV3<BookiceInfo, SymsgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BookiceVisiMergeSymsg());
		InfoMergerV3<BookiceInfo, SymsgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
