package br.com.mind5.security.userHome.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UsomeMerger {
	public static List<UsomeInfo> mergeWithUsername(List<UsomeInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<UsomeInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UsomeMergerVisiUsername());
		InfoMerger<UsomeInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UsomeInfo> mergeWithUselis(List<UsomeInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<UsomeInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UsomeMergerVisiUselis());
		InfoMerger<UsomeInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
