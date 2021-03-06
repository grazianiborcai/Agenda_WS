package br.com.mind5.payment.storePartner.info;


import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StoparCopier {	
	public static StoparInfo copyFromOrdmoip(OrdmoipInfo source) {
		InfoCopier<StoparInfo, OrdmoipInfo> copier = new StoparCopyOrdmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoparInfo> copyFromOrdmoip(List<OrdmoipInfo> sources) {
		InfoCopier<StoparInfo, OrdmoipInfo> copier = new StoparCopyOrdmoip();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StoparInfo copyFromRefumoip(RefumoipInfo source) {
		InfoCopier<StoparInfo, RefumoipInfo> copier = new StoparCopyRefumoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoparInfo> copyFromRefumoip(List<RefumoipInfo> sources) {
		InfoCopier<StoparInfo, RefumoipInfo> copier = new StoparCopyRefumoip();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StoparInfo copyFromPlanata(PlanataInfo source) {
		InfoCopier<StoparInfo, PlanataInfo> copier = new StoparCopyPlanata();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoparInfo> copyFromPlanata(List<PlanataInfo> sources) {
		InfoCopier<StoparInfo, PlanataInfo> copier = new StoparCopyPlanata();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StoparInfo copyFromPeresmoip(PeresmoipInfo source) {
		InfoCopier<StoparInfo, PeresmoipInfo> copier = new StoparCopyPeresmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoparInfo> copyFromPeresmoip(List<PeresmoipInfo> sources) {
		InfoCopier<StoparInfo, PeresmoipInfo> copier = new StoparCopyPeresmoip();
		return copier.makeCopy(sources);
	}
}
