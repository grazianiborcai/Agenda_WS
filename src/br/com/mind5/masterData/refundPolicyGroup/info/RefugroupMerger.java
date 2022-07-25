package br.com.mind5.masterData.refundPolicyGroup.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.refundPolicyGroupItem.info.RefugritemInfo;
import br.com.mind5.masterData.refundPolicyGroupSearch.info.RefugrarchInfo;

public final class RefugroupMerger {
	public static List<RefugroupInfo> mergeWithRefugritem(List<RefugroupInfo> baseInfos, List<RefugritemInfo> selectedInfos) {
		InfoMergerBuilder<RefugroupInfo, RefugritemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefugroupMergerVisiRefugritem());
		InfoMerger<RefugroupInfo, RefugritemInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefugroupInfo> mergeWithRefugrarch(List<RefugroupInfo> baseInfos, List<RefugrarchInfo> selectedInfos) {
		InfoMergerBuilder<RefugroupInfo, RefugrarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefugroupMergerVisiRefugrarch());
		InfoMerger<RefugroupInfo, RefugrarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
