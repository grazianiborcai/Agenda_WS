package br.com.mind5.business.order.info;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderStatusChange.info.OrdugeInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.currency.info.CurrencyInfo;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrderMerger {	
	public static List<OrderInfo> mergeWithOrduge(List<OrderInfo> baseInfos, List<OrdugeInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, OrdugeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrduge());
		InfoMerger<OrderInfo, OrdugeInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithRefupown(List<OrderInfo> baseInfos, List<RefupownInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, RefupownInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeRefupown());
		InfoMerger<OrderInfo, RefupownInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithRefugroup(List<OrderInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, RefugroupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeRefugroup());
		InfoMerger<OrderInfo, RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithOrdarch(List<OrderInfo> baseInfos, List<OrdarchInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, OrdarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrdarch());
		InfoMerger<OrderInfo, OrdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderInfo> mergeWithOrdnap(List<OrderInfo> baseInfos, List<OrdnapInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, OrdnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrdnap());
		InfoMerger<OrderInfo, OrdnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderInfo> mergeWithPayord(List<OrderInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, PayordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergePayord());
		InfoMerger<OrderInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderInfo> mergeWithFeecat(List<OrderInfo> baseInfos, List<FeecatInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, FeecatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeFeecat());
		InfoMerger<OrderInfo, FeecatInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithCurrency(List<OrderInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeCurrency());
		InfoMerger<OrderInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderInfo> mergeWithOrderem(List<OrderInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, OrderemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrderem());
		InfoMerger<OrderInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithOrderatus(List<OrderInfo> baseInfos, List<OrderatusInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, OrderatusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrderatus());
		InfoMerger<OrderInfo, OrderatusInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithUsername(List<OrderInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeUsername());
		InfoMerger<OrderInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeToSelect(List<OrderInfo> baseInfos, List<OrderInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, OrderInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeToSelect());
		InfoMerger<OrderInfo, OrderInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeToUpdate(List<OrderInfo> baseInfos, List<OrderInfo> selectedInfos) {
		InfoMergerBuilder<OrderInfo, OrderInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeToUpdate());
		InfoMerger<OrderInfo, OrderInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
