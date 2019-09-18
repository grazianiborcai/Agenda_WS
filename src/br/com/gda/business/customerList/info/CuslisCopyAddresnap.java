package br.com.gda.business.customerList.info;


import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.InfoCopierTemplate;

final class CuslisCopyAddresnap extends InfoCopierTemplate<CuslisInfo, AddresnapInfo>{
	
	public CuslisCopyAddresnap() {
		super();
	}
	
	
	
	@Override protected CuslisInfo makeCopyHook(AddresnapInfo source) {
		CuslisInfo result = new CuslisInfo();
		result.codOwner = source.codOwner;
		result.codCustomer = source.codCustomer;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;		
	}
}
