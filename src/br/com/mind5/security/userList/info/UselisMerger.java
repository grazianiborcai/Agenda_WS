package br.com.mind5.security.userList.info;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UselisMerger {
	public static List<UselisInfo> mergeWithUserarch(List<UselisInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilderV3<UselisInfo, UserarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UselisVisiMergeUserarch());
		InfoMergerV3<UselisInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UselisInfo> mergeWithPersolis(List<UselisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilderV3<UselisInfo, PersolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UselisVisiMergePersolis());
		InfoMergerV3<UselisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UselisInfo> mergeToSelect(List<UselisInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<UselisInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UselisVisiMergeToSelect());
		InfoMergerV3<UselisInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
