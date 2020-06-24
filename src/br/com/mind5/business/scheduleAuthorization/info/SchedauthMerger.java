package br.com.mind5.business.scheduleAuthorization.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class SchedauthMerger {
	public static List<SchedauthInfo> mergeWithUsername(List<SchedauthInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedauthInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedauthVisiMergeUsername());
		InfoMergerV3<SchedauthInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedauthInfo> mergeToSelect(List<SchedauthInfo> baseInfos, List<SchedauthInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedauthInfo, SchedauthInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedauthVisiMergeToSelect());
		InfoMergerV3<SchedauthInfo, SchedauthInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
