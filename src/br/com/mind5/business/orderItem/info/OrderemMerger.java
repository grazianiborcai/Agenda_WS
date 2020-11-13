package br.com.mind5.business.orderItem.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrderemMerger {
	public static List<OrderemInfo> mergeWithRefugroup(List<OrderemInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, RefugroupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeRefugroup());
		InfoMerger<OrderemInfo,RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithRefupore(List<OrderemInfo> baseInfos, List<RefuporeInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, RefuporeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeRefupore());
		InfoMerger<OrderemInfo,RefuporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderemInfo> mergeWithPayordem(List<OrderemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergePayordem());
		InfoMerger<OrderemInfo,PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithOrduge(List<OrderemInfo> baseInfos, List<OrdugeInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrdugeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeOrduge());
		InfoMerger<OrderemInfo,OrdugeInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithOrdemarch(List<OrderemInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrdemarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeOrdemarch());
		InfoMerger<OrderemInfo, OrdemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithOrdemrap(List<OrderemInfo> baseInfos, List<OrdemrapInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrdemrapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeOrdemrap());
		InfoMerger<OrderemInfo, OrdemrapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderemInfo> mergeWithUsername(List<OrderemInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeUsername());
		InfoMerger<OrderemInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithMatlis(List<OrderemInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeMatlis());
		InfoMerger<OrderemInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithEmplis(List<OrderemInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeEmplis());
		InfoMerger<OrderemInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithStolis(List<OrderemInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeStolis());
		InfoMerger<OrderemInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderemInfo> mergeWithMatore(List<OrderemInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeMatore());
		InfoMerger<OrderemInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithWeekday(List<OrderemInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeWeekday());
		InfoMerger<OrderemInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OrderemInfo> mergeToSelect(List<OrderemInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrderemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeToSelect());
		InfoMerger<OrderemInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeToUpdate(List<OrderemInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrderemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemVisiMergeToUpdate());
		InfoMerger<OrderemInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
