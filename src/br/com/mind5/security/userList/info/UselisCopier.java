package br.com.mind5.security.userList.info;


import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoCopier;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.security.userAuthentication.info.UauthInfo;

public final class UselisCopier {
	public static UselisInfo copyFromCusmoip(CusmoipInfo source) {
		InfoCopier<UselisInfo, CusmoipInfo> copier = new UselisCopyCusmoip();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UselisInfo> copyFromCusmoip(List<CusmoipInfo> sources) {
		InfoCopier<UselisInfo, CusmoipInfo> copier = new UselisCopyCusmoip();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UselisInfo copyFromUauth(UauthInfo source) {
		InfoCopier<UselisInfo, UauthInfo> copier = new UselisCopyUauth();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UselisInfo> copyFromUauth(List<UauthInfo> sources) {
		InfoCopier<UselisInfo, UauthInfo> copier = new UselisCopyUauth();
		return copier.makeCopy(sources);
	}	
	
	
	
	public static UselisInfo copyFromEmpnap(EmpnapInfo source) {
		InfoCopier<UselisInfo, EmpnapInfo> copier = new UselisCopyEmpnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UselisInfo> copyFromEmpnap(List<EmpnapInfo> sources) {
		InfoCopier<UselisInfo, EmpnapInfo> copier = new UselisCopyEmpnap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UselisInfo copyFromPhonap(PhonapInfo source) {
		InfoCopier<UselisInfo, PhonapInfo> copier = new UselisCopyPhonap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UselisInfo> copyFromPhonap(List<PhonapInfo> sources) {
		InfoCopier<UselisInfo, PhonapInfo> copier = new UselisCopyPhonap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UselisInfo copyFromAddresnap(AddresnapInfo source) {
		InfoCopier<UselisInfo, AddresnapInfo> copier = new UselisCopyAddresnap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UselisInfo> copyFromAddresnap(List<AddresnapInfo> sources) {
		InfoCopier<UselisInfo, AddresnapInfo> copier = new UselisCopyAddresnap();
		return copier.makeCopy(sources);
	}
	
	
	
	public static UselisInfo copyFromOwnerap(OwnerapInfo source) {
		InfoCopier<UselisInfo, OwnerapInfo> copier = new UselisCopyOwnerap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UselisInfo> copyFromOwnerap(List<OwnerapInfo> sources) {
		InfoCopier<UselisInfo, OwnerapInfo> copier = new UselisCopyOwnerap();
		return copier.makeCopy(sources);
	}
}
