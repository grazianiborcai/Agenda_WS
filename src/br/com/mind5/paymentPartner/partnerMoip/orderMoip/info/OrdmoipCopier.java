package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;


import java.util.List;

import br.com.mind5.info.InfoCopierOneToMany;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class OrdmoipCopier {	
	public static List<OrdmoipInfo> copyFromMultmoipToPlace(MultmoipInfo source) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoipToPlace();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdmoipInfo> copyFromMultmoipToPlace(List<MultmoipInfo> sources) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoipToPlace();
		return copier.makeCopy(sources);
	}
	
	
	
	public static List<OrdmoipInfo> copyFromMultmoipToRead(MultmoipInfo source) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoipToRead();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OrdmoipInfo> copyFromMultmoipToRead(List<MultmoipInfo> sources) {
		InfoCopierOneToMany<OrdmoipInfo, MultmoipInfo> copier = new OrdmoipCopyMultmoipToRead();
		return copier.makeCopy(sources);
	}
}
