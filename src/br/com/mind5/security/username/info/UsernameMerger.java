package br.com.mind5.security.username.info;

import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class UsernameMerger {
	public static List<UsernameInfo> mergeWithAuthGrRole(List<UsernameInfo> baseInfos, List<AuthGrRoleInfo> selectedInfos) {
		InfoMergerBuilderV3<UsernameInfo, AuthGrRoleInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UsernameVisiMergeAuthGrRole());
		InfoMergerV3<UsernameInfo, AuthGrRoleInfo> merger = builder.build();		
	
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
