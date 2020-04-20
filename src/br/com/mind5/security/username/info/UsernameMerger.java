package br.com.mind5.security.username.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public final class UsernameMerger {
	public static List<UsernameInfo> mergeWithAuthgrole(List<UsernameInfo> baseInfos, List<AuthgroleInfo> selectedInfos) {
		InfoMergerBuilderV3<UsernameInfo, AuthgroleInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UsernameVisiMergeAuthgrole());
		InfoMergerV3<UsernameInfo, AuthgroleInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UsernameInfo> mergeToSelect(List<UsernameInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<UsernameInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UsernameVisiMergeToSelect());
		InfoMergerV3<UsernameInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
