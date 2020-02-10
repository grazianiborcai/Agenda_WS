package br.com.mind5.payment.storePartner.info;


import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StoparCopier {	
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
	
	
	
	public static StoparInfo copyFromPayordem(PayordemInfo source) {
		InfoCopier<StoparInfo, PayordemInfo> copier = new StoparCopyPayordem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StoparInfo> copyFromPayordem(List<PayordemInfo> sources) {
		InfoCopier<StoparInfo, PayordemInfo> copier = new StoparCopyPayordem();
		return copier.makeCopy(sources);
	}
}
