package br.com.mind5.masterData.refundPolicyGroup.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;

public final class RefugroupMerger {
	public static List<RefugroupInfo> mergeWithRefugritem(List<RefugroupInfo> baseInfos, List<RefugritemInfo> selectedInfos) {
		InfoMergerBuilderV3<RefugroupInfo, RefugritemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefugroupVisiMergeRefugritem());
		InfoMergerV3<RefugroupInfo, RefugritemInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefugroupInfo> mergeWithRefugrarch(List<RefugroupInfo> baseInfos, List<RefugrarchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefugroupInfo, RefugrarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefugroupVisiMergeRefugrarch());
		InfoMergerV3<RefugroupInfo, RefugrarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
