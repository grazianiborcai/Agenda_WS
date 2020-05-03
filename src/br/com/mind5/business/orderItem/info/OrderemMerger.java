package br.com.mind5.business.orderItem.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrderemMerger {
	public static List<OrderemInfo> mergeWithOrdemarch(List<OrderemInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, OrdemarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeOrdemarch());
		InfoMergerV3<OrderemInfo, OrdemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithOrdemrap(List<OrderemInfo> baseInfos, List<OrdemrapInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, OrdemrapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeOrdemrap());
		InfoMergerV3<OrderemInfo, OrdemrapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderemInfo> mergeWithUsername(List<OrderemInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeUsername());
		InfoMergerV3<OrderemInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithMatlis(List<OrderemInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeMatlis());
		InfoMergerV3<OrderemInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithEmplis(List<OrderemInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeEmplis());
		InfoMergerV3<OrderemInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithStolis(List<OrderemInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeStolis());
		InfoMergerV3<OrderemInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderemInfo> mergeWithMatore(List<OrderemInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, MatoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeMatore());
		InfoMergerV3<OrderemInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithWeekday(List<OrderemInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeWeekday());
		InfoMergerV3<OrderemInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OrderemInfo> mergeToSelect(List<OrderemInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderemInfo, OrderemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeToSelect());
		InfoMergerV3<OrderemInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
