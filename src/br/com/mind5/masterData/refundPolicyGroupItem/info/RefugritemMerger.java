package br.com.mind5.masterData.refundPolicyGroupItem.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;

public final class RefugritemMerger {
	public static List<RefugritemInfo> mergeWithRefupo(List<RefugritemInfo> baseInfos, List<RefupoInfo> selectedInfos) {
		InfoMergerBuilderV3<RefugritemInfo, RefupoInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefugritemVisiMergeRefupo());
		InfoMergerV3<RefugritemInfo, RefupoInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefugritemInfo> mergeWithRefugritarch(List<RefugritemInfo> baseInfos, List<RefugritarchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefugritemInfo, RefugritarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefugritemVisiMergeRefugritarch());
		InfoMergerV3<RefugritemInfo, RefugritarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
