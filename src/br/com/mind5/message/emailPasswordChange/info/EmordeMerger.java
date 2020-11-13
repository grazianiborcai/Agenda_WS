package br.com.mind5.message.emailPasswordChange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;

public final class EmordeMerger {
	public static List<EmordeInfo> mergeWithUselis(List<EmordeInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<EmordeInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmordeVisiMergeUselis());
		InfoMerger<EmordeInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
