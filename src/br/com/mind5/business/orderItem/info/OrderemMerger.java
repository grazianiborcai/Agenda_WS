package br.com.mind5.business.orderItem.info;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrderemMerger {
	public static List<OrderemInfo> mergeWithOrdist(List<OrderemInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrdistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiOrdist());
		InfoMerger<OrderemInfo,OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithCus(List<OrderemInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, CusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiCus());
		InfoMerger<OrderemInfo,CusInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithCusarch(List<OrderemInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, CusarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiCusarch());
		InfoMerger<OrderemInfo,CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithRefugroup(List<OrderemInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, RefugroupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiRefugroup());
		InfoMerger<OrderemInfo,RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithRefupore(List<OrderemInfo> baseInfos, List<RefuporeInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, RefuporeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiRefupore());
		InfoMerger<OrderemInfo,RefuporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderemInfo> mergeWithPayordem(List<OrderemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiPayordem());
		InfoMerger<OrderemInfo,PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithOrduge(List<OrderemInfo> baseInfos, List<OrdugeInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrdugeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiOrduge());
		InfoMerger<OrderemInfo,OrdugeInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithOrdemarch(List<OrderemInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrdemarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiOrdemarch());
		InfoMerger<OrderemInfo, OrdemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithOrdemrap(List<OrderemInfo> baseInfos, List<OrdemrapInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrdemrapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiOrdemrap());
		InfoMerger<OrderemInfo, OrdemrapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderemInfo> mergeWithUsername(List<OrderemInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiUsername());
		InfoMerger<OrderemInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithMatlis(List<OrderemInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiMatlis());
		InfoMerger<OrderemInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithEmplres(List<OrderemInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiEmplres());
		InfoMerger<OrderemInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithStolis(List<OrderemInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiStolis());
		InfoMerger<OrderemInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderemInfo> mergeWithMatore(List<OrderemInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiMatore());
		InfoMerger<OrderemInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeWithWeekday(List<OrderemInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiWeekday());
		InfoMerger<OrderemInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OrderemInfo> mergeToSelect(List<OrderemInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrderemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiToSelect());
		InfoMerger<OrderemInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderemInfo> mergeToUpdate(List<OrderemInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilder<OrderemInfo, OrderemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderemMergerVisiToUpdate());
		InfoMerger<OrderemInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
