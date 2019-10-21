package br.com.mind5.business.person.info;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PersonCopyCus extends InfoCopierTemplate<PersonInfo, CusInfo>{
	
	public PersonCopyCus() {
		super();
	}
	
	
	
	@Override protected PersonInfo makeCopyHook(CusInfo source) {
		PersonInfo result = PersonInfo.copyFrom(source.personData);
		return result;
	}
}
