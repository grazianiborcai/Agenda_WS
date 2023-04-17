package br.com.mind5.webhook.pagarmeHook.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.user.info.UserInfo;

public final class PagookMerger {	
	public static List<PagookInfo> mergeWithDaemon(List<PagookInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<PagookInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PagookMergerVisiDaemon());
		InfoMerger<PagookInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
