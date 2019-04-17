package br.com.gda.business.person.info;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoCopierTemplate;

final class PersonCopyCus extends InfoCopierTemplate<PersonInfo, CusInfo>{
	
	public PersonCopyCus() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(CusInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		return result;
	}
}
