package br.com.mind5.business.customer.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class CusSetterAddressCod extends InfoSetterTemplate<CusInfo> {
	
	@Override protected CusInfo setAttrHook(CusInfo recordInfo) {
		if (recordInfo.addresses == null)
			return recordInfo;
		
		for (AddressInfo eachRecord : recordInfo.addresses) {
			eachRecord.codAddress = DefaultValue.number();
		}
		
		return recordInfo;
	}	
}
