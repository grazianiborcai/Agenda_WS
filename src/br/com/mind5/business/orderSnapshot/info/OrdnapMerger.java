package br.com.mind5.business.orderSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OrdnapMerger {		
	public static List<OrdnapInfo> mergeWithCuslis(List<OrdnapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<OrdnapInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdnapVisiMergeCuslis());
		InfoMerger<OrdnapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OrdnapInfo> mergeWithUselis(List<OrdnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<OrdnapInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdnapVisiMergeUselis());
		InfoMerger<OrdnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdnapInfo> mergeToSelect(List<OrdnapInfo> baseInfos, List<OrdnapInfo> selectedInfos) {
		InfoMergerBuilder<OrdnapInfo, OrdnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdnapVisiMergeToSelect());
		InfoMerger<OrdnapInfo, OrdnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
