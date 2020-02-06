package br.com.mind5.business.orderListAuth.info;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrdistauMerger {	
	public static List<OrdistauInfo> mergeWithOrdist(List<OrdistauInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdistauInfo, OrdistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistauVisiMergeOrdist());
		InfoMergerV3<OrdistauInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdistauInfo> mergeWithUsername(List<OrdistauInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdistauInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdistauVisiMergeUsername());
		InfoMergerV3<OrdistauInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
