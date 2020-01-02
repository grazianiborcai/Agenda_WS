package br.com.mind5.business.planingData.info;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.info.InfoPruner;
import br.com.mind5.info.InfoPrunerBuilder;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class PlanataPruner {
	public static List<PlanataInfo> pruneWithStopar(List<PlanataInfo> baseInfos, List<StoparInfo> selectedInfos) {
		InfoPrunerBuilder<PlanataInfo, StoparInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiPruneStopar());
		InfoPruner<PlanataInfo, StoparInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
	
	
	
	public static List<PlanataInfo> pruneWithEmplate(List<PlanataInfo> baseInfos, List<EmplateInfo> selectedInfos) {
		InfoPrunerBuilder<PlanataInfo, EmplateInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiPruneEmplate());
		InfoPruner<PlanataInfo, EmplateInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
	
	
	
	public static List<PlanataInfo> pruneWithStolate(List<PlanataInfo> baseInfos, List<StolateInfo> selectedInfos) {
		InfoPrunerBuilder<PlanataInfo, StolateInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiPruneStolate());
		InfoPruner<PlanataInfo, StolateInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
	
	
	
	public static List<PlanataInfo> pruneAged(List<PlanataInfo> baseInfos) {
		InfoPrunerBuilder<PlanataInfo, PlanataInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(baseInfos);
		builder.addVisitor(new PlanataVisiPruneAged());
		InfoPruner<PlanataInfo, PlanataInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
	
	
	
	public static List<PlanataInfo> pruneWithCarterve(List<PlanataInfo> baseInfos, List<CarterveInfo> selectedInfos) {
		InfoPrunerBuilder<PlanataInfo, CarterveInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiPruneCarterve());
		InfoPruner<PlanataInfo, CarterveInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
	
	
	
	public static List<PlanataInfo> pruneWithOrderve(List<PlanataInfo> baseInfos, List<OrderveInfo> selectedInfos) {
		InfoPrunerBuilder<PlanataInfo, OrderveInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PlanataVisiPruneOrderve());
		InfoPruner<PlanataInfo, OrderveInfo> pruner = builder.build();		
	
		return pruner.prune();
	}	
}
