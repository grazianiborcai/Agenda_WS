package br.com.mind5.business.employee.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterAddressCod extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		if (recordInfo.addresses == null)
			return recordInfo;
		
		for (AddressInfo eachRecord : recordInfo.addresses) {
			eachRecord.codAddress = DefaultValue.number();
		}
		
		return recordInfo;
	}	
}
