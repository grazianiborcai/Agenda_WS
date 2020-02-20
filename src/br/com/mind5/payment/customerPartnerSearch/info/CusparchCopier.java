package br.com.mind5.payment.customerPartnerSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class CusparchCopier {		
	public static List<CusparchInfo> copyFromPayord(List<PayordInfo> sources) {
		InfoCopier<CusparchInfo, PayordInfo> copier = new CusparchCopyPayord();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static CusparchInfo copyFromPayord(PayordInfo source) {
		InfoCopier<CusparchInfo, PayordInfo> copier = new CusparchCopyPayord();
		return copier.makeCopy(source);
	}	
	
	
	
	public static List<CusparchInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<CusparchInfo, CusparInfo> copier = new CusparchCopyCuspar();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static CusparchInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<CusparchInfo, CusparInfo> copier = new CusparchCopyCuspar();
		return copier.makeCopy(source);
	}	
	
	
	
	public static List<CusparchInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<CusparchInfo, CrecardInfo> copier = new CusparchCopyCrecard();
		return copier.makeCopy(sources);
	}		
	
	
	
	public static CusparchInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<CusparchInfo, CrecardInfo> copier = new CusparchCopyCrecard();
		return copier.makeCopy(source);
	}		
	
	
	
	public static CusparchInfo copyFromCrecardRef(CrecardInfo source) {
		InfoCopier<CusparchInfo, CrecardInfo> copier = new CusparchCopyCrecardRef();
		return copier.makeCopy(source);
	}	
	
	
	
	public static List<CusparchInfo> copyFromCrecardRef(List<CrecardInfo> sources) {
		InfoCopier<CusparchInfo, CrecardInfo> copier = new CusparchCopyCrecardRef();
		return copier.makeCopy(sources);
	}	
}
