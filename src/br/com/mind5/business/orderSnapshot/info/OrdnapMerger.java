package br.com.mind5.business.orderSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userList.info.UselisInfo;

public final class OrdnapMerger {		
	public static List<OrdnapInfo> mergeWithCuslis(List<OrdnapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdnapInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdnapVisiMergeCuslis());
		InfoMergerV3<OrdnapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OrdnapInfo> mergeWithUselis(List<OrdnapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdnapInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdnapVisiMergeUselis());
		InfoMergerV3<OrdnapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdnapInfo> mergeToSelect(List<OrdnapInfo> baseInfos, List<OrdnapInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdnapInfo, OrdnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdnapVisiMergeToSelect());
		InfoMergerV3<OrdnapInfo, OrdnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
