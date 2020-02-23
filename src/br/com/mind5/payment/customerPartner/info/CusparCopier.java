package br.com.mind5.payment.customerPartner.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class CusparCopier {	
	public static CusparInfo copyFromOrdmoip(OrdmoipInfo source) {
		InfoCopier<CusparInfo, OrdmoipInfo> copier = new CusparCopyOrdmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparInfo> copyFromOrdmoip(List<OrdmoipInfo> sources) {
		InfoCopier<CusparInfo, OrdmoipInfo> copier = new CusparCopyOrdmoip();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static CusparInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<CusparInfo, CrecardInfo> copier = new CusparCopyCrecard();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<CusparInfo, CrecardInfo> copier = new CusparCopyCrecard();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CusparInfo copyFromPayord(PayordInfo source) {
		InfoCopier<CusparInfo, PayordInfo> copier = new CusparCopyPayord();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<CusparInfo, PayordInfo> copier = new CusparCopyPayord();
		return copier.makeCopy(sources);
	}		
	
	
	
	public static CusparInfo copyFromPaytus(PaytusInfo source) {
		InfoCopier<CusparInfo, PaytusInfo> copier = new CusparCopyPaytus();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CusparInfo> copyFromPaytus(List<PaytusInfo> sources) {
		InfoCopier<CusparInfo, PaytusInfo> copier = new CusparCopyPaytus();
		return copier.makeCopy(sources);
	}		
}
