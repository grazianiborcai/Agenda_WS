package br.com.gda.payment.setupPartner.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.gda.payment.partnerMoip.refundMoip.info.RefumoipInfo;

public final class SetuparCopier {	
	public static SetuparInfo copyFromPaymoip(PaymoipInfo source) {
		InfoCopier<SetuparInfo, PaymoipInfo> copier = new SetuparCopyPaymoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromPaymoip(List<PaymoipInfo> sources) {
		InfoCopier<SetuparInfo, PaymoipInfo> copier = new SetuparCopyPaymoip();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static SetuparInfo copyFromCremoip(CremoipInfo source) {
		InfoCopier<SetuparInfo, CremoipInfo> copier = new SetuparCopyCremoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromCremoip(List<CremoipInfo> sources) {
		InfoCopier<SetuparInfo, CremoipInfo> copier = new SetuparCopyCremoip();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static SetuparInfo copyFromMultmoip(MultmoipInfo source) {
		InfoCopier<SetuparInfo, MultmoipInfo> copier = new SetuparCopyMultmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromMultmoip(List<MultmoipInfo> sources) {
		InfoCopier<SetuparInfo, MultmoipInfo> copier = new SetuparCopyMultmoip();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static SetuparInfo copyFromOrdmoip(OrdmoipInfo source) {
		InfoCopier<SetuparInfo, OrdmoipInfo> copier = new SetuparCopyOrdmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromOrdmoip(List<OrdmoipInfo> sources) {
		InfoCopier<SetuparInfo, OrdmoipInfo> copier = new SetuparCopyOrdmoip();
		return copier.makeCopy(sources);
	}		
	
	
	
	public static SetuparInfo copyFromRefumoip(RefumoipInfo source) {
		InfoCopier<SetuparInfo, RefumoipInfo> copier = new SetuparCopyRefumoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SetuparInfo> copyFromRefumoip(List<RefumoipInfo> sources) {
		InfoCopier<SetuparInfo, RefumoipInfo> copier = new SetuparCopyRefumoip();
		return copier.makeCopy(sources);
	}	
}
