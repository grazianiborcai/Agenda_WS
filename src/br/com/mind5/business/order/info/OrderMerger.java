package br.com.mind5.business.order.info;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrderMerger {	
	public static List<OrderInfo> mergeWithOrdarch(List<OrderInfo> baseInfos, List<OrdarchInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, OrdarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrdarch());
		InfoMergerV3<OrderInfo, OrdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithCus(List<OrderInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, CusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeCus());
		InfoMergerV3<OrderInfo, CusInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithOrdnap(List<OrderInfo> baseInfos, List<OrdnapInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, OrdnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrdnap());
		InfoMergerV3<OrderInfo, OrdnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithCusarch(List<OrderInfo> baseInfos, List<CusarchInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, CusarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeCusarch());
		InfoMergerV3<OrderInfo, CusarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithPayord(List<OrderInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, PayordInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergePayord());
		InfoMergerV3<OrderInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderInfo> mergeWithFeeCateg(List<OrderInfo> baseInfos, List<FeeCategInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, FeeCategInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeFeeCateg());
		InfoMergerV3<OrderInfo, FeeCategInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithCurrency(List<OrderInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, CurrencyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeCurrency());
		InfoMergerV3<OrderInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrderInfo> mergeWithOrderem(List<OrderInfo> baseInfos, List<OrderemInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, OrderemInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrderem());
		InfoMergerV3<OrderInfo, OrderemInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithOrderStatus(List<OrderInfo> baseInfos, List<OrderStatusInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, OrderStatusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeOrderStatus());
		InfoMergerV3<OrderInfo, OrderStatusInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeWithUsername(List<OrderInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeUsername());
		InfoMergerV3<OrderInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeToSelect(List<OrderInfo> baseInfos, List<OrderInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, OrderInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeToSelect());
		InfoMergerV3<OrderInfo, OrderInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrderInfo> mergeToUpdate(List<OrderInfo> baseInfos, List<OrderInfo> selectedInfos) {
		InfoMergerBuilderV3<OrderInfo, OrderInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrderVisiMergeToUpdate());
		InfoMergerV3<OrderInfo, OrderInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
