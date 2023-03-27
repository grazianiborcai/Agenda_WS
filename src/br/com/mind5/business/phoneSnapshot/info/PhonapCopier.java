package br.com.mind5.business.phoneSnapshot.info;


import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.info.InfoCopierOneToMany;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class PhonapCopier {	
	public static PhonapInfo copyFromCrecard(CrecardInfo source) {
		InfoCopier<PhonapInfo, CrecardInfo> copier = new PhonapCopyCrecard();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromCrecard(List<CrecardInfo> sources) {
		InfoCopier<PhonapInfo, CrecardInfo> copier = new PhonapCopyCrecard();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonapInfo copyFromCremoip(CremoipInfo source) {
		InfoCopier<PhonapInfo, CremoipInfo> copier = new PhonapCopyCremoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromCremoip(List<CremoipInfo> sources) {
		InfoCopier<PhonapInfo, CremoipInfo> copier = new PhonapCopyCremoip();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonapInfo copyFromCusmoip(CusmoipInfo source) {
		InfoCopier<PhonapInfo, CusmoipInfo> copier = new PhonapCopyCusmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromCusmoip(List<CusmoipInfo> sources) {
		InfoCopier<PhonapInfo, CusmoipInfo> copier = new PhonapCopyCusmoip();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static List<PhonapInfo> copyFromEmpnap(EmpnapInfo source) {
		InfoCopierOneToMany<PhonapInfo, EmpnapInfo> copier = new PhonapCopyEmpnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromEmpnap(List<EmpnapInfo> sources) {
		InfoCopierOneToMany<PhonapInfo, EmpnapInfo> copier = new PhonapCopyEmpnap();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static PhonapInfo copyFromStorap(StorapInfo source) {
		InfoCopier<PhonapInfo, StorapInfo> copier = new PhonapCopyStorap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromStorap(List<StorapInfo> sources) {
		InfoCopier<PhonapInfo, StorapInfo> copier = new PhonapCopyStorap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonapInfo copyFromEmpnapKey(EmpnapInfo source) {
		InfoCopier<PhonapInfo, EmpnapInfo> copier = new PhonapCopyEmpnapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromEmpnapKey(List<EmpnapInfo> sources) {
		InfoCopier<PhonapInfo, EmpnapInfo> copier = new PhonapCopyEmpnapKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonapInfo copyFromUserapKey(UserapInfo source) {
		InfoCopier<PhonapInfo, UserapInfo> copier = new PhonapCopyUserapKey();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromUserapKey(List<UserapInfo> sources) {
		InfoCopier<PhonapInfo, UserapInfo> copier = new PhonapCopyUserapKey();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PhonapInfo copyFromCuspar(CusparInfo source) {
		InfoCopier<PhonapInfo, CusparInfo> copier = new PhonapCopyCuspar();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PhonapInfo> copyFromCuspar(List<CusparInfo> sources) {
		InfoCopier<PhonapInfo, CusparInfo> copier = new PhonapCopyCuspar();
		return copier.makeCopy(sources);
	}
}
