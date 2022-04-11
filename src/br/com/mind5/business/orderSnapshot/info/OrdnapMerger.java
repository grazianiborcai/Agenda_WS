package br.com.mind5.business.orderSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OrdnapMerger {	
	public static List<OrdnapInfo> mergeWithUselis(List<OrdnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<OrdnapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdnapMergerVisiUselis());
		InfoMerger<OrdnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdnapInfo> mergeToSelect(List<OrdnapInfo> baseInfos, List<OrdnapInfo> selectedInfos) {
		InfoMergerBuilder<OrdnapInfo, OrdnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdnapMergerVisiToSelect());
		InfoMerger<OrdnapInfo, OrdnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
