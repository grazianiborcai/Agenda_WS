package br.com.mind5.message.emailPasswordChange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userList.info.UselisInfo;

public final class EmordeMerger {
	public static List<EmordeInfo> mergeWithUselis(List<EmordeInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmordeInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmordeVisiMergeUselis());
		InfoMergerV3<EmordeInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
