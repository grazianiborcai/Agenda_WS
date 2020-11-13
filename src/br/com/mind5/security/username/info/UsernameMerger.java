package br.com.mind5.security.username.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public final class UsernameMerger {
	public static List<UsernameInfo> mergeWithAuthgrole(List<UsernameInfo> baseInfos, List<AuthgroleInfo> selectedInfos) {
		InfoMergerBuilder<UsernameInfo, AuthgroleInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UsernameVisiMergeAuthgrole());
		InfoMerger<UsernameInfo, AuthgroleInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UsernameInfo> mergeToSelect(List<UsernameInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<UsernameInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UsernameVisiMergeToSelect());
		InfoMerger<UsernameInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
