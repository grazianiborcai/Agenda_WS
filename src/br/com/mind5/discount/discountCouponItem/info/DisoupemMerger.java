package br.com.mind5.discount.discountCouponItem.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class DisoupemMerger {
	public static List<DisoupemInfo> mergeWithDisegy(List<DisoupemInfo> baseInfos, List<DisegyInfo> selectedInfos) {
		InfoMergerBuilder<DisoupemInfo, DisegyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoupemVisiMergeDisegy());
		InfoMerger<DisoupemInfo, DisegyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoupemInfo> mergeWithUsername(List<DisoupemInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<DisoupemInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoupemVisiMergeUsername());
		InfoMerger<DisoupemInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoupemInfo> mergeToSelect(List<DisoupemInfo> baseInfos, List<DisoupemInfo> selectedInfos) {
		InfoMergerBuilder<DisoupemInfo, DisoupemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoupemVisiMergeToSelect());
		InfoMerger<DisoupemInfo, DisoupemInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
